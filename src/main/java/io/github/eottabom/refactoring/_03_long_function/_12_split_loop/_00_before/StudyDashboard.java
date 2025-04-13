package io.github.eottabom.refactoring._03_long_function._12_split_loop._00_before;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;
import io.github.eottabom.refactoring._03_long_function._12_split_loop.Participant;
import io.github.eottabom.refactoring._03_long_function._12_split_loop.StudyPrinter;
import io.github.eottabom.refactoring._03_long_function.factory.PostFactory;

public class StudyDashboard {

	private final int totalNumberOfEvents;

	private final Participant[] firstParticipantsForEachEvent;

	public StudyDashboard(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
	}

	public static void main(String[] args) throws InterruptedException {

		new StudyDashboard(15).print();
	}

	private void print() throws InterruptedException {
		List<Participant> participants = new CopyOnWriteArrayList<>();

		CountDownLatch latch = new CountDownLatch(this.totalNumberOfEvents);

		try (ExecutorService service = Executors.newFixedThreadPool(4)) {
			for (int index = 1; index <= this.totalNumberOfEvents; index++) {
				int eventId = index;
				service.execute(() -> {

					try {
						Post post = PostFactory.getPost(eventId);

						LocalDateTime firstCreatedAt = null;
						Participant first = null;
						for (Comment comment : post.comments()) {
							String username = comment.userName();

							Participant participant = findParticipant(participants, username);
							participant.setHomeworkDone(eventId);

							if (firstCreatedAt == null || comment.createAt().isBefore(firstCreatedAt)) {
								firstCreatedAt = comment.createAt();
								first = participant;
							}
						}
						firstParticipantsForEachEvent[eventId - 1] = first;
					}
					finally {
						latch.countDown();
					}
				});
			}
		}
		latch.await();

		new StudyPrinter(this.totalNumberOfEvents, participants).execute();
		printFirstParticipants();
	}

	private void printFirstParticipants() {
		Arrays.stream(this.firstParticipantsForEachEvent).forEach(p -> System.out.println(p.username()));
	}

	private Participant findParticipant(List<Participant> participants, String username) {
		return isNewParticipant(participants, username) ?
				createNewParticipant(participants, username) :
				findExistingParticipant(participants, username);
	}

	private Participant findExistingParticipant(List<Participant> participants, String username) {
		Participant participant;
		participant = participants.stream().filter((p) -> p.username().equals(username)).findFirst().orElseThrow();
		return participant;
	}

	private Participant createNewParticipant(List<Participant> participants, String username) {
		Participant participant;
		participant = new Participant(username);
		participants.add(participant);
		return participant;
	}

	private boolean isNewParticipant(List<Participant> participants, String username) {
		return participants.stream().noneMatch((p) -> p.username().equals(username));
	}

}
