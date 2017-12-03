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
        ChangeColor.ChangePvPTextColor(turn);
    }

    public static int Turn() {
        turn = !turn;
        ChangeColor.ChangePvPTextColor(turn);
        if (turn) return second;
        return first;
    }

    public static void IsWinner(int X, int Y) {
        XOButton[][] buttons = GameField.GetButtons();
        checkWinner.RefreshData(buttons);
        if (checkWinner.CheckWin(first, X, Y)) {
            EndGame();
            result = new ResultFrame(ResultVariable.ResultVar.FIRSTWIN);
        } else if (checkWinner.CheckWin(second, X, Y)) {
            EndGame();
            result = new ResultFrame(ResultVariable.ResultVar.SECONDWIN);
        } else if (checkWinner.CheckDraw()) {
            EndGame();
            result = new ResultFrame(ResultVariable.ResultVar.DRAW);
        }
    }

    public static void EndGame() {
        XOButton[][] buttons = GameField.GetButtons();
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (buttons[i][j].GetWho() == 0)
                    buttons[i][j].EndGame();
            }
        }
    }

    public static void Refresh() {
        turn = true;
        ChangeColor.ChangePvPTextColor(turn);
    }

}