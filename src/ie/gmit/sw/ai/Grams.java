package ie.gmit.sw.ai;
// Author: Dillon Ward (Dillonward2017@gmail.com)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Grams {
	
	private String fname;
	private Map<String, Integer> grams;
	private long grade;
	
	// Constructor where the file name is fed in and a map is initialized
	/**
	 * @param fileName
	 */
	public Grams(String fileName) {
		this.fname = fileName;
		this.grams = new HashMap<String, Integer>();
	}

	/**
	 * @return
	 * @throws Exception
	 */
	// a gramsFactory where the grams map is constructed - the 4grams file will be pushed into a hashmap

	public Map<String, Integer> gramsFactory()  throws Exception {
		
		long count = 0;
		
		// buffered reader to iterate through the file
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname))));
		String line = "";
		
		// read through while the file is not empty
		while((line = br.readLine()) != null) {
			
			// parse the lines and put the 4grams into a map
			grams.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
			
			// add up the count
			count += Double.parseDouble(line.split(" ")[1]);
		}
		// the grade is set to the count
		setGrade(count);
		
		// close the reader
		br.close();	
		return this.grams;
	}
	
	// grades the text fed into this function and returns a score depending on how close it is to english
	/**
	 * @param cipherText
	 * @return
	 */
	public double gradeText(String cipherText) {
		
		double score = 0;
		int frequency = 0;
		
		// Loop through the cipherText fed into this function and compare it against the 4grams map
		for(int i=0; i< cipherText.length() - 4; i++){
			if(grams.get(cipherText.substring(i, i+4)) != null){
				frequency = grams.get(cipherText.substring(i, i+4));
			}else{
				frequency = 1;
			}
			
			// Calculate a score to be returned
			score += Math.log10((double) frequency/this.getGrade());
		}
		
		return score;
	}
	
	public void setGrade(long grade) {
		this.grade = grade;
	}
	
	public long getGrade() {
		return this.grade;
	}
}
