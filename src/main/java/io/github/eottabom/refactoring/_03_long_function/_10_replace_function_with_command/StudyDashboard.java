package io.github.eottabom.refactoring._03_long_function._10_replace_function_with_command;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;
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

							// 이 부분도 코드를 정리 해줄 수도 있다
							// @formatter:off
//							Participant participant = participants.stream()
//									.filter((p) -> p.username().equals(username))
//									.findFirst()
//									.orElseGet(() -> {
//										Participant newP = new Participant(username);
//										participants.add(newP);
//										return newP;
//									});
							// @formatter:on
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

		// @formatter:off
		/*
			markdown 파일로 만들어주는 부분인데,
			이 부분이 추후에 콘솔에 출력하는 방법도 있고, CSV 포맷으로 내보내는 방법도 있을 텐데,
			앞으로 복잡성이 증가할 여지가 있다.

			STEP1) 메서드로 추출

			try (FileWriter fileWriter = new FileWriter("participants.md");
					PrintWriter writer = new PrintWriter(fileWriter)) {
				participants.sort(Comparator.comparing(Participant::username));
				writer.print(header(participants.size()));
				participants.forEach((p) -> {
					String markdownForHomework = getMarkdownForParticipant(p);
					writer.print(markdownForHomework);
				});
			}
			catch (Exception ex) {
				logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
			}
		 */


		/*
			STEP4)
			StudyPrinter 로 (Command 로) 빼내서, execute 메서드 대신에,
			new StudyPrinter(this.totalNumberOfEvents, participants).execute();
			이렇게 사용 가능해진다.
		 */
		// @formatter:on
		// execute(participants);
		new StudyPrinter(this.totalNumberOfEvents, participants).execute();
	}

	private Participant findParticipant(List<Participant> participants, String username) {
		return participants.stream().filter((p) -> p.username().equals(username)).findFirst().orElseGet(() -> {
			Participant newP = new Participant(username);
			participants.add(newP);
			return newP;
		});
	}

	// @formatter:off
	// STEP2) Command 로 뽑아낸다. -> interface 가 될 수도, class 가 될 수도.
	// -> StudyPrinter class 를 만들고 이것을 이동시킨다.
//	private void execute(List<Participant> participants) {
//		try (FileWriter fileWriter = new FileWriter("participants.md");
//				PrintWriter writer = new PrintWriter(fileWriter)) {
//			participants.sort(Comparator.comparing(Participant::username));
//			writer.print(header(participants.size()));
//			participants.forEach((p) -> {
//				String markdownForHomework = getMarkdownForParticipant(p);
//				writer.print(markdownForHomework);
//			});
//		}
//		catch (Exception ex) {
//			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
//		}
//	}

	/*
		STEP3) move method
		StudyPrinter 로 뽑아냈더니, 더 이상 getMarkdownForParticipant, header, checkMark 메서드는
		StudyDashboard 클래스에서 사용하지 않게 된다.
	 */
//	private String getMarkdownForParticipant(Participant participant) {
//		return String.format("| %s %s | %.2f%% |\n", participant.username(),
//				checkMark(participant, this.totalNumberOfEvents), participant.getRate(this.totalNumberOfEvents));
//	}
//
//	@SuppressWarnings("checkstyle:JavadocMethod")
//	/**
//	 * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 | | --- | --- | --- | --- | --- |
//	 */
//	private String header(int totalNumberOfParticipants) {
//		StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));
//		for (int index = 1; index <= this.totalNumberOfEvents; index++) {
//			header.append(String.format(" %d주차 |", index));
//		}
//		header.append(" 참석율 |\n");
//
//		header.append("| --- ".repeat(this.totalNumberOfEvents + 2)).append("|\n");
//		return header.toString();
//	}
//
//	@SuppressWarnings("checkstyle:JavadocMethod")
//	/**
//	 * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
//	 */
//	private String checkMark(Participant participant, int totalNumberOfEvents) {
//		StringBuilder line = new StringBuilder();
//		for (int i = 1; i <= totalNumberOfEvents; i++) {
//			line.append(participant.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
//		}
//		return line.toString();
//	}
	// @formatter:on

}
