
/** 
 * Represents the  board.
 */
public class board {
	
	private cell[][] board;
	private int  SIZEOFBOARD;


	public board(cell [][] board) {
		this.board = board ;
	}

	public  board(int SIZEOFBOARD) {
        this.board = new cell[SIZEOFBOARD][SIZEOFBOARD];
    }

    public cell[][] getBoard(){
            return board;
    }

        /**
         * Returns the size of the board.
         * @return the size of the board.
         */
     public int getSizeBoard(){
            return SIZEOFBOARD;
    }
    }
