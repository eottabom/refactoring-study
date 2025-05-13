package io.github.eottabom.refactoring._03_long_function._08_02_Introduce_field;

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

	// @formatter:off
	/*
		이 클래스에서 totalNumberOfEvents 를 파라미터를 넘기지 않아도 된다.
		(사실 이건 Introduce_parameter_object 라기보단 Introduce_field)
	 */
	// @formatter:on
	// add
	private final int totalNumberOfEvents;

	// add
	public StudyDashboard(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
	}

	public static void main(String[] args) throws InterruptedException {
		// modify
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
			// totalNumberOfEvents 매개변수 제거
			writer.print(header(participants.size()));
			participants.forEach((p) -> {
				// totalNumberOfEvents 매개변수 제거
				String markdownForHomework = getMarkdownForParticipant(p);
				writer.print(markdownForHomework);
			});
		}
		catch (Exception ex) {
			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
		}
	}

	// totalNumberOfEvents 매개변수 제거
	private String getMarkdownForParticipant(Participant p) {
		return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p), getRate(p));
	}

	// totalNumberOfEvents 매개변수 제거
	private double getRate(Participant p) {
		long count = p.homework().values().stream().filter((value) -> value).count();
		return (double) (count * 100) / this.totalNumberOfEvents;
	}

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
	// totalEvents 매개변수 제거
	private String checkMark(Participant p) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= this.totalNumberOfEvents; i++) {
			line.append(p.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

}
