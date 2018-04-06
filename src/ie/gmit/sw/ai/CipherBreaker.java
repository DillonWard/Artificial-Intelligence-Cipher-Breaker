package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
			System.out.println("1: Decrypt a file \n2: Exit");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter file name: ");
				fname = input.next();
				fname += ".txt";
				System.out.println(fname);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname))));
				StringBuilder sb = new StringBuilder();
				String line;
				
				while((line = br.readLine()) != null) {
					sb.append(line.toUpperCase().replaceAll("\\W", "").replace("J", ""));
				}
				
				int idealTime = (int)((10 + 0.087 * (sb.toString().length() - 84)));
				int bestTemp = idealTime / 3;
				long startTime = System.currentTimeMillis();
				SimulatedAnnealing sa = new SimulatedAnnealing(bestTemp, 50000, sb.toString());
				sa.annealing();
				
				System.out.println("1: Try again\n2: Exit");
				
				int again = input.nextInt();
				
				switch(again){
				case 1:
					sa.annealing();
				break;
				
				case 2: 
					System.exit(0);
					break;
				}
					
				
//				String cipherText = new FileParser().readFile(fname);
//				String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
//
//				long start = System.currentTimeMillis();
//						
//				String parentKey = key.generateKey(cipherText.toCharArray());
//				Grams g = new Grams(fname);
//				Playfair playfair = new Playfair(cipherText);
//				
//
//				Map<String, Integer> grams = g.gramFactory();
//				String decrypted = new Playfair(cipherText).decrypt(parentKey);
//				
//				
//				double parentGrade = g.scoreText(decrypted);
//				String decryptedText = playfair.decrypt(parentKey);
//				SimulatedAnnealing sa = new SimulatedAnnealing(grams, 20, cipherText, parentKey, decryptedText, parentGrade);				
//				long length = System.currentTimeMillis() - start;
				
				
				break;

			case 2:
				running = false;
				break;

			}

		} while (running);

	}
}
