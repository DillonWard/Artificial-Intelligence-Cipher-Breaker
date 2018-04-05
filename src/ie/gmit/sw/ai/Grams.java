package ie.gmit.sw.ai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grams {

	private Map<String, Integer> grams;
	private double grade;
	private String fileName;

	public Grams(String fileName) {
		this.fileName = fileName;
		this.grams = new HashMap<String, Integer>();
	}// Constructor


	public Map<String, Integer> gramFactory() throws IOException {
		Stream<String> stream = Files.lines(Paths.get(fileName));

		grams = stream
				.map(tmp -> tmp.split(" "))
				.collect(Collectors.toMap(tmp -> tmp[0], tmp -> Integer.parseInt(tmp[1])));

		stream.close();
		return this.grams;
	}

	public double gradeDecrypt(String decryptedText) {
		double score = 0;
		int frequency = 0;

		for (int i = 0; i < decryptedText.length() - 4; i++) {
			if (grams.get(decryptedText.substring(i, i + 4)) != null) {
				frequency = grams.get(decryptedText.substring(i, i + 4));
			} else {
				frequency = 1;
			}
			score += Math.log10((double) frequency / this.getGrade());
		}

		return score;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public double getGrade() {
		return this.grade;
	}
}
