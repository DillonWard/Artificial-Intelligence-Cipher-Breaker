package ie.gmit.sw.ai;

// Author: Dillon Ward (Dillonward2017@gmail.com)
// Adapted from: (1) http://javatutorialhq.com/java/lang/math-class-tutorial/exp-double-method-example/

import java.security.SecureRandom;
import java.util.Map;

public class SimulatedAnnealing {

	private Key key;
	private Playfair playFair;
	private Grams grams;
	private SecureRandom rand;

	private int temperature;
	private int transitions;

	private Map<String, Integer> gramsMap;

	// A constructor that variables will be fed into so they can be used locally
	public SimulatedAnnealing(int temperature, int transitions, String cipherText) {
		super();
		// feeds the 4grams file into the 4grams class for decrypting
		this.grams = new Grams("4grams.txt");

		// calls playfair to setup for variables to be fed into it
		this.playFair = new Playfair();

		// sets the cipher text to the text fed into this constructor
		this.playFair.setCipherText(cipherText);

		// gets an instance of a key generated
		this.key = Key.keyInstance();
		this.temperature = temperature;
		this.transitions = transitions;

		// simulatedAnnealing();
	}

	public void simulatedAnnealing() throws Throwable {

		// gets the grams from the gramFactory and binds them to a map
		gramsMap = grams.gramsFactory();

		// generates a parent key
		String parent = key.generateKey();

		// decrypt using the parent key generated
		String decryptedText = playFair.decrypt(parent);

		// sets the parentscore to the grade of how well it was decrypted
		double parentScore = grams.gradeText(decryptedText);

		// sets that as the best score for now
		double bestScore = parentScore;
		double probability;

		// construct a secure random number generator
		rand = new SecureRandom();

		// sets the start/initial score
		double startScore = bestScore;

		// loop for the temperature
		for (int temp = temperature; temp > 0; temp--) {

			// loop for each transition
			for (int i = transitions; i > 0; i--) {

				// shuffles the key fed into this function so it returns a
				// different result
				String child = key.shuffleKey(parent);

				// decrypt the text using the child key
				decryptedText = playFair.decrypt(child);

				// sets the childScore to how well it was decrypted
				double childScore = grams.gradeText(decryptedText);

				// sets the delta to the difference between the child/parent
				// scores
				double delta = childScore - parentScore;

				/*
				 * first checks if the delta is greater than 0 if the delta is
				 * greater than 0, the child key is changed to the parent key if
				 * the child key is better if the delta is greater than 0
				 * 
				 * Otherwise, the parent is better
				 */
				if (delta > 0) {
					// update the parent to be the child
					parent = child;
					// update the parent score
					parentScore = childScore;
				}
				else {
					
					// measure the probability using Eulers e raised to the power of the double value (1)
					probability = (Math.exp((delta / temp)));
					
					// if the probability is greater than a random number update the key
					if (probability > rand.nextDouble()) {
						parent = child;
						parentScore = childScore;
					}
				}

				// checks if the parentScore is greater than the bestScore if it is update the best
				if (parentScore > bestScore) {
					// update the best score
					bestScore = parentScore;
				}
			}

			// checks if the score is 150% better
			if (bestScore > (startScore / 1.5)) {
				
				// if it's 160% better break the loop because it has been decrypted
				if (bestScore > (startScore / 1.6))
					break;
			}
		}

		// print the result
		System.out.println("\n\nKey: " + parent + "\nDecrypted message: " + playFair.decrypt(parent));
	}
}