package ie.gmit.sw.ai;
//Dillon Ward (Dillonward2017@gmail.com)
// Adapted from: (1) https://github.com/mckennapsean/code-examples/blob/master/Java/Playfair.java

import java.security.SecureRandom;

public class Key {
	
	private static Key instance;
	
	public Key() {
	}
	
	/**
	 * @return
	 */
	// returns an instance of a key generated - if they key is null generate one
	public static Key keyInstance() {
		return (instance == null) ? new Key() : instance;
	}

	
	/**
	 * @return
	 */

	/* Used for generating a key
	 * first a new cipher key is generated
	 * duplicates found in the key are replaced with 'X'
	 * any 'J' found in the key is replaced with a blank space (see readme)
	 *  (1)
	 */
	public String generateKey() {
		
		// a String builder is initialized for creating the key
		StringBuilder newKey = new StringBuilder();
		String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		
		// first check and make sure that the key is 25 characters long, if it isn't the default key is added on and the key is fed into the 'spliceDuplicates' function
		newKey.append((cipherKey.length() < 25) ? new FileParser(null).spliceDuplicates(cipherKey + "ABCDEFGHIKLMNOPQRSTUVWXYZ") : cipherKey);
		
		// loop for the length of the cipherkey
		for (int i = 0; i < cipherKey.length(); i++) {	
			// loop for the length of the newkey
			for (int j = newKey.length() - 1; j > 0; j--) {
				// if a character at the index 'i' of the cipherKey is the same as the index 'j' in the newKey
				if (cipherKey.charAt(i) == newKey.charAt(j)) {
					if (i < j) {
						// delete the character found at the index 'j'
						newKey.deleteCharAt(j);
					}
				}
			}
		}

		// return the newly generated key
		return newKey.toString();
	}
	
	/**
	 * @param key
	 * @return
	 */
	// method used for shuffling the key that is fed into the function (1)
	public String shuffleKey(String key) {
		
		// initialize secure random to generate a random number
		SecureRandom r = new SecureRandom();
		
		// randomly generate a value up to 100
		int x = r.nextInt(100);
		
		// if x is greater than or equal to zero AND less than 2 feed the key into the swapRows
		if(x >= 0 && x < 2) {
			return swapRows(key, r.nextInt(4), r.nextInt(4));
		} 
		
		// if x is greater than or equal to 2 AND less than 4 feed the key into swapCols
		else if ( x >= 2 && x < 4) {
			return swapCols(key, r.nextInt(4), r.nextInt(4));
		} 
		
		// if x is greater than or equal to 4 AND less than 6 feed the key into flipRows
		else if ( x >= 4 && x < 6) {
			return flipRows(key);
		} 
		
		// if x is greater than or equal to 6 AND less than 8 feed the key into flipCols
		else if ( x >= 6 && x < 8) {
			return flipCols(key);
		}
		
		// if x is greater than or equal to 8 AND less than 10 reverse the key
		else if ( x >= 8 && x < 10) {
			return new StringBuffer(key).reverse().toString();
		} 
		
		else {
			int a = r.nextInt(key.length()-1);
			int b = r.nextInt(key.length()-1);
			b = (a == b) ? (b == key.length()-1) ? b - 1 : b + 1 : r.nextInt(key.length()-1);
			char[] res = key.toCharArray();
			char tmp = res[a];
			res[a] = res[b];
			res[b] = tmp;
			return new String(res);
		}
	}
	
	/**
	 * @param key
	 * @return
	 */
	// flips the rows  (1)
	private String flipRows(String key) {
		String[] rows = new String[5];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 5; i++) {
			rows[i] = key.substring(i*5, i*5 + 5);
			rows[i] = new StringBuffer(rows[i]).reverse().toString();
			sb.append(rows[i]);
		}
		return sb.toString();
	}
	
	/**
	 * @param key
	 * @return
	 */
	// flips the cols  (1)
	private String flipCols(String key) {
		char[] cols = key.toCharArray();
		int length = key.length() - (key.length()/5);
		
		for(int i = 0; i < key.length() / 5; i++) {
			for(int j = 0; j < key.length() / 5; j++) {
				char tmp = key.charAt(i*5 + j);
				cols[(i*5) + j] =  key.charAt(length + j);
				cols[length + j] =  tmp;
			}
			length -= 5;
		}
		return new String(cols);
	}
	
	/**
	 * @param key
	 * @param r1
	 * @param r2
	 * @return
	 */
	// swaps the rows  (1)
	private String swapRows(String key, int r1, int r2) {	
		return (r1 == r2) ? swapRows(key, new SecureRandom().nextInt(4), new SecureRandom().nextInt(4)) :  permute(key, r1, r2, true);
	}
	
	/**
	 * @param key
	 * @param c1
	 * @param c2
	 * @return
	 */
	// swaps the cols  (1)
	private String swapCols(String key, int c1, int c2) {
		return (c1 == c2) ? swapCols(key, new SecureRandom().nextInt(4), new SecureRandom().nextInt(4)) : permute(key, c1, c2, false);
	}
	
	/**
	 * @param key
	 * @param a
	 * @param b
	 * @param rw
	 * @return
	 */
	// permutate the key  (1)
	private String permute(String key, int a, int b, boolean rw) {
			char[] newKey = key.toCharArray();
			if(rw) {
				a *= 5;
				b *= 5;
			} 
			for(int i = 0; i < key.length() / 5 ; i++) {
				int index = (rw) ? i : i*5;
				char tmp =  newKey[(index + a)];
				newKey[(index + a)] = newKey[(index + b)];
				newKey[(index + b)] = tmp;				
			}
			return new String(newKey);
	}
}
