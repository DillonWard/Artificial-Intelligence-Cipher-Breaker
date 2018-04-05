package ie.gmit.sw.ai;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class SimulatedAnnealing {
	
	private SecureRandom rand;
	private Playfair playfair;
	private Grams grams;
	private Key key;
	
	private String bestKey;
	private String bestTxt;
	private String stats;	
	private int temperature;
	
	private Map<String, Integer> gramsMap; 
	
	public SimulatedAnnealing(int temp, String cipherText) {
		super();
		this.rand = new SecureRandom();
		this.grams = new Grams("4grams.txt"); 
		this.playfair = new Playfair(cipherText);
		this.key = Key.keyInstance();
		this.stats = "";
		this.temperature = temperature;
		this.gramsMap = new HashMap<String, Integer>(); 

	}
	
	public void simulate() throws Exception{
		
		gramsMap = grams.gramFactory();
		
		String parent = key.generateKey();						
		String decryptedText = playfair.decrypt(parent);				
		double parentScore = grams.gradeDecrypt(decryptedText);		
		double bestScore = parentScore;	
		double initScore = bestScore;
		System.out.println("Initial score: " + initScore + " for key: "+ parent);
		
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
