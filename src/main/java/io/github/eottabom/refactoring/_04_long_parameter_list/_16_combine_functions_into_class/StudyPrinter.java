package io.github.eottabom.refactoring._04_long_parameter_list._16_combine_functions_into_class;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 이 클래스로 메서드들을 옮겨오고 있는데 이것이 바로 combine functions into class 리팩토링을 하고 있는 것.
// 그러면서 메서드의 매개변수들을 많이 줄일 수 있고, 의미를 파악하기 쉬워진다.
public class StudyPrinter {

	private static final Logger logger = LoggerFactory.getLogger(StudyPrinter.class);

	private final int totalNumberOfEvents;

	private final List<Participant> participants;

	public StudyPrinter(int totalNumberOfEvents, List<Participant> participants) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		this.participants = participants;
	}

	// STEP5) 매개변수를 제거한다.
	// STEP6) 그 이후에 필요로하는 것들인 header, getMarkdownForParticipant 메서드도 옮겨온다.
	protected void print() {
		try (FileWriter fileWriter = new FileWriter("participants.md");
			 PrintWriter writer = new PrintWriter(fileWriter)) {
			this.participants.sort(Comparator.comparing(Participant::username));
			writer.print(header());
			this.participants.forEach((p) -> {
				String markdownForHomework = getMarkdownForParticipant(p.username(), p.homework());
				writer.print(markdownForHomework);
			});
		}
		catch (Exception ex) {
			logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
		}
	}

	private String getMarkdownForParticipant(String username, Map<Integer, Boolean> homework) {
		return String.format("| %s %s | %.2f%% |\n", username, checkMark(homework), getRate(homework));
	}

	private double getRate(Map<Integer, Boolean> homework) {
		long count = homework.values().stream().filter((value) -> value).count();
		return (double) (count * 100) / this.totalNumberOfEvents;
	}

	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 | | --- | --- | --- | --- | --- |
	 */
	// 여기서도 totalNumberOfParticipants 매개변수를 제거할 수 있다.
	// private String header(int totalNumberOfParticipants)
	private String header() {
		StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", this.participants.size()));
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
	private String checkMark(Map<Integer, Boolean> homework) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= this.totalNumberOfEvents; i++) {
			line.append(homework.getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

}
