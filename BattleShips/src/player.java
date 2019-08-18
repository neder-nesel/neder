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

    public board(int SIZEOFBOARD) {
        this.board = new cell[SIZEOFBOARD][SIZEOFBOARD];
    }

    public int getSizeOfFlee() {
        return sizeOfFlee;
    }

    public int getSIZEOFBOARD() {
        return SIZEOFBOARD;
    }

    public cell[][] setBoard(cell[][] board) {
        return board;
    }

    public int setSizeOfFlee(int sizeOfFlee) {
        return sizeOfFlee;
    }

    public void restartFlee(int[] shipSize) {

        for (int i = 0; i < shipSize.length; i++) {
            this.flee[i] = new ship(shipSize[i], shipSize[i]);
        }
    }

    public void locateShip(ship ship, cell[][] board, int x, int y, char pose) {
        if ((pose != 'H') && (pose != 'h') && (pose != 'v') && (pose != 'V')) {
            System.out.println("invalid input");
            return ; // need to replace with exeption
        }

        if (x + ship.getShipsize() > this.getSIZEOFBOARD() || x + ship.getShipsize() < this.getSIZEOFBOARD()) {
            System.out.println("the x value is out of the boards bounds ");
            return ; // need to replace with exeption
        }
        if (y + ship.getShipsize() > this.getSIZEOFBOARD() || y + ship.getShipsize() < this.getSIZEOFBOARD()) {
            System.out.println("the y value is out of the boards bounds ");
            return ; // need to replace with exeption
        }
        if ((pose == 'h') || (pose == 'H')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                if (this.getBoard()[x][y + i].getcellId() != 0) {
                    System.out.println("this cell is already taken ");
                    return ; // need to replace with exeption
                }
            }
        }
        if ((pose == 'v') || (pose == 'V')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                if (this.getBoard()[x + i][y].getcellId() != 0) {
                    System.out.println("this cell is already taken ");
                    return ; // need to replace with exeption
                }
            }

        }
        if ((pose == 'h') || (pose == 'H')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                board[x][y + i].setCellId(ship.getShipId());
            }
        }
        if ((pose == 'v') || (pose == 'V')) {
            for (int i = 0; i <= ship.getShipsize(); i++) {
                board[x + i][y].setCellId(ship.getShipId());
            }
        }

    }



  }


