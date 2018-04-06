package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Grams {

	private String filename;
	private Map<String, Integer> grams;
	private long no;
	
	public Grams(String fileName) {
		this.filename = fileName;
		this.grams = new HashMap<String, Integer>();
	}

	public Map<String, Integer> gramFactory()  throws Exception {
		long count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
		String line = "";
		
		while((line = br.readLine()) != null) {
			grams.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
			count += Double.parseDouble(line.split(" ")[1]);
		}
		br.close();	
		return this.grams;
	}
	
	public double scoreText(String cipherText) {
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
	
	public void setGrade(long no) {
		this.no = no;
	}
	
	public long getGrade() {
		return this.no;
	}
}
