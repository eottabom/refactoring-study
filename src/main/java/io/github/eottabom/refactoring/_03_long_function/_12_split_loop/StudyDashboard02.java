package io.github.eottabom.refactoring._03_long_function._12_split_loop;

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

public class StudyDashboard02 {

	private final int totalNumberOfEvents;

	// add
	private final List<Participant> participants;

	private final Participant[] firstParticipantsForEachEvent;

	public StudyDashboard02(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		// add
		this.participants = new CopyOnWriteArrayList<>();
		this.firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
	}

	public static void main(String[] args) throws InterruptedException {
		new StudyDashboard02(15).print();
	}

	private void print() throws InterruptedException {
		// 클래스 전반적으로 보면 participants 을 매개변수로 전달하는 것을 볼 수 있는데,
		// 그렇다는 것을 인스턴스화 필드로 올려줄 수 있고, 필드로 이미 있기 때문에 매개 변수로 넘기지 않아도 된다.
		// List<Participant> participants = new CopyOnWriteArrayList<>();

		// 멀티스레딩 프로그래밍 하는 부분도 하나의 메서드로 추출할 수 있다.
		// remove participants param
		analyzeHomeworkSubmissions();

		new StudyPrinter(this.totalNumberOfEvents, this.participants).execute();
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
						// remove participants param
						checkHomework(post, eventId);
						// remove participants param;
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

	// remove participants param
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

	// remove participants param
	private void checkHomework(Post post, int eventId) {
		for (Comment comment : post.comments()) {
			String username = comment.userName();

			Participant participant = findParticipant(username);
			participant.setHomeworkDone(eventId);
		}
	}

	// remove participants param
	private void printFirstParticipants() {
		Arrays.stream(this.firstParticipantsForEachEvent).forEach((p) -> System.out.println(p.username()));
	}

	// remove participants param
	private Participant findParticipant(String username) {
		return isNewParticipant(username) ? createNewParticipant(username) : findExistingParticipant(username);
	}

	// remove participants param
	private Participant findExistingParticipant(String username) {
		Participant participant;
		participant = this.participants.stream().filter((p) -> p.username().equals(username)).findFirst().orElseThrow();
		return participant;
	}

	// remove participants param
	private Participant createNewParticipant(String username) {
		Participant participant;
		participant = new Participant(username);
		this.participants.add(participant);
		return participant;
	}

	// remove participants param
	private boolean isNewParticipant(String username) {
		return this.participants.stream().noneMatch((p) -> p.username().equals(username));
	}

}
