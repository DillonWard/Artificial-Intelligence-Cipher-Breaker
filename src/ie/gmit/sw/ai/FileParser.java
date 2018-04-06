package ie.gmit.sw.ai;

//Author: Dillon Ward (Dillonward2017@gmail.com)
// Adapted/Understood from: (1) https://codereview.stackexchange.com/questions/5618/replace-multiple-occurrences-of-a-character

public class FileParser {
	
	private String fname;
	
	// Constructor where the file name is fed in to be spliced
	/**
	 * @param fname
	 */
	public FileParser(String fname) {
		this.fname = fname;
	}
	
	// splices/removes duplicates found in the line and replace them with 'X' (1)
	/**
	 * @param l
	 * @return
	 */
	public String spliceDuplicates(String l) {
		// changes everything to uppercase/making cases redundant and makes a charArray from what's fed in
		char[] line = l.toUpperCase().toCharArray();
		
		// iterate through everything and check for duplicates
		for(int i = 0; i < line.length; i++) {
			if(i != line.length - 1) 
				// replace with x
				line[i+1] = (line[i] == line[i+1]) ? 'X' : line[i+1];
		}
		return new String(line);
	}
}
