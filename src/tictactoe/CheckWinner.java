package tictactoe;

public class CheckWinner {

    private int CountWin = 0;

    private int fieldSize;
    private int PointsToWin;

    private XOButton[][] buttons;

    public CheckWinner(int fieldSize, int PointsToWin) {
        this.fieldSize = fieldSize;
        this.PointsToWin = PointsToWin;
    }

    public void refreshData(XOButton[][] buttons) {
        this.buttons = buttons;
    }

    private boolean checkLine(int startX, int startY, int dx, int dy, int who) {
        for (int i = 0; i < fieldSize; i++) {
            if (CheckOutOfArray(startX + i * dx, startY + i * dy)) {                 //Check if index is not out of array
                if (buttons[startX + i * dx][startY + i * dy].getWho() != who) {  //if value at buttons[x][y] != symb -> reset cycle
                    CountWin = 0;
                    continue;
                }
            } else                                                                                //if index is out of array break cycleS
                break;
            CountWin++;
            if (CountWin == PointsToWin)                       //Player win if CW==PTW
                return true;
        }
        return false;
    }

    public boolean CheckWin(int who) {                        //get curr value of button
        System.out.println(who);
        for (int i = 0; i < fieldSize; i++) {
            CountWin = 0;
            if (checkLine(i, 0, 0, 1, who)) {                       //currSymb = X or O
                System.out.println("Player " + who + " win!");               //Find similars in rows(horizontal)
                return true;
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            CountWin = 0;
            if (checkLine(0, i, 1, 0, who)) {
                System.out.println("Player " + who + " win!");               //Find similars in cols(vertical)
                return true;
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            CountWin = 0;
            if (checkLine(i, 0, 1, 1, who)) {
                System.out.println("Player " + who + " win!");               //Find similars on DOWNmain diagonal
                return true;
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            CountWin = 0;
            if (checkLine(0, i, 1, 1, who)) {
                System.out.println("Player " + who + " win!");               //Find similars on UPmain diagonal
                return true;
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            CountWin = 0;
            if (checkLine(i, fieldSize - 1, 1, -1, who)) {
                System.out.println("Player " + who + " win!");               //Find similars on DOWNside diagonal
                return true;
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            CountWin = 0;
            if (checkLine(0, fieldSize - i, 1, -1, who)) {
                System.out.println("Player " + who + " win!");               //Find similars on UPside diagonal
                return true;
            }
        }
        return false;
    }

    public boolean CheckDraw() {                                      //Check if is it a draw
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                if (buttons[i][j].getWho() == 0)
                    return false;
        System.out.println("It's a draw!");
        return true;
    }

    public boolean CheckOutOfArray(int i, int j) {         //Check if index is out of array
        if (i < fieldSize && i >= 0)
            if (j < fieldSize && j >= 0)
                return true;
        return false;
    }

}