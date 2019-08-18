/**
 * Represents a cell.
 */
public class cell {

    private int cellId;
    private String whoShoot;


    public cell(int cellId, String whoShoot) {
        this.cellId = 0;// initilize all the cell to 0
        this.whoShoot = "nobody";// initilize all the cell to null (nobody hit the cell)
    }


    public int getcellId() {
        return cellId;
    }


    public String getwhoShoot() {
        return whoShoot;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public void setWhoShoot(String whoShoot) {
        this.whoShoot = whoShoot;
    }
}
