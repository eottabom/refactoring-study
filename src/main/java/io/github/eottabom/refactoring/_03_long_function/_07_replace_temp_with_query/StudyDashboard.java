package io.github.eottabom.refactoring._03_long_function._07_replace_temp_with_query;

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

	public static void main(String[] args) throws InterruptedException {
		new StudyDashboard().print();
	}

	private void print() throws InterruptedException {
		List<Participant> participants = new CopyOnWriteArrayList<>();
		int totalNumberOfEvents = 15;

		CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

		try (ExecutorService service = Executors.newFixedThreadPool(4)) {
			for (int index = 1; index <= totalNumberOfEvents; index++) {
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
			writer.print(header(totalNumberOfEvents, participants.size()));
			// @formatter:off
			participants.forEach((p) -> {
				// 참석율 계산
				// STEP2
//				long count = p.homework().values().stream().filter((value) -> value).count();
//				double rate = (double) (count * 100) / totalNumberOfEvents;

				/*
					Step1) 메서드 분리
					한 줄 짜리 markdown 을 만들어주는 부분인데,
					한 라인 조차 읽기가 힘어서 하나의 메서드로 분리해준다.

					AS-IS
					String markdown = String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents),
						rate);

					TO-BE
					String markdownForHomework = getMarkdownForParticipant(totalNumberOfEvents, p, rate);

					private String getMarkdownForParticipant(int totalNumberOfEvents, Participant p, double rate) {
						String markdown = String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents), rate);
						return markdown;
					}

				 */

//				String markdown = String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents),
//						rate);

				/*
					STEP2) 메서드 하나에 파라미터가 3개가 되면 조금 많다고 느껴지기 시작한다.
					예제에서 그러면 rate 를 없앨 수 있는데,
					참석율 계산하는 부분에서,
					long count = p.homework().values().stream().filter((value) -> value).count();
					double rate = (double) (count * 100) / totalNumberOfEvents;

					이 부분을 메서드로 빼고,
					private double getRate(int totalNumberOfEvents, Participant p) {
						long count = p.homework().values().stream().filter((value) -> value).count();
						return (double) (count * 100) / totalNumberOfEvents;
					}

					메서드 안에서 호출하게 하면,
					rate 라는 파라미터로 추가하지 않아도 된다.
					private String getMarkdownForParticipant(int totalNumberOfEvents, Participant p) {
						return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents),
						getRate(totalNumberOfEvents, p));
					}

					이게 임시 변수를 Query 라는 지칭하는 getRate 라는 함수로 빼냈을 때 얻을 수 있는 장점 파라미터를 줄일 수 있다는 장점이 있다.
					파라미터들로 파악할 수 있는 정보라면, 파라미터를 줄일 수 있다.
				 */

//				String markdownForHomework = getMarkdownForParticipant(totalNumberOfEvents, p, rate);
				String markdownForHomework = getMarkdownForParticipant(totalNumberOfEvents, p);

				writer.print(markdownForHomework);
			});
			// @formatter:on
		}
		catch (Exception ex) {
			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
		}
	}

	// STEP1) 메서드 추출하기
	private String getMarkdownForParticipant(int totalNumberOfEvents, Participant p, double rate) {
		return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents), rate);
	}

	// STEP2) 매개변수 줄이기
	private String getMarkdownForParticipant(int totalNumberOfEvents, Participant p) {
		return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents),
				getRate(totalNumberOfEvents, p));
	}

	private double getRate(int totalNumberOfEvents, Participant p) {
		long count = p.homework().values().stream().filter((value) -> value).count();
		return (double) (count * 100) / totalNumberOfEvents;
	}

	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 | | --- | --- | --- | --- | --- |
	 */
	private String header(int totalEvents, int totalNumberOfParticipants) {
		StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));
		for (int index = 1; index <= totalEvents; index++) {
			header.append(String.format(" %d주차 |", index));
		}
		header.append(" 참석율 |\n");

		header.append("| --- ".repeat(totalEvents + 2)).append("|\n");
		return header.toString();
	}

	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
	 */
	private String checkMark(Participant p, int totalEvents) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= totalEvents; i++) {
			line.append(p.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

}
