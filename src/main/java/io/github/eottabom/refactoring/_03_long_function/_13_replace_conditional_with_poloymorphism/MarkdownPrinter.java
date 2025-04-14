package io.github.eottabom.refactoring._03_long_function._13_replace_conditional_with_poloymorphism;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarkdownPrinter extends StudyPrinter {

	private static final Logger logger = LoggerFactory.getLogger(MarkdownPrinter.class);

	public MarkdownPrinter(int totalNumberOfEvents, List<Participant> participants) {
		super(totalNumberOfEvents, participants);
	}

	@Override
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



	private String getMarkdownForParticipant(Participant participant) {
		return String.format("| %s %s | %.2f%% |\n", participant.username(),
				checkMark(participant, this.totalNumberOfEvents), participant.getRate(this.totalNumberOfEvents));
	}
}
