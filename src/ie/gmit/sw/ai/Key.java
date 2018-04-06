package ie.gmit.sw.ai;

import java.security.SecureRandom;
import java.util.Random;

public class Key {

	private static Key instance;
	
	public Key() {
	}
	
	public static Key keyInstance() {
		return (instance == null) ? new Key() : instance;
	}
	
	public String generateKey(char[] key) {
		
		 int index;
		 Random random = new SecureRandom();
		 for (int i = key.length - 1; i > 0; i--) {
			 index = random.nextInt(i + 1);
			 if (index != i) {
				 key[index] ^= key[i];
				 key[i] ^= key[index];
				 key[index] ^= key[i];
			 } 
		}	
		return new String(key);
	}


//	public String generateKey(char[] key) {
//		int index;
//		Random rand = new SecureRandom();
//		
//		for (int i = key.length - 1; i > 0; i--) {
//			 index = rand.nextInt(i + 1);
//			 if (index != i) {
//				 // key[index] = key[index] ^ key[i]
//				 key[index] ^= key[i];
//				 
//				 // key[i] = key[i] ^ key[index]
//				 key[i] ^= key[index];
//				 
//				 // key[index] = key[index] ^ key[i]
//				 key[index] ^= key[i];
//			 } 
//		}	
//		return new String(key);
//		
//	}


}
