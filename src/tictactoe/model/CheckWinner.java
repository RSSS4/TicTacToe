package tictactoe.model;

import tictactoe.view.XOButton;

public class CheckWinner {

    private int countwin = 0;

    private int fieldSize;
    private int pointstowin;

    private XOButton[][] buttons;

    public CheckWinner(int fieldSize, int pointstowin) {
        this.fieldSize = fieldSize;
        this.pointstowin = pointstowin;
    }

    public void refreshData(XOButton[][] buttons) {
        this.buttons = buttons;
    }

    private boolean checkLine(int startX, int startY, int dx, int dy, int who) {
        for (int i = 0; i < fieldSize; i++) {
            if (CheckOutOfArray(startX - i * dx, startY - i * dy)) {
                if (buttons[startX - i * dx][startY - i * dy].getWho() == who) {
                    countwin++;
                    if (countwin == pointstowin)
                        return true;
                } else
                    break;
            } else
                break;
        }

        countwin--; //because we starting at start position twice

        for (int i = 0; i < fieldSize; i++) {
            if (CheckOutOfArray(startX + i * dx, startY + i * dy)) {
                if (buttons[startX + i * dx][startY + i * dy].getWho() == who) {
                    countwin++;
                    if (countwin == pointstowin)
                        return true;
                } else
                    break;
            } else
                break;
        }
        return false;
    }

    public boolean CheckWin(int who, int X, int Y) {                        //get curr value of button
        countwin = 0;
        if (checkLine(X, Y, 0, 1, who)) {                           //Find similars in rows(horizontal)
            return true;
        }
        countwin = 0;
        if (checkLine(X, Y, 1, 0, who)) {                               //Find similars in cols(vertical)
            return true;
        }
        countwin = 0;
        if (checkLine(X, Y, 1, 1, who)) {                             //Find similars in cols(vertical)
            return true;
        }
        countwin = 0;
        if (checkLine(X, Y, -1, 1, who)) {                      //Find similars in cols(vertical)
            return true;
        }
        return false;
    }

    public boolean CheckDraw() {                                      //Check if is it a draw
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                if (buttons[i][j].getWho() == 0)
                    return false;
        return true;
    }

    public boolean CheckOutOfArray(int i, int j) {         //Check if index is out of array
        if (i < fieldSize && i >= 0)
            if (j < fieldSize && j >= 0)
                return true;
        return false;
    }

}