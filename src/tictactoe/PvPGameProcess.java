package tictactoe;

import javax.swing.RepaintManager;

public class PvPGameProcess {

    private static ResultFrame result;

    //first - false, second - true
    private static boolean turn = true;

    private static final int first = 1;
    private static final int second = 2;

    private static CheckWinner checkWinner;

    private static int fieldSize;

    public PvPGameProcess(int fieldSize) {
        this.fieldSize = fieldSize;
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    }

    public static int turn() {
        turn = !turn;
        if (turn) return second;
        return first;
    }

    public static void isWinner(int X, int Y) {
        XOButton[][] buttons = GameField.getButtons();
        checkWinner.refreshData(buttons);
        if (checkWinner.CheckWin(first, X, Y)) {
            endGame();
            result = new ResultFrame(1);
        } else if (checkWinner.CheckWin(second, X, Y)) {
            endGame();
            result = new ResultFrame(2);
        } else if (checkWinner.CheckDraw()) {
            endGame();
            result = new ResultFrame(5);
        }
    }

    public static void endGame() {
        XOButton[][] buttons = GameField.getButtons();
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (buttons[i][j].getWho() == 0)
                    buttons[i][j].endGame();
            }
        }
    }

    public static void refresh() {
        turn = true;
    }

    public static int getfieldSize() {
        return fieldSize;
    }

}