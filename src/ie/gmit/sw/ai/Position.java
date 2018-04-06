package ie.gmit.sw.ai;

//Dillon Ward (Dillonward2017@gmail.com)

public class Position {

	private int posX;
	private int posY;

	/**
	 * @param posX
	 * @param posY
	 */
	public Position(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * @param target
	 * @param table
	 * @return
	 */
	public static Position getPos(char target, char[][] table) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (target == table[i][j]) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	/**
	 * @return
	 */
	public int getPosX() {
		return this.posX;
	}
	
	/**
	 * @return
	 */
	public int getPosY() {
		return this.posY;
	}
	
}
