package tictactoe.model;

import tictactoe.view.GameField;
import tictactoe.view.XOButton;

import java.util.Random;

public abstract class Bot {
    private int i;
    private int j;

    private XOButton[][] buttons;

    abstract public void HitBot();

    protected void RandomMove(int who, int fieldSize) {
        while (true) {
            buttons = GameField.getButtons();
            i = RandValue(fieldSize);
            j = RandValue(fieldSize);
            if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                buttons[i][j].setWho(who);
                PvMGameProcess.isWinner(i, j);
                break;
            }
            if (PvMGameProcess.isEndGame())
                break;
        }
    }

    private int RandValue(int fieldSize) {
        Random rand = new Random();
        return rand.nextInt(fieldSize);
    }
}

