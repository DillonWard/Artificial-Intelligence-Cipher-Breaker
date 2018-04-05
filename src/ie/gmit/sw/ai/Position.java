package ie.gmit.sw.ai;

public class Position {
	
	private int x;
	private int y;

	public Position () {}
	
	private Position(int x, int y) {
		this.x = x;
		this.y = y;
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
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}

}
