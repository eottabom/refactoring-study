package io.github.eottabom.refactoring._03_long_function._09_preserve_whole_object;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring._01_smell_mysterious_name.Comment;
import io.github.eottabom.refactoring._01_smell_mysterious_name.Post;
import io.github.eottabom.refactoring._03_long_function.factory.PostFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudyDashboard {

	private static final Logger logger = LoggerFactory.getLogger(StudyDashboard.class);

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
							Participant participant = participants.stream()
								.filter((p) -> p.username().equals(username))
								.findFirst()
								.orElseGet(() -> {
									Participant newP = new Participant(username);
									participants.add(newP);
									return newP;
								});

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

		try (FileWriter fileWriter = new FileWriter("participants.md");
				PrintWriter writer = new PrintWriter(fileWriter)) {
			participants.sort(Comparator.comparing(Participant::username));
			writer.print(header(participants.size()));
			participants.forEach((p) -> {
				// @formatter:off
				/*
					p.username(), p.homework() 이런 경우에는
					participant 를 직접 넘겨주게 수정할 수 있다.
					이렇게 되면 매개변수를 2개에서 1개로 줄일 수 있고,
					Preserve whole object 를 적용했다고 할 수 있다.

					!! 이때, 고민해야하는 부분은
					각각의 함수가 participant 에 의존하는게 맞는가? 아니면 이전 매개변수가 맞는지?
					이 함수를 다른 도메인에도 적용할 계획이 있는가 등을 고민해야하고,
					다른 곳을 적용할 것이라면, 기존 매개변수가 나을 수도 있다고 판단 할 수도 있고,
					적절히 판단해야 한다.

					!! 또 고민해야하는 부분은,
					각각의 메서드들이 이 위치가 적절한가를 고민해봐야 한다.
					그게 바로 getRate 메서드인데..
				 */
				// @formatter:on
				String markdownForHomework = getMarkdownForParticipant(p);
				writer.print(markdownForHomework);
			});
		}
		catch (Exception ex) {
			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
		}
	}

	// String username, Map<Integer, Boolean> homework 대신 participant
	private String getMarkdownForParticipant(Participant participant) {
		// return String.format("| %s %s | %.2f%% |\n", username, checkMark(homework,
		// this.totalNumberOfEvents), getRate(homework));
		// checkMark 에서는 participant.homework() 를 넘길 수도 있지만, participant 를 넘겨도 된다.

		// return String.format("| %s %s | %.2f%% |\n", participant.username(),
		// checkMark(participant, this.totalNumberOfEvents), getRate(participant));
		return String.format("| %s %s | %.2f%% |\n", participant.username(),
				checkMark(participant, this.totalNumberOfEvents), participant.getRate(this.totalNumberOfEvents));
	}

	// Map<Integer, Boolean> homework 대신에 participant
	// @formatter:off
	/*
		getRate 이 메서드는 해당 클래스에 위치해야하는게 맞는지를 고민해야한다.
		이 메서드를 보면, participant 의 homework 를 사용하는데,
		totalNumberOfEvents 를 파라미터로 받게 되면 다른 곳으로 이동하는 것이 좋을 수도 있다. (move method)

		이 메서드를 Participant 로 넘겨버리고,
		getMarkdownForParticipant 에서 코드를 수정 할 수도 있다.
	 */

//	private double getRate(Participant participant) {
//		long count = participant.homework().values().stream().filter((value) -> value).count();
//		return (double) (count * 100) / this.totalNumberOfEvents;
//	}
	// @formatter:on
	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 | | --- | --- | --- | --- | --- |
	 */
	// totalEvents 매개변수 제거
	private String header(int totalNumberOfParticipants) {
		StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));
		for (int index = 1; index <= this.totalNumberOfEvents; index++) {
			header.append(String.format(" %d주차 |", index));
		}
		header.append(" 참석율 |\n");

		header.append("| --- ".repeat(this.totalNumberOfEvents + 2)).append("|\n");
		return header.toString();
	}

	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
	 */
	// Map<Integer, Boolean> homework 대신에 Participant participant
	private String checkMark(Participant participant, int totalNumberOfEvents) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= totalNumberOfEvents; i++) {
			// @formatter:off
//			line.append(homework.getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
			// @formatter:on
			line.append(participant.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

}
