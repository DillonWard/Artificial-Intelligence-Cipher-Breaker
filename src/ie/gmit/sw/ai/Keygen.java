package ie.gmit.sw.ai;

import java.security.SecureRandom;
import java.util.Random;

public class Keygen {

	private static Keygen instance;
	
	public static Keygen key(){
		return(instance == null) ? new Keygen() : instance;
	}
	
	public String generateKey(String cipherKey){
		
		Random r = new SecureRandom();

		char[] key = cipherKey.toCharArray();
		int index;
		
		for(int i = key.length - 1; i > 0; i--){
			index = r.nextInt(i + 1);
			
			if(index != i){
				//key[index] = key[index] ^ key[i];
				key[index] ^= key[i];
				key[i] ^= key[i]; 
				key[index] ^= key[i];
			}
		}
		
		
		return new String(key);
	}

}
