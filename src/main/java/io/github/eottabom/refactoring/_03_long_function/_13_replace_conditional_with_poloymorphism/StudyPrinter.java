package io.github.eottabom.refactoring._03_long_function._13_replace_conditional_with_poloymorphism;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class StudyPrinter {

	private static final Logger logger = LoggerFactory.getLogger(StudyPrinter.class);

	// STEP2) 상위 클래스에서 사용하는 필드들을 private -> protected 로 변경한다.
	protected final int totalNumberOfEvents;

	protected final List<Participant> participants;

	public StudyPrinter(int totalNumberOfEvents, List<Participant> participants) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		this.participants = participants;
		this.participants.sort(Comparator.comparing(Participant::username));
	}

	// @formatter:off
	// STEP5) execute 는 abstract 로 변경해줄 수 있다 클래스도 abstract 가 되어야 한다.

	public abstract void execute();

	// public void execute() {
		// printerMode 에 따라서 코드가 길어지는데,
		// STEP1)) 이를 다형성을 이용해서 분리해본다.
		// 각각의 Cvs, Console, Markdown Printer 를 만들게 되면,
		// printerMode 는 없어도 된다.

		/*
		switch (printerMode) {
			case CVS -> {
				try (FileWriter fileWriter = new FileWriter("participants.cvs");
					 PrintWriter writer = new PrintWriter(fileWriter)) {
					writer.println(cvsHeader(this.participants.size()));
					this.participants.forEach(p -> {
						writer.println(getCvsForParticipant(p));
					});
				}
				catch (Exception ex) {
					logger.error("An error occurred while writing the file: {}", ex.getMessage(), ex);
				}
			}
			case CONSOLE -> {
				this.participants.forEach((p) -> {
					System.out.printf("%s %s:%s\n", p.username(), checkMark(p, this.totalNumberOfEvents), p.getRate(this.totalNumberOfEvents));
				});
			}
			case MARKDOWN -> {
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
		}
		*/
	// }

	// STEP3) 각 클래스에서 사용되어야 하는 메서드들도 각 클래스도 이동시킨다.

	// STEP4) checkMark 는 공통으로 사용하니깐, protected 로 변경해준다.
	@SuppressWarnings("checkstyle:JavadocMethod")
	/**
	 * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
	 */
	protected String checkMark(Participant participant, int totalNumberOfEvents) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= totalNumberOfEvents; i++) {
			line.append(participant.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}

	// @formatter:on
}
