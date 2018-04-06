package ie.gmit.sw.ai;


public class Position {

	private int posX;
	private int posY;

	public Position(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

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
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
}
