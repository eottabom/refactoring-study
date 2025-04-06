package io.github.eottabom.refactoring._03_long_function._00_before;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;
import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class StudyDashboard {

	public static void main(String[] args) throws InterruptedException {
		new StudyDashboard().print();
	}

	private void print() throws InterruptedException {
		List<Participant> participants = new CopyOnWriteArrayList<>();
		int totalNumberOfEvents = 15;

		ExecutorService service = Executors.newFixedThreadPool(4);
		CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

		for (int index = 1; index <= totalNumberOfEvents; index++) {
			int eventId = index;
			service.execute(() -> {
				Post post = PostFactory.getPost(eventId);

				for (Comment comment : post.comments()) {
					String username = comment.userName();
					Participant participant = participants.stream()
							.filter(p -> p.username().equals(username))
							.findFirst()
							.orElseGet(() -> {
								Participant newP = new Participant(username);
								participants.add(newP);
								return newP;
							});

					participant.setHomeworkDone(eventId);
				}

				latch.countDown();
			});
		}

		latch.await();
		service.shutdown();

		try (FileWriter fileWriter = new FileWriter("participants.md");
			 PrintWriter writer = new PrintWriter(fileWriter)) {
			participants.sort(Comparator.comparing(Participant::username));
			writer.print(header(totalNumberOfEvents, participants.size()));
			participants.forEach(p -> {
				double rate = p.getRate(totalNumberOfEvents);
				String markdown = String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents), rate);
				writer.print(markdown);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String header(int totalEvents, int totalNumberOfParticipants) {
		StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));
		for (int index = 1; index <= totalEvents; index++) {
			header.append(String.format(" %d주차 |", index));
		}
		header.append(" 참석율 |\n");

		header.append("| --- ".repeat(totalEvents + 2)).append("|\n");
		return header.toString();
	}

	private String checkMark(Participant p, int totalEvents) {
		StringBuilder line = new StringBuilder();
		for (int i = 1; i <= totalEvents; i++) {
			line.append(p.homework().getOrDefault(i, false) ? "|:white_check_mark:" : "|:x:");
		}
		return line.toString();
	}
}
