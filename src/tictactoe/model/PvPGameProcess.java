package tictactoe.model;

import tictactoe.view.*;

import java.awt.*;

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
        ChangeColor.changePvPTextColor(turn);
    }

    public static int turn() {
        turn = !turn;
        ChangeColor.changePvPTextColor(turn);
        if (turn) return second;
        return first;
    }

    public static void isWinner(int X, int Y) {
        Buttons[][] buttons = GameField.getButtons();
        checkWinner.refreshData(buttons);
        if (checkWinner.checkWin(first, X, Y)) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.FIRSTWIN);
        } else if (checkWinner.checkWin(second, X, Y)) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.SECONDWIN);
        } else if (checkWinner.checkDraw()) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.DRAW);
        }
    }

    public static void endGame() {
        Buttons[][] buttons = GameField.getButtons();
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (buttons[i][j].getWho() == 0)
                    buttons[i][j].endGame();
            }
        }
    }

    public static void refresh() {
        turn = true;
        ChangeColor.changePvPTextColor(turn);
    }

}