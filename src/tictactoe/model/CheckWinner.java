package tictactoe.model;

public class CheckWinner {

    private int countwin = 0;

    private int fieldSize;
    private int pointstowin;

    private Buttons[][] buttons;

    public CheckWinner(int fieldSize, int pointstowin) {
        this.fieldSize = fieldSize;
        this.pointstowin = pointstowin;
    }

    public void refreshData(Buttons[][] buttons) {
        this.buttons = buttons;
    }

    private boolean checkLine(int startRaw, int startCol, int dRaw, int dCol, int who, int key) {
        for (int i = 0; i < fieldSize; i++) {
            if (checkOutOfField(startRaw - i * key * dRaw, startCol - i * key * dCol)) {
                if (buttons[startRaw - i * key * dRaw][startCol - i * key * dCol].getWho() == who) {
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
            if (checkLine(startRaw, startCol, dRaw, dCol, who, key))
                return true;
        }
        return false;
    }

    public boolean checkWin(int who, int raw, int col) {                        //get curr value of button
        countwin = 0;
        int key = -1;
        if (checkLine(raw, col, 0, 1, who, key)) {                           //Find similars in rows(horizontal)
            return true;
        }
        countwin = 0;
        if (checkLine(raw, col, 1, 0, who, key)) {                               //Find similars in cols(vertical)
            return true;
        }
        countwin = 0;
        if (checkLine(raw, col, 1, 1, who, key)) {                             //Find similars in cols(vertical)
            return true;
        }
        countwin = 0;
        if (checkLine(raw, col, -1, 1, who, key)) {                      //Find similars in cols(vertical)
            return true;
        }
        return false;
    }

    public boolean checkDraw() {                                      //Check if is it a draw
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                if (buttons[i][j].getWho() == 0)
                    return false;
        return true;
    }

    public boolean checkOutOfField(int i, int j) {         //Check if index is out of array
        if (i < fieldSize && i >= 0)
            if (j < fieldSize && j >= 0)
                return true;
        return false;
    }

}