package ie.gmit.sw.ai;

public class FileParser {
	
	private String fname;
	
	public FileParser(String fname) {
		this.fname = fname;
	}
	
	public String spliceDuplicates(String l) {
		char[] line = l.toUpperCase().toCharArray();
		
		for(int i = 0; i < line.length; i++) {
			if(i != line.length - 1) 
				line[i+1] = (line[i] == line[i+1]) ? 'X' : line[i+1];
		}
		return new String(line);
	}
}
