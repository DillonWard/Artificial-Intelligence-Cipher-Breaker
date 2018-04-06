package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class CipherBreaker {

	public static void main(String[] args) throws Exception, Throwable {

		Scanner input = new Scanner(System.in);
		int menu = 0;
		int transitions = 50000;
		boolean running = true;
		String fname = "";

		do {
			System.out.println("1: Decrypt text from file\n2: Exit\nChoice: ");

			menu = input.nextInt();

			switch (menu) {
			case 1:

				System.out.println("\nEnter File name: ");
				fname = input.next();
				fname += ".txt";

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname))));
				StringBuilder sb = new StringBuilder();
				String line;

				while ((line = br.readLine()) != null) {
					sb.append(line.toUpperCase().replaceAll("\\W", "").replace("J", ""));
				}

				int bestTime = (int) ((10 + 0.087 * (sb.toString().length() - 84)));
				int bestTemp = bestTime / 3;
				long startTime = System.currentTimeMillis();
				SimulatedAnnealing sa = new SimulatedAnnealing(bestTemp, transitions, sb.toString());
				sa.simulatedAnnealing();
				long endTime = (System.currentTimeMillis() - (startTime) / 1000) % 60;
				System.out.println("\nExecution Time: " + endTime);
				System.out.println("\n1: Try again \n2: Exit ");
				int again = input.nextInt();

				switch (again) {
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
