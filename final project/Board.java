
public class Board {

	private static Piece[][] pieces = new Piece[15][15];
	
	public Board() {
		
	}
	
	
	public static void drawBoard() {
		int j = 0;
		String number = j + "";
		
		for (j = 1; j < 16; j ++) {
			number = j + "";
			number = String.format("%-3s",number);
			System.out.print(number);
		}
		System.out.println();
		
		for (int y = 0; y < 15; y ++) {
			for (int x = 0; x < 15; x ++) {
				System.out.print(String.format("%-3s",pieces[y][x]));
			}
			System.out.print((char)('@' + (y + 1)));//turn integer value into letter
			System.out.println();
		}
	}
	
	
	public static void updatePiece(int x, int y, Piece piece) {
		pieces[x][y] = piece;
	}
	
	public static Piece getPiece(int x, int y) {
		return pieces[x][y];
	}
	
	
	
}
