import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Represents a player.
 */
public class player {

    private int sizeOfFlee;
    private ship[] flee;
    private cell[][] board;
    private int SIZEOFBOARD;


    public player(ship[] flee, cell[][] board, int sizeOfFlee, int SIZEOFBOARD) {
        this.flee = flee;
        this.board = board;
        this.sizeOfFlee = sizeOfFlee;
        this.SIZEOFBOARD = SIZEOFBOARD;
    }


    public ship[] getflee() {
        return flee;
    }

    public cell[][] getBoard() {
        return board;
    }

    public void setBoard(int SIZEOFBOARD) {
        for(int i = 0;i < SIZEOFBOARD; i++){
            for(int j = 0; j < SIZEOFBOARD; j++){
                board[i][j].setCellId(0);
            }
        }

    }

    public int getSizeOfFlee() {
        return sizeOfFlee;
    }

    public int getSIZEOFBOARD() {
        return SIZEOFBOARD;
    }



    public void setSizeOfFlee(int sizeOfFlee) {
        this.sizeOfFlee= sizeOfFlee;
    }

    public void restartFlee(int[] shipSize) {

        for (int i = 0; i < shipSize.length; i++) {
            this.flee[i] = new ship(shipSize[i], shipSize[i],i);
        }
    }

    public void locateShip(ship ship, cell[][] board, int x, int y, char pose) {
        if ((pose != 'H') && (pose != 'h') && (pose != 'v') && (pose != 'V')) {
            throw new IllegalArgumentException("invalid input");
        }

        if (x + ship.getShipsize() > this.getSIZEOFBOARD()) {
            throw new IndexOutOfBoundsException("the x value is out of the boards bounds ");

        }
        if (y + ship.getShipsize() > this.getSIZEOFBOARD()) {
            throw new IndexOutOfBoundsException("the y value is out of the boards bounds ");

        }
        if ((pose == 'h') || (pose == 'H')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                if (this.getBoard()[(x + i)][y].getcellId() != 0) {
                    throw new IllegalArgumentException("this cell" +(x+i + " "+ y) +"is already taken");

                }
            }
        }
        if ((pose == 'v') || (pose == 'V')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                if (this.getBoard()[x][y+i].getcellId() != 0) {
                    throw  new IllegalArgumentException("this cell is already taken ");

                }
            }

        }
        if ((pose == 'h') || (pose == 'H')) {
            for (int i = 0; i < ship.getShipsize(); i++) {
                System.out.println("before change H" + this.getBoard()[x][y+i].getcellId());
                board[x+i][y].setCellId(ship.getShipId());
                System.out.println("after change H id is" + this.getBoard()[x][y+i].getcellId()+" loc is" +(x+i)+" "+y);
            }
        }
        if ((pose == 'v') || (pose == 'V')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                board[x][y+i].setCellId(ship.getShipId());
                System.out.println(this.getBoard()[x][y+i].getcellId());
            }
        }

    }



  }


