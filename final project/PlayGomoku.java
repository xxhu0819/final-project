import javax.xml.soap.Text;

public class PlayGomoku {

	public static void main(String[] args) { 
		
		//basic information
		System.out.println("Welcome to game Gomoku!");
		System.out.println("This game needs two players.");
		System.out.println("Player 1, Please enter your name:");
		String playerBlack = TextIO.getlnString();
		System.out.println("Player 2, Please enter your name:");
		String playerWhite = TextIO.getlnString();
		System.out.println("Game stats:");
		
		Board board = new Board();
		int count = 0;
		int x = -1;
		int y = -1;
		int rounds = 15*15;
		
		do {
			count++;
			board.drawBoard();
			
			System.out.println("Make a move:");
			System.out.println("Which coloum:");
			y = TextIO.getlnInt() - 1;
			System.out.println("Which row:");
			char ch = TextIO.getlnChar();
			x = ch - 'A';//convert char into integer
			System.out.println("x: " + y);
			System.out.println("y: " + x);
			board.updateBlackPiece(x, y, count%2);
			rounds --;
		} while(!board.win(x, y) && rounds > 0);
		
		board.drawBoard();
		
		if (rounds == 0 && board.win(x, y) == false) {
			System.out.println("Tie.");
		}
		
		if (count%2 == 1 && rounds >= 0) {
			System.out.println(playerBlack + " win!!");
		} else if (count%2 == 0 && rounds >= 0) {
			System.out.println(playerWhite + " win!!");
		}
		System.out.println("End of the game.");
		
	}
	
}