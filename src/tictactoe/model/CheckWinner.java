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

    public void RefreshData(XOButton[][] buttons) {
        this.buttons = buttons;
    }

    private boolean CheckLine(int startRaw, int startCol, int dx, int dy, int who, int key) {
        for (int i = 0; i < fieldSize; i++) {
            if (CheckOutOfField(startRaw - i * key * dx, startCol - i * key * dy)) {
                if (buttons[startRaw - i * key * dx][startCol - i * key * dy].GetWho() == who) {
                    countwin++;
                    if (countwin == pointstowin)
                        return true;
                } else
                    break;
            } else
                break;
        }

        if (key == -1) {
            countwin--; //because we starting at start position twice
            key = 1;
            if (CheckLine(startRaw, startCol, dx, dy, who, key))
                return true;
        }
        return false;
    }

    public boolean CheckWin(int who, int raw, int col) {                        //get curr value of button
        countwin = 0;
        int key = -1;
        if (CheckLine(raw, col, 0, 1, who, key)) {                           //Find similars in rows(horizontal)
            return true;
        }
        countwin = 0;
        if (CheckLine(raw, col, 1, 0, who, key)) {                               //Find similars in cols(vertical)
            return true;
        }
        countwin = 0;
        if (CheckLine(raw, col, 1, 1, who, key)) {                             //Find similars in cols(vertical)
            return true;
        }
        countwin = 0;
        if (CheckLine(raw, col, -1, 1, who, key)) {                      //Find similars in cols(vertical)
            return true;
        }
        return false;
    }

    public boolean CheckDraw() {                                      //Check if is it a draw
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                if (buttons[i][j].GetWho() == 0)
                    return false;
        return true;
    }

    public boolean CheckOutOfField(int i, int j) {         //Check if index is out of array
        if (i < fieldSize && i >= 0)
            if (j < fieldSize && j >= 0)
                return true;
        return false;
    }

}