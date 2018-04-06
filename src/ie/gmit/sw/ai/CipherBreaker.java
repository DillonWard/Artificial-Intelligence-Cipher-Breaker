package ie.gmit.sw.ai;
// Author: Dillon Ward (Dillonward2017@gmail.com)
// Adapted from: (1) https://raw.githubusercontent.com/DillonWard/Java-Dictionary-RMI-Client/master/src/ie/gmit/sw/DictionaryServiceImpl.java
// Adapted from: (2) https://stackoverflow.com/questions/17624335/converting-milliseconds-to-minutes-and-seconds

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class CipherBreaker {

	/**
	 * @param args
	 * @throws Exception
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Exception, Throwable {

		// handle user input
		Scanner input = new Scanner(System.in); 
		// control variable for interacting with the menu
		int menu = 0;
		// parameter used for iterating through the decryption
		int transitions = 50000;
		// control variable for keeping the menu running
		boolean running = true;
		// name of the file to be fed in
		String fname = "";

		do {
			System.out.println("1: Decrypt text from file\n2: Exit\nChoice: ");
			// takes in user input
			menu = input.nextInt();

			/*	A switch method that the user interacts with
			 * if the user enters 1, they will begin the SimulatedAnnealing
			 * First the file is read using a buffered reader (1)
			 * Next using a string builder, the text is filtered using regular expressions (1)
			 * 
			 */
			switch (menu) {
			case 1:

				System.out.println("\nEnter File name: ");
				fname = input.next();
				fname += ".txt"; // append the extension type to the end of the file name

				// initializes a buffered reader for reading in the file
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname))));
				StringBuilder sb = new StringBuilder();
				String line;
				
				// reads the entire file OR while the file isn't empty continue reading
				while ((line = br.readLine()) != null) {
					// after the text is filtered, append what is left to a new string
					sb.append(line.toUpperCase().replaceAll("\\W", "").replace("J", ""));
				}
				
				
				// initializes an optimum time and temperature for comparrison
				int bestTime = (int) ((10 + 0.087 * (sb.toString().length() - 84)));
				int bestTemp = bestTime / 3;
				
				// begins a counter in milliseconds
				long startTime = System.currentTimeMillis();
				
				// feeds in values to SimulatedAnnealing to be initialized on the other side
				SimulatedAnnealing sa = new SimulatedAnnealing(bestTemp, transitions, sb.toString());
				
				//begins the process
				sa.simulatedAnnealing();
				
				// stops the counter and converts to seconds (2)
				long endTime = (System.currentTimeMillis() - (startTime) / 1000) % 60;
				
				// allows the user to retry if the key/text is wrong
				System.out.println("\nExecution Time: " + endTime);
				System.out.println("\n1: Try again \n2: Exit ");
				int retry = input.nextInt();

				switch (retry) {
				case 1:
					sa.simulatedAnnealing();
					break;

				case 2:
					running = false;
					break;
				}

			case 2:
				running = false;
				break;
			}
			
		} while (running);
	}
}
