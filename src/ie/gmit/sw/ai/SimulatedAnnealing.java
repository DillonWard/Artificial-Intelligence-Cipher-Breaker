package ie.gmit.sw.ai;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class SimulatedAnnealing {
	
	private SecureRandom rand;
	private String bestKey;
	private String bestText;
	
	private String stats;	
	private String parentKey;
	private String decryptedText;
	private String cipherText;
	private double parentGrade;
	private double bestScore;
	private double initialScore;
	private int temperature;
	Grams g;
	
	
	//private Map<String, Integer> gramsMap = new HashMap<String, Integer>(); 
	private Map<String, Integer> gramsMap; 

	public SimulatedAnnealing(Map<String, Integer> gramsMap, int temperature, String cipherText, String parentKey, String decryptedText, double parentGrade) {
		this.temperature = temperature;
		this.cipherText = cipherText;
		this.parentKey = parentKey;
		this.decryptedText = decryptedText;
		this.parentGrade = parentGrade;
		this.gramsMap = gramsMap;
		//this.map = map; 


	}
	
	public void simulate() throws Exception{
		
		double bestScore = parentGrade;	
		double initScore = bestScore;
		gramsMap = g.gramFactory();
		System.out.println("Initial score: " + initScore + " for key: "+ parentKey);
		
		for(int temp = temperature; temp > 0; temp--) {			
			for (int index = 50000; index > 0; index--) {
				
			}
		}
	}

	
	public void setStats(String stats) {
		this.stats = stats;
	}
	
	public String getStats() {
		return this.stats;
	}

	
}

/*
	public void simulatedAnnealing(String cipher, Map<String, Integer> grams, String key, String decrypted, double score) throws Throwable{
		this.grams = grams;
		this.key = key;
		this.decrypted = decrypted;
		this.score = score;
		bestGrade = score;
		
		System.out.println("Initial Score:" + initialGrade + " for key: " + key);
		
		
	}
*/
