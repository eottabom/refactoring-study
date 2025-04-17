package io.github.eottabom.refactoring._04_long_parameter_list._16_combine_functions_into_class;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;
import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;
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

		// @formatter:off
		/*
		 * 이 부분은 print 를 하는 부분인데, 이를 extract function 을 하게 되면,
		 * 당장 participant 매개변수가 필요하다는 것을 알 수 있다.
		 * STEP1) StudyPrinter 라는 클래스를 만들어서, 필요한 매개변수들을 필드로 선언해주고 생성자도 만들어준다.
		 * STEP2) 그런다음에 아래 부분을 메서드로 추출한다.
		 */
//		try (FileWriter fileWriter = new FileWriter("participants.md");
//			 PrintWriter writer = new PrintWriter(fileWriter)) {
//			participants.sort(Comparator.comparing(Participant::username));
//			writer.print(header(this.totalNumberOfEvents, participants.size()));
//			participants.forEach((p) -> {
//				String markdownForHomework = getMarkdownForParticipant(p.username(), p.homework());
//				writer.print(markdownForHomework);
//			});
//		}
//		catch (Exception ex) {
//			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
//		}

		// STEP2
//		print(participants);

		// STEP3# 그리고 StudyPrinter 라는 클래스를 사용하고, print 메세드를 StudyPrinter 로 옮긴다.
		new StudyPrinter(this.totalNumberOfEvents, participants).print();

		// @formatter:on
	}

	// STEP4) move method
//	private void print(List<Participant> participants) {
//		try (FileWriter fileWriter = new FileWriter("participants.md");
//				PrintWriter writer = new PrintWriter(fileWriter)) {
//			participants.sort(Comparator.comparing(Participant::username));
//			writer.print(header(this.totalNumberOfEvents, participants.size()));
//			participants.forEach((p) -> {
//				String markdownForHomework = getMarkdownForParticipant(p.username(), p.homework());
//				writer.print(markdownForHomework);
//			});
//		}
//		catch (Exception ex) {
//			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
//		}
//	}

	// move method
	private String getMarkdownForParticipant(String username, Map<Integer, Boolean> homework) {
		return String.format("| %s %s | %.2f%% |\n", username, checkMark(homework), getRate(homework));
	}

	// move method
	private double getRate(Map<Integer, Boolean> homework) {
		long count = homework.values().stream().filter((value) -> value).count();
		return (double) (count * 100) / this.totalNumberOfEvents;
	}

	// move method
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

	// move method
	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
	 */
	private String checkMark(Map<Integer, Boolean> homework) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= this.totalNumberOfEvents; i++) {
			line.append(homework.getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

}
