package io.github.eottabom.refactoring._03_long_function._11_decompose_conditional;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudyPrinter {

	private static final Logger logger = LoggerFactory.getLogger(StudyPrinter.class);

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
