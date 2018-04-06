package ie.gmit.sw.ai;

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
	
	public SimulatedAnnealing(int temperature, int transitions, String cipherText) {
		super();
		this.grams = new Grams("4grams.txt");
		this.playFair = new Playfair();
		this.playFair.setCipherText(cipherText);
		this.key = Key.keyInstance();
		this.temperature = temperature;
		this.transitions = transitions;
	}
	
	public void simulatedAnnealing() throws Throwable {		
		
		gramsMap = grams.gramsFactory();
		String parent = key.generateKey();
		String decryptedText = playFair.decrypt(parent);
		double parentScore = grams.gradeText(decryptedText);
		double bestScore = parentScore;
		double probability;
		rand = new SecureRandom();
		double startScore = bestScore;
		
		for(int temp = temperature; temp > 0; temp--) {
			for (int index = transitions; index > 0; index--) {
				String child = key.shuffleKey(parent);
				decryptedText = playFair.decrypt(child);
				double childScore = grams.gradeText(decryptedText);
				double delta = childScore - parentScore;
				if(delta > 0) {
					parent = child;
					parentScore = childScore;
				} else  {
					probability = (Math.exp((delta / temp)));
					if(probability > rand.nextDouble()) {
						parent = child;
						parentScore = childScore;
					}
				}

				if(parentScore > bestScore) {
					bestScore = parentScore;
				}
			}

			if(bestScore > (startScore/1.5)){
				if(bestScore > (startScore/1.6)) break;
			}
		}
		
		System.out.println("\n\nKey: " + parent + "\nDecrypted message: " + playFair.decrypt(parent));
	}
}