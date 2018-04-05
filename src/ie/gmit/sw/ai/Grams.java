package ie.gmit.sw.ai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grams {

	private Map<String, Integer> myGrams;
	
	public Map<String, Integer> gramFactory(String fileName) throws IOException{
		Stream<String> stream = Files.lines(Paths.get(fileName));
		
		myGrams = stream
				.map(tmp -> tmp.split(" "))
				.collect(Collectors.toMap(tmp -> tmp[0], tmp -> Integer.parseInt(tmp[1])));
		
		stream.close();
		
		return this.myGrams; 		
	}
}
