
public class PlayGomoku {


	public static void main(String[] args) { 
		boolean keepPlaying = true;
		

		System.out.println("Welcome to game Gomoku! This is basically Connect Four,");
		System.out.println("except that you can play your piece wherever you want.");
		System.out.println("This game needs two players.");
		
		while(keepPlaying) {
			System.out.println("Player 1, Please enter your name:");
			String playerBlack = TextIO.getlnString();
			System.out.println("Player 2, Please enter your name:");
			String playerWhite = TextIO.getlnString();
			System.out.println("Game stats:");

			int x = -1;
			int y = -1;
			//initialize game 
			System.out.println("What size do you want the board to be? (recomend 15 or 19, you can do 5-19):");
			int size = TextIO.getlnInt();
			while ((size>19) == true || (size<5) == true) {
				System.out.println("Reenter (recomend 15 or 19, you can do 5-19):");
				size = TextIO.getlnInt();
			} 
			Board board = new Board(size);
			
			boolean black = true;
			do {
				board.drawBoard();


				if(black) {
					System.out.print("Player " + playerBlack + " , please ");
				} else {
					System.out.print("Player " + playerWhite + " , please ");
				}
				System.out.println("make a move:");
				System.out.println("Which row (Capital letter):");
				char ch = TextIO.getlnChar();
				x = ch - 'A';
				while ((x>size-1) == true || (x<0) == true) {
					System.out.println("Reenter row (Capital letter):");
					ch = TextIO.getlnChar();
					x = ch - 'A';
				}
				
				System.out.println("Which coloum (1 though " + size + "):");
				y = TextIO.getlnInt() - 1;
				while ((y < 0) == true || (y > size -1) == true) {
					System.out.println("Reenter coloum (1 though " + size + "):");
					y = TextIO.getlnInt() - 1;
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
			keepPlaying = TextIO.getlnBoolean();
		}

		System.out.println("End of the game.");

	}

}