package tictactoe.model;

import tictactoe.view.GameField;
import tictactoe.view.XOButton;

import java.util.Random;

public abstract class Bot {
    private int a;
    private int b;

    protected static CheckWinner checkWinner;


    private XOButton[][] buttons;

    abstract public void HitBot();

    protected void RandomMove(int who, int fieldSize) {
        while (true) {
            buttons = GameField.GetButtons();
            a = RandValue(fieldSize);
            b = RandValue(fieldSize);
            if (buttons[a][b].IsFree() && !PvMGameProcess.IsEndGame()) {
                buttons[a][b].SetWho(who);
                PvMGameProcess.IsWinner(a, b);
                break;
            }
            if (PvMGameProcess.IsEndGame())
                break;
        }
    }
    protected boolean WinAttack(int fieldSize,int who ) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                buttons = GameField.GetButtons();
                checkWinner.RefreshData(buttons);
                if (buttons[i][j].IsFree() && !PvMGameProcess.IsEndGame()) {
                    buttons[i][j].SetTest(who, false);
                    if (checkWinner.CheckWin(who, i, j)) {
                        buttons[i][j].SetTest(0, true);
                        buttons[i][j].SetWho(who);
                        PvMGameProcess.IsWinner(i, j);
                        return true;
                    } else buttons[i][j].SetTest(0, true);
                }
            }
        }
        return false;
    }

    private int RandValue(int fieldSize) {
        Random rand = new Random();
        return rand.nextInt(fieldSize);
    }
}

