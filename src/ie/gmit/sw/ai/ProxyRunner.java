package ie.gmit.sw.ai;

import java.util.Scanner;

public class ProxyRunner {

	public static void main(String[] args) throws Throwable {

		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean running = true;
		String fname = "";

		do {
			System.out.println("1: Encrypt a file \n2: Decrypt a file \n3: Exit");
			choice = input.nextInt();

			switch (choice) {
			case 1:

				break;

			case 2:
				break;

			case 3:
				running = false;
				break;

			default:
				System.out.println("1: Encrypt a file \n2: Decrypt a file \n3: Exit");
				choice = input.nextInt();
				break;
			}

		} while (running);

		// Playfair playfair;
		// SimulatedAnnealing simulated;
		// Key key;
		//
		// String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		// String fileName = "4grams.txt";
		//
		// String file = new FileParser().readFile(fileName);
		//
		// System.out.println(file);

	}
}
