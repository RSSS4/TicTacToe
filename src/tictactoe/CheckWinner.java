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
        int a,b;
        for (int i = 0; i < fieldSize; i++) {
            if (CheckOutOfArray(startX - i * dx, startY - i * dy)) {
                if(buttons[startX - i * dx][startY - i * dy].getWho()==who) {
                    CountWin++;
                    if(CountWin==PointsToWin)
                        return true;
                }
                else
                    break;
            }
            else
                break;
        }

         CountWin--; //because we starting at start position twice

        for (int i = 0; i < fieldSize; i++) {
            if (CheckOutOfArray(startX + i * dx, startY + i * dy)) {
                if(buttons[startX + i * dx][startY + i * dy].getWho()==who) {
                    CountWin++;
                    if(CountWin==PointsToWin)
                        return true;
                }
                else
                    break;
            }
            else
                break;
        }
        return false;
    }

    public boolean CheckWin(int who, int X, int Y) {                        //get curr value of button
            CountWin = 0;

        if (checkLine(X, Y, 0, 1, who)) {
            System.out.println("Player " + who + " win!");               //Find similars in rows(horizontal)
            return true;
        }
         CountWin = 0;
        if (checkLine(X, Y, 1, 0, who)) {
            System.out.println("Player " + who + " win!");               //Find similars in cols(vertical)
            return true;
        }
        CountWin = 0;
        if (checkLine(X, Y, 1, 1, who)) {
            System.out.println("Player " + who + " win!");               //Find similars in cols(vertical)
            return true;
        }
        CountWin = 0;
        if (checkLine(X, Y, -1, 1, who)) {
            System.out.println("Player " + who + " win!");               //Find similars in cols(vertical)
            return true;
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