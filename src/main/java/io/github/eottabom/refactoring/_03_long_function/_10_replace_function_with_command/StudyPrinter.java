package io.github.eottabom.refactoring._03_long_function._10_replace_function_with_command;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
	Command 로 뽑아내다보니,
	기존의 StudyDashboard 는 코드 양이 줄어들었고,
	StudyPrinter 라는 클래스는, 보다 확장성이 늘어나게 된 구조로 변경 되었다.
 */
public class StudyPrinter {

	private static final Logger logger = LoggerFactory.getLogger(StudyPrinter.class);

	/*
		getMarkdownForParticipant, header 메서드를 가져오고 보니,
		totalNumberOfEvents 변수가 필요한데,
		이를 필드로 만들어줘보자~

		execute 이 메서드도 사실, List<Participant> participants 파라미터가 필요 없다.
		-> 이것도 필드로 빼자~
	 */

	private final int totalNumberOfEvents;

	private final List<Participant> participants;

	public StudyPrinter(int totalNumberOfEvents, List<Participant> participants) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		this.participants = participants;
	}

	public void execute() {
		try (FileWriter fileWriter = new FileWriter("participants.md");
			 PrintWriter writer = new PrintWriter(fileWriter)) {
			this.participants.sort(Comparator.comparing(Participant::username));
			writer.print(header(this.participants.size()));
			this.participants.forEach((p) -> {
				String markdownForHomework = getMarkdownForParticipant(p);
				writer.print(markdownForHomework);
			});
		}
		catch (Exception ex) {
			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
		}
	}

	private String getMarkdownForParticipant(Participant participant) {
		return String.format("| %s %s | %.2f%% |\n", participant.username(),
				checkMark(participant, this.totalNumberOfEvents), participant.getRate(this.totalNumberOfEvents));
	}

	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 | | --- | --- | --- | --- | --- |
	 */
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
	private String checkMark(Participant participant, int totalNumberOfEvents) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= totalNumberOfEvents; i++) {
			line.append(participant.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

}
