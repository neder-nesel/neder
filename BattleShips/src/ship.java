
/**
 * Represents a ship.
 */
public class ship {

    private int size;
    private int life;
    private int shipId;

    /**
     * Constructs a new ship.
     * @param size the size of the ship
     * @param life the number of coordinate of of the ship on the board
     */
    public ship(int size, int life) {
        this.size = size;
        this.life = size;
        this.shipId = shipId;
    }

    /**
     * returns the ship size
     * @return the ship size
     */
    public int getShipsize() {
        return size;
    }

    /**
     * returns the number of coordinate of the ship on the board
     * @return the number of coordinate of the ship on the board
     */
    public int getLife() {
        return life;
    }
    /**
     * returns the ship ID
     * @return returns the ship ID
     */
    public int getShipId() {
        return shipId;
    }
    public void setShiplife(int life){
        this.life= life ;
    }

}
