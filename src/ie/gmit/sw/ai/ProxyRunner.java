package ie.gmit.sw.ai;


public class ProxyRunner {

	
	public static void main(String[] args) throws Throwable {
		
		Playfair playfair;
		SimulatedAnnealing simulated;
		Key key;
		
		String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		String fileName = "4grams.txt";
		
		String file = new FileParser().readFile(fileName);
		
		System.out.println(file);
		
		
		
	}
}
