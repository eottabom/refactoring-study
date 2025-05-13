package io.github.eottabom.refactoring._03_long_function._13_replace_conditional_with_poloymorphism;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring._01_smell_mysterious_name.Comment;
import io.github.eottabom.refactoring._01_smell_mysterious_name.Post;
import io.github.eottabom.refactoring._03_long_function.factory.PostFactory;

public class StudyDashboard {

	private final int totalNumberOfEvents;

	private final List<Participant> participants;

	private final Participant[] firstParticipantsForEachEvent;

	public StudyDashboard(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		this.participants = new CopyOnWriteArrayList<>();
		this.firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
	}

	public static void main(String[] args) throws InterruptedException {
		new StudyDashboard(15).print();
	}

	private void print() throws InterruptedException {
		analyzeHomeworkSubmissions();

		// STEP6 이제는 사용할 printer 를 사용하면된다.
		// new StudyPrinter(this.totalNumberOfEvents, this.participants).execute();

		// STEP7 각 타입에 따라서 쓰고 싶다 -> 팩토리로 하면 된다.
		// 근데 어차피 타입을 받아서 동적으로 사용해야하는데, 그럴빠에는 이렇게 사용해도 상관은 없을 것이다.
		new CvsPrinter(this.totalNumberOfEvents, this.participants).execute();
		printFirstParticipants();
	}

	private void analyzeHomeworkSubmissions() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(this.totalNumberOfEvents);

		try (ExecutorService service = Executors.newFixedThreadPool(4)) {
			for (int index = 1; index <= this.totalNumberOfEvents; index++) {
				int eventId = index;
				service.execute(() -> {

					try {
						Post post = PostFactory.getPost(eventId);
						checkHomework(post, eventId);
						this.firstParticipantsForEachEvent[eventId - 1] = findFirst(post);
					}
					finally {
						latch.countDown();
					}
				});
			}
		}
		latch.await();
	}

	private Participant findFirst(Post post) {
		LocalDateTime firstCreatedAt = null;
		Participant first = null;
		for (Comment comment : post.comments()) {

			String username = comment.userName();
			Participant participant = findParticipant(username);

			if (firstCreatedAt == null || comment.createAt().isBefore(firstCreatedAt)) {
				firstCreatedAt = comment.createAt();
				first = participant;
			}
		}
		return first;
	}

	private void checkHomework(Post post, int eventId) {
		for (Comment comment : post.comments()) {
			String username = comment.userName();

			Participant participant = findParticipant(username);
			participant.setHomeworkDone(eventId);
		}
	}

	private void printFirstParticipants() {
		Arrays.stream(this.firstParticipantsForEachEvent).forEach((p) -> System.out.println(p.username()));
	}

	private Participant findParticipant(String username) {
		return isNewParticipant(username) ? createNewParticipant(username) : findExistingParticipant(username);
	}

	private Participant findExistingParticipant(String username) {
		Participant participant;
		participant = this.participants.stream().filter((p) -> p.username().equals(username)).findFirst().orElseThrow();
		return participant;
	}

	private Participant createNewParticipant(String username) {
		Participant participant;
		participant = new Participant(username);
		this.participants.add(participant);
		return participant;
	}

	private boolean isNewParticipant(String username) {
		return this.participants.stream().noneMatch((p) -> p.username().equals(username));
	}

}
