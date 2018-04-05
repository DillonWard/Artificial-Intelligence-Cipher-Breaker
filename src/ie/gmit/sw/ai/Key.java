package ie.gmit.sw.ai;

public class Key {

	private static Key instance;
	
	public Key() {
	}
	
	public static Key keyInstance() {
		return (instance == null) ? new Key() : instance;
	}

//	public String generateKey(String cipherKey) {
//		
//	}


}
