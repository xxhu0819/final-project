
public class Board {

	private Piece[][] pieces = new Piece[15][15];

	public Board() {
		for (int q = 0; q < 15; q ++) {
			for (int w = 0; w < 15; w ++) {
				pieces[q][w] = new Piece();
			}
		}
	}


	public void drawBoard() {
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


	public void updateBlackPiece(int x, int y, int count) {
		if (count == 0) {
			pieces[x][y] = new PieceWhite();
		} else {
			pieces[x][y] = new PieceBlack();
		}

	}

	public Piece getPiece(int x, int y) {
		return pieces[x][y];
	}

	public boolean win(int x, int y) {
		int reference = pieces[x][y].getColor();
		for(int i = 0; i<11; i++) {
			if (pieces[x][i].getColor() == reference && pieces[x][i + 1].getColor() == reference &&
					pieces[x][i + 2].getColor() == reference && pieces[x][i + 3].getColor() == reference && 
					pieces[x][i + 4].getColor() == reference) {
				return true;
			}
		}
		for(int i = 0; i<11; i++) {
			if (pieces[i][y].getColor() == reference && pieces[i + 1][y].getColor() == reference &&
					pieces[i + 2][y].getColor() == reference && pieces[i + 3][y].getColor() == reference && 
					pieces[i + 4][y].getColor() == reference) {
				return true;
			}
		}
//
//		if (x<=y) {
//			y = y-x;
//			x = 0;
//		}
//		while (y <11) {
//			if (pieces[x][y].getColor() == reference && pieces[x+1][y+1].getColor() == reference &&
//					pieces[x+2][y+2].getColor() == reference && pieces[x+3][y+3].getColor() == reference && 
//					pieces[x+4][y+4].getColor() == reference) {
//				return true;
//			}
//			y++;
//		}
//
//		if (x>=y) {
//			x = x-y;
//			y = 0;
//		}
//		while (x < 11) {
//			if (pieces[x][y].getColor() == reference && pieces[x+1][y+1].getColor() == reference &&
//					pieces[x+2][y+2].getColor() == reference && pieces[x+3][y+3].getColor() == reference && 
//					pieces[x+4][y+4].getColor() == reference) {
//				return true;
//			}
//			x++;
//		}
//
//
//		int a = 14 - x;
//		if (a<=y) {
//			x=14;
//			y = y-a;
//		}
//		while (y < 11) {
//			if (pieces[x][y].getColor() == reference && pieces[x-1][y+1].getColor() == reference &&
//					pieces[x-2][y+2].getColor() == reference && pieces[x-3][y+3].getColor() == reference && 
//					pieces[x-4][y+4].getColor() == reference) {
//				return true;
//			}
//			x--;
//			y++;
//		}
//
//		a = 14 - x;
//		if (a>=y) {
//			x=x+a;
//			y = 0;
//		}
//		while (x >3) {
//			if (pieces[x][y].getColor() == reference && pieces[x-1][y+1].getColor() == reference &&
//					pieces[x-2][y+2].getColor() == reference && pieces[x-3][y+3].getColor() == reference && 
//					pieces[x-4][y+4].getColor() == reference) {
//				return true;
//			}
//			x--;
//			y++;
//		}




		return false;
	}


}
