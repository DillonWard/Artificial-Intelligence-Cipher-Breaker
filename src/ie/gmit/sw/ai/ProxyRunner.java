package ie.gmit.sw.ai;


public class ProxyRunner {

	
	public static void main(String[] args) throws Throwable {
		
		String fileName = "4grams.txt";
		Runner runner = new Runner();		
		
		String cipherText = runner.FileParser(fileName);
				
		System.out.println("File" + cipherText);
		
	}
}
