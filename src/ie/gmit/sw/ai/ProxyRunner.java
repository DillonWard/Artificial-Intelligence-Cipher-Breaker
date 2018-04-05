package ie.gmit.sw.ai;


public class ProxyRunner {

	
	public static void main(String[] args) throws Throwable {
		
		Runner runner = new Runner();	

		String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		String fileName = "4grams.txt";
		
		String cipherText = runner.FileParser(fileName);	
		//System.out.println("File" + cipherText);
		
		long start = System.currentTimeMillis();
		
		String key = runner.GenerateKey(cipherKey);
		//System.out.println("key " + key);
		
		
		
		
		
	}
}
