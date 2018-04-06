package ie.gmit.sw.ai;


public class FileParser {
	private String filename;
	
	public FileParser(String fileName) {
		this.filename = fileName;
	}
	
	public String removeRecurringChars(String l) {
		char[] line = l.toUpperCase().toCharArray();
		
		for(int i = 0; i < line.length; i++) {
			if(i != line.length - 1) 
				line[i+1] = (line[i] == line[i+1]) ? 'X' : line[i+1];
		}
		return new String(line);
	}
}
