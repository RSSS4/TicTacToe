package model;

import view.*;

import java.awt.*;

public class PvPGameProcess {

    private static ResultFrame result;

    //first - false, second - true
    private static boolean turn = true;

    private static final int FIRST = 1;
    private static final int SECOND = 2;

    private static CheckWinner checkWinner;
    private static ChangeColor color;
    private static int fieldSize;
    private static Buttons[][] buttons;

    public PvPGameProcess(int fieldSize) {
        setData(fieldSize);
    }
    private void setData(int fieldSize){
    this.fieldSize = fieldSize;
    checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    color = new ChangeColor();
    color.changePvPTextColor(turn);
    buttons = GameField.getButtons();
}
    public static int turn() {
        turn = !turn;
        color.changePvPTextColor(turn);
        if (turn) return SECOND;
        return FIRST;
    }

    public static void isWinner(int X, int Y) {
        checkWinner.refreshData(buttons);
        if (checkWinner.checkWin(FIRST, X, Y)) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.FIRSTWIN);
        } else if (checkWinner.checkWin(SECOND, X, Y)) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.SECONDWIN);
        } else if (checkWinner.checkDraw()) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.DRAW);
        }
    }

    public static void endGame() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (buttons[i][j].getWho() == 0)
                    buttons[i][j].endGame();
            }
        }
    }

    public static void refresh() {
        turn = true;
        color.changePvPTextColor(turn);
    }

    public static boolean getTurn() {
        return turn;
    }
    public static void setTurn(boolean turn) {
        PvPGameProcess.turn = turn;
    }

    public static void refreshData(Buttons[][] buttons) {
        PvPGameProcess.buttons = buttons;
    }

    public static ResultFrame getResult(){return result;}

    public static void setResult(ResultFrame result){PvPGameProcess.result = result;}



}