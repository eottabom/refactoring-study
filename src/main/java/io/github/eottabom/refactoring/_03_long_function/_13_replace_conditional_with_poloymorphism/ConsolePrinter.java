package io.github.eottabom.refactoring._03_long_function._13_replace_conditional_with_poloymorphism;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ConsolePrinter extends StudyPrinter {

	public ConsolePrinter(int totalNumberOfEvents, List<Participant> participants) {
		super(totalNumberOfEvents, participants);
	}

	@Override
	public void execute() {
		this.participants.forEach((p) -> {
			System.out.printf("%s %s:%s\n", p.username(), checkMark(p, this.totalNumberOfEvents), p.getRate(this.totalNumberOfEvents));
		});
	}
}
