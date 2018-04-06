package ie.gmit.sw.ai;

public class Position {
	
	private int xPos;
	private int yPos;

	public Position () {}
	
	private Position(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public static Position getPosition(char target, char[][] cipherTable) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (target == cipherTable[i][j]) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	public int getPosX() {
		return this.xPos;
	}
	
	public int getPosY() {
		return this.yPos;
	}

}
