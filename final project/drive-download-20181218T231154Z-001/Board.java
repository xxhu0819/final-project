
public class Board {

	private int size = 20;


	private Piece[][] pieces = new Piece[size][size];
	public int count = 0;

	public Board(int size) {
		this.size = size;
		for (int x = 0; x < size; x ++) {
			for (int y = 0; y < size; y ++) {
				pieces[x][y] = new Piece();
			}
		}
	}

	public void drawBoard() {

	    for (int y = 1; y <= size; y ++) {
	        System.out.print(String.format("%-3s", ""+y));
	    }
	    
	    System.out.println();

	    for (int x = 0; x < size; x ++) {
	        for (int y = 0; y < size; y ++) 
	            System.out.print(String.format("%-3s",pieces[x][y]));
	        System.out.print((char)('A' + x));//convert integer value to char
	        System.out.println();
	    }
	}

	public Piece getPiece(int x, int y) {
		return pieces[x][y];
	}


	public boolean isFinish(){
		return count == size * size;
	}
	
	
	public void updatePiece(int x, int y, boolean black) {
		if (black) {
			pieces[x][y] = new PieceBlack();
		} else {
			pieces[x][y] = new PieceWhite();
		}
		count ++;
	}

	public boolean canMove(int x, int y) {
		return pieces[x][y].getColor() == 0;
	}


	public boolean win(int x, int y) {

		int reference = pieces[x][y].getColor();
        
	    int horizontal = 0;
	    int vertical = 0;
	    int diagonal = 0;
	    int xx = x;
	    int yy = y;
	    
	    //horizontal
	    yy = y;
	    while(yy >= 1 && pieces[x][yy-1].getColor() == reference){
	    	horizontal ++;
	        yy --; 
	    }
	    yy = y;
	    while(yy+1 < size && pieces[x][yy+1].getColor() == reference){
	    	horizontal ++;
	        yy ++; 
	    }
	    if(horizontal + 1 >= 5){
	        return true;
	    }
	    
	    //vertical
	    xx = x;
	    while(xx >= 1 && pieces[xx-1][y].getColor() == reference){
	    	vertical ++;
	        xx --; 
	    }
	    xx = x;
	    while(xx+1 < size && pieces[xx+1][y].getColor() == reference){
	    	vertical ++;
	        xx ++; 
	    }
	    if(vertical + 1 >= 5){
	        return true;
	    }
	    
	    //diagonal,top left to bottom right
	    yy=y;
	    xx=x;
	    while(yy >= 1 && xx >= 1 && pieces[xx-1][yy-1].getColor() == reference){
	    	diagonal ++;
	        yy --; 
	        xx --;
	    }
	    yy=y;
	    xx=x;
	    while(yy+1 < size && xx+1 <size && pieces[xx+1][yy+1].getColor() == reference){
	    	diagonal ++;
	        yy ++; 
	        xx ++;
	    }
	    if(diagonal + 1 >= 5){
	        return true;
	    }
	    
	  //diagonal,top right to bottom left
	    yy=y;
	    xx=x;
	    diagonal = 0;
	    while(yy+1 < size && xx >= 1 && pieces[xx-1][yy+1].getColor() == reference){
	    	diagonal ++;
	        yy ++; 
	        xx --;
	    }
	    yy=y;
	    xx=x;
	    while(yy >= 1 && xx+1 <size && pieces[xx+1][yy-1].getColor() == reference){
	    	diagonal ++;
	        yy ++; 
	        xx ++;
	    }
	    if(diagonal + 1 >= 5){
	        return true;
	    }
	    
		return false;

	}

}
