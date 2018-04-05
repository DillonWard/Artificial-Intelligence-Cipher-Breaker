package ie.gmit.sw.ai;

import java.util.Scanner;

public class ProxyRunner {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable {

		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean running = true;
		String fname = "";
		Key key = new Key();
		Playfair pf;
		
		do {
			System.out.println("1: Decrypt a file \n2: Encrypt a file \n3: Exit");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter file name: ");
				fname = input.next();
				fname += ".txt";
				String cipherText = new FileParser().readFile(fname);
				
				long start = System.currentTimeMillis();

				SimulatedAnnealing sa = new SimulatedAnnealing(100, cipherText);
				sa.simulate();
				
				long length = System.currentTimeMillis() - start;
				
				/*
				 * was previously trying to generate everything before passing into
				 * simulated annealing
				String genKey = key.generateKey(cipherText.toCharArray());
				Map<String, Integer> grams = g.gramFactory(fname);
				String decrypted = new Playfair(cipherText).decrypt(genKey);
				double score = g.gradeDecrypt(decrypted);
				sa.simulatedAnnealing(cipherText, grams, genKey, decrypted, score);
				*/
				
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
