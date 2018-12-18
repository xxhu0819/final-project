
public class PlayGomoku {


	public static void main(String[] args) { 
		int x = -1;
		int y = -1;
		boolean keepPlaying = true;
		String playerBlack;
		String playerWhite;

		System.out.println("Welcome to game Gomoku! This is basically Connect Four,");
		System.out.println("except that you can play your piece wherever you want.");
		System.out.println("This game needs two players.");
		
		while(keepPlaying) {
			System.out.println("Player 1, Please enter your name:");
			playerBlack = TextIO.getlnString();
			System.out.println("Player 2, Please enter your name:");
			playerWhite = TextIO.getlnString();
			System.out.println("Game stats:");

			x = -1;
			y = -1;
			//initialize game 
			Board board = new Board();
			boolean black = true;
			do {
				board.drawBoard();


				if(black) {
					System.out.print("Player " + playerBlack + " , please ");
				} else {
					System.out.print("Player " + playerWhite + " , please ");
				}
				System.out.println("make a move:");
				System.out.println("Which row (A-O):");
				char ch = TextIO.getlnChar();
				x = ch - 'A';//convert char into integer
//				if (x < 0 || x > 14) {
//					throw new IllegalArgumentException("Please type A-O.");
//				}
				System.out.println("Which coloum (1-15):");
				y = TextIO.getlnInt() - 1;
				if (y < 0 || y > 14) {
					throw new IllegalArgumentException("Please type 1 though 15.");
				}
				if(!board.canMove(x, y)){
					System.out.println("This position already had a piece!!!!!!!!!!!!!!!!!!!!");
					continue;
				}

				board.updatePiece(x, y, black);

				black = !black; //switch player
			} while(!board.isFinish() && !board.win(x, y));

			board.drawBoard();

			if(board.win(x, y)){
				if(!black)
					System.out.println("Player " + playerBlack + " win!!!!!");
				else
					System.out.println("Player " + playerWhite + " win!!!!!");
			}

			if(board.isFinish()){
				System.out.println(playerBlack + " and " + playerWhite + " tie.");
			}

			System.out.println("New game?");
			keepPlaying = TextIO.getBoolean();
		}

		System.out.println("End of the game.");

	}

}