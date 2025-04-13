package io.github.eottabom.refactoring._03_long_function._11_decompose_conditional._00_before;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;
import io.github.eottabom.refactoring._03_long_function._11_decompose_conditional.Participant;
import io.github.eottabom.refactoring._03_long_function._11_decompose_conditional.StudyPrinter;
import io.github.eottabom.refactoring._03_long_function.factory.PostFactory;

public class StudyDashboard {

	private final int totalNumberOfEvents;

	public StudyDashboard(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
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

						for (Comment comment : post.comments()) {
							String username = comment.userName();

							Participant participant = findParticipant(participants, username);
							participant.setHomeworkDone(eventId);
						}
					}
					finally {
						latch.countDown();
					}
				});
			}
		}
		latch.await();

		new StudyPrinter(this.totalNumberOfEvents, participants).execute();
	}

	private Participant findParticipant(List<Participant> participants, String username) {
		Participant participant = null;
		if (participants.stream().noneMatch((p) -> p.username().equals(username))) {
			participant = new Participant(username);
			participants.add(participant);
		}
		else {
			participant = participants.stream().filter((p) -> p.username().equals(username)).findFirst().orElseThrow();
		}

		return participant;
	}

}
