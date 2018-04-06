package ie.gmit.sw.ai;

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
	
	public Grams(String fileName) {
		this.fname = fileName;
		this.grams = new HashMap<String, Integer>();
	}

	public Map<String, Integer> gramsFactory()  throws Exception {
		long count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname))));
		String line = "";
		
		while((line = br.readLine()) != null) {
			grams.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
			count += Double.parseDouble(line.split(" ")[1]);
		}
		setGrade(count);
		br.close();	
		return this.grams;
	}
	
	public double gradeText(String cipherText) {
		double score = 0;
		int frequency = 0;
		
		for(int i=0; i< cipherText.length() - 4; i++){
			if(grams.get(cipherText.substring(i, i+4)) != null){
				frequency = grams.get(cipherText.substring(i, i+4));
			}else{
				frequency = 1;
			}
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
