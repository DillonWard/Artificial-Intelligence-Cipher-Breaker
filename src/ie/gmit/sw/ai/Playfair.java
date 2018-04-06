package ie.gmit.sw.ai;
// Dillon Ward (Dillonward2017@gmail.com)
// Adapted from: (1) https://github.com/mckennapsean/code-examples/blob/master/Java/Playfair.java
import java.util.LinkedList;
import java.util.List;


public class Playfair implements Cryptography{

	private List<Position> pos;
	private StringBuilder normalText;
	private char[][] cipher;
	private String cipherText;


	public Playfair() {
		super();
		this.pos = new LinkedList<Position>();
		this.normalText = new StringBuilder();
		this.cipher = new char[5][5];
		this.cipherText = "";
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.ai.Cryptography#decrypt(java.lang.String)
	 */
	
	// key is fed into this function to decrypt text (1)
	public String decrypt(String key) throws Exception {
		
		String decryptKey = key;
		char[][] cipher = new char[5][5];

		int index = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cipher[i][j] = decryptKey.charAt(index);
				index++;
			}
		}
		this.cipher = cipher;
		
		StringBuilder sb = new StringBuilder();
		
		for(index = 0; index < this.cipherText.length() / 2; index ++) {
			char a = this.cipherText.charAt(2 * index);
			char b = this.cipherText.charAt(2 * index + 1);
			int r1 = (int) Position.getPos(a, cipher).getPosX();
			int c1 = (int) Position.getPos(a, cipher).getPosY();
			int r2 = (int) Position.getPos(b, cipher).getPosX();
			int c2 = (int) Position.getPos(b, cipher).getPosY();

			if (r1 == r2) {
				c1 = (c1 + 4) % 5; 
				c2 = (c2 + 4) % 5;
			} else if (c1 == c2) {
				r1 = (r1 + 4) % 5;
				r2 = (r2 + 4) % 5;
			} else {
		        int temp = c1;
		        c1 = c2;
		        c2 = temp;
		    }
			sb.append(cipher[r1][c1] +""+ cipher[r2][c2]);
		}
		
		return sb.toString();
	}

	/**
	 * @return
	 */
	public List<Position> getPositions() {
		return pos;
	}

	/**
	 * @param positions
	 */
	public void setPositions(List<Position> positions) {
		this.pos = positions;
	}

	/**
	 * @return
	 */
	public String getPlainText() {
		return normalText.toString();
	}

	/**
	 * @param plainText
	 */
	public void setPlainText(String plainText) {
		this.normalText.append(plainText);
	}

	/**
	 * @return
	 */
	public char[][] getCipherTable() {
		return cipher;
	}

	/**
	 * @param cipherTable
	 */
	public void setCipherTable(char[][] cipherTable) {
		this.cipher = cipherTable;
	}

	/**
	 * @return
	 */
	public String getCipherText() {
		return cipherText;
	}

	/**
	 * @param cipherText
	 */
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}
}
