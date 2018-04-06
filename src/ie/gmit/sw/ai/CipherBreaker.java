package ie.gmit.sw.ai;

import java.util.Map;
import java.util.Scanner;

public class CipherBreaker {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable {

		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean running = true;
		String fname = "";
		Key key = new Key();
		
		do {
			System.out.println("1: Decrypt a file \n2: Encrypt a file \n3: Exit");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter file name: ");
				fname = input.next();
				fname += ".txt";
				String cipherText = new FileParser().readFile(fname);
				String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

				long start = System.currentTimeMillis();
				
				
				String parentKey = key.generateKey(cipherText.toCharArray());
				Grams g = new Grams(fname);
				Playfair playfair = new Playfair(cipherText);
				

				Map<String, Integer> grams = g.gramFactory();
				String decrypted = new Playfair(cipherText).decrypt(parentKey);
				
				
				double parentGrade = g.gradeDecrypt(decrypted);
				String decryptedText = playfair.decrypt(parentKey);
				SimulatedAnnealing sa = new SimulatedAnnealing(grams, 20, cipherText, parentKey, decryptedText, parentGrade);

				
				
				long length = System.currentTimeMillis() - start;
				
				
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
