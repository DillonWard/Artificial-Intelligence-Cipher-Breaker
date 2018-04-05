package ie.gmit.sw.ai;

import java.util.Map;

public class SimulatedAnnealing {
	
	private Map<String, Integer> grams;
	private String key;
	private String decrypted;
	private double score;
	
	public void simulatedAnnealing(Map<String, Integer> grams, String key, String decrypted, double score) throws Throwable{
		this.grams = grams;
		this.key = key;
		this.decrypted = decrypted;
		this.score = score;
		
		
		
	}

}
