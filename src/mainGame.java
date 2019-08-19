import java.util.Scanner;
public class mainGame {
    public static void main(String[] args) {
        int sizeOfFlee = Integer.parseInt(args[0]);
        int[] size = new int[sizeOfFlee];
        int sizeShip ;
        ship[] flee = new ship[sizeOfFlee];
        Scanner myObj = new Scanner(System.in);
        int SIZEOFBOARD = Integer.parseInt(args[1]);
        System.out.println(size.length);
        for (int i = 0; i < size.length; i++) {
            size[i] = (int) (Math.random() * (SIZEOFBOARD-1)) + 1;
            sizeShip = size[i];
            System.out.println("size of the ship"+ sizeShip);
            flee[i] = new ship(sizeShip, sizeShip,i+1);
            System.out.println("id of the ship" + flee[i].getShipId());
        }

        cell[][] board1 = new cell[SIZEOFBOARD][SIZEOFBOARD];
            for(int i =0;i < SIZEOFBOARD; i++){
                for(int j = 0; j < SIZEOFBOARD; j++){
                    board1[i][j] = new cell();
                }
            }
        cell[][] board2 = board1;
        player player1 = new player(flee, board1, sizeOfFlee, SIZEOFBOARD);
        player player2 = new player(flee, board2, sizeOfFlee, SIZEOFBOARD);
        inGame newGame = new inGame(player1, player2);
        System.out.println("for instructions please press 1");
        int help = myObj.nextInt();
        if (help == 1) {
            System.out.println("you need to write down 2 integers in the range of 1 to " + SIZEOFBOARD);
            System.out.println("the first integer represent the x and the second represent the y");
            System.out.println("the third input should be 'H' - if you want to locate your ship horizontally ");
            System.out.println("the third input should be 'v' - if you want to locate your ship vertically ");
            System.out.println();
        }

            for (int i = 0; i < sizeOfFlee; i++) {
                System.out.println("please choose the location of ship number " + (i + 1) + " the ship size is " + flee[i].getShipsize());
                int x = myObj.nextInt();
                int y = myObj.nextInt();
                char pose =myObj.next().charAt(0);
                newGame.getPlayer1().locateShip(flee[i],board1, x, y, pose);

            }
            System.out.println("great! you finish locating your flee on the board");
            System.out.println("now, please let player2 to locate his flee on the board");
            System.out.println("and don't be a cheater and stand behind him while he does it");
            System.out.println();
            for (int i = 0; i < sizeOfFlee; i++) {
                System.out.println("please choose the location of ship number " +(i + 1) + " the ship size is " + flee[i].getShipsize());
                int x = myObj.nextInt();
                int y = myObj.nextInt();
                char pose =myObj.next().charAt(0);
                newGame.getPlayer2().locateShip(flee[i],board2, x, y, pose);
            }
            System.out.println("great! you finish locating your flee on the board");
            System.out.println("lets the show begin");
            while (player1.getSizeOfFlee() != 0 && player2.getSizeOfFlee() != 0) {
                    System.out.println("player1  which  coordinate on player2s board do you want to attack?");
                    int locx1 = myObj.nextInt();
                    int locy1 = myObj.nextInt();
                    newGame.game(player1, locx1, locy1);
                    System.out.println("player2  which  coordinate on player1s board do you want to attack?");
                    int locx2 = myObj.nextInt();
                    int locy2 = myObj.nextInt();
                    newGame.game(player2, locx2, locy2);
                }
            }
        }






