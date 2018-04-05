package ie.gmit.sw.ai;

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
	private String statistics;	
	private int temp;
	
	private Map<String, Integer> gramsMap; 
	
	public SimulatedAnnealing(int temp, String cipherText) {
		super();
		this.rand = new SecureRandom();
		this.grams = new Grams("4grams.txt"); 
		this.playfair = new Playfair(cipherText);
		this.key = Key.keyInstance();
		this.statistics = "";
		this.temp = temp;
		this.gramsMap = new HashMap<String, Integer>(); 

	}
	
	public void simulate(){
		
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
}
