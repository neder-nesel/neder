
public class inGame {

    private player player1;
    private player player2;

    /**
     * Constructs a new inGame with 2 different players, that play against each other
     * @param player1
     * @param player2
     */
    public inGame(player player1, player player2) {
        this.player1 =player1;
        this.player2 =player2;
    }

    /**

     * @return player1
     */
    public player getPlayer1() {
        return player1;
    }
    /**

     * @return player2
     */
    public player getPlayer2() {
        return player2;
    }



    public void game(player player,int x, int y ) {
        if (player == player1){
                int shootCord= (player2.getBoard()[x][y].getcellId());
                if (shootCord != 0){
                    int shipLife =   player2.getflee()[shootCord].getLife() -1;
                    player2.getflee()[shootCord].setShiplife(shipLife);
                    if(player2.getflee()[shootCord].getLife()== 0){
                        player2.setSizeOfFlee(player2.getSizeOfFlee()-1);
                        if(player2.getSizeOfFlee()== 0){
                            System.out.println("player1 is the winner !!! ");
                            return;
                        }

                    }
                    player2.getBoard()[x][y].setCellId(0);
                }
        }
        if (player == player2) {
            int shootCord = (player1.getBoard()[x][y].getcellId());
            if (shootCord != 0) {
                int shipLife = player1.getflee()[shootCord].getLife() - 1;
                player1.getflee()[shootCord].setShiplife(shipLife);
                if (player1.getflee()[shootCord].getLife() == 0) {
                    player1.setSizeOfFlee(player1.getSizeOfFlee() - 1);
                    if (player1.getSizeOfFlee() == 0) {
                        System.out.println("player2 is the winner !!! ");
                        return;
                    }

                }
                player1.getBoard()[x][y].setCellId(0);
            }
        }



    }
}