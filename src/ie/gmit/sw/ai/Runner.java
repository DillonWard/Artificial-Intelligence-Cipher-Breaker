package ie.gmit.sw.ai;

public class Runner {
	
	private static String keyword = "keyword";
	private static String message = "this is the message";
	Playfair pf;
	FileParser fileParser;
	
	public void Playfair(){		
		
	}
	
	public String FileParser(String filename) throws Throwable{
		return new FileParser().readFile(filename);
	}
	
	public String GenerateKey(String cipherKey) throws Throwable{
		return new Keygen().generateKey(cipherKey);
	}
	

}
