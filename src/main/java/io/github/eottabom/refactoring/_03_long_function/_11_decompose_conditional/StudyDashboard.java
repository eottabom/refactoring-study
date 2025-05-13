package io.github.eottabom.refactoring._03_long_function._11_decompose_conditional;

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

	// @formatter:off
	/*
		참여자를 찾는 메서드인데, 의도를 파악하기 어렵다.
	 */
	// @formatter:on
	private Participant findParticipant(List<Participant> participants, String username) {
		Participant participant = null;
		// @formatter:off
		// isNewParticipant 조건문도 의미를 부여를 하는 것이 decompose conditional 이다.
		// 이 부분도 삼항 연산자로 변경할 수 있다.

		// AS-IS
//		if (isNewParticipant(participants, username)) {
//			participant = createNewParticipant(participants, username);
//		}
//		else {
//			participant = findExistingParticipant(participants, username);
//		}
//
//		return participant;

		// @formatter:on
		// TO-BE
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
