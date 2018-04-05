package ie.gmit.sw.ai;

import java.util.Scanner;

public class ProxyRunner {

	public static void main(String[] args) throws Throwable {

		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean running = true;
		String fname = "";
		SimulatedAnnealing sa = new SimulatedAnnealing();
		Key key = new Key();
		String genKey;
		
		do {
			System.out.println("1: Encrypt a file \n2: Decrypt a file \n3: Exit");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter file name: ");
				fname = input.next();
				fname += ".txt";
				
				String cipherText = new FileParser().readFile(fname);
				long start = System.currentTimeMillis();
				genKey = key.generateKey(cipherText.toCharArray());
				sa.simulatedAnnealing(genKey);
				
				

				break;

			case 2:
				break;

			case 3:
				running = false;
				break;
			}

		} while (running);

	}
}
