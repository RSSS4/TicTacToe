package tictactoe.model;

import tictactoe.view.GameField;

import java.util.Random;

public abstract class Bot {
    private int a;
    private int b;

    protected CheckWinner checkWinner;


    private Buttons[][] buttons;

    abstract public void hitBot();

    protected void randomMove(int who, int fieldSize) {
        while (true) {
            buttons = GameField.getButtons();
            a = randValue(fieldSize);
            b = randValue(fieldSize);
            if (buttons[a][b].isFree() && !PvMGameProcess.isEndGame()) {
                buttons[a][b].setWho(who);
                PvMGameProcess.isWinner(a, b);
                break;
            }
            if (PvMGameProcess.isEndGame())
                break;
        }
    }
    protected boolean winAttack(int fieldSize,int who ) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                buttons = GameField.getButtons();
                checkWinner.refreshData(buttons);
                if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                    buttons[i][j].setTest(who, false);
                    if (checkWinner.checkWin(who, i, j)) {
                        buttons[i][j].setTest(0, true);
                        buttons[i][j].setWho(who);
                        PvMGameProcess.isWinner(i, j);
                        return true;
                    } else buttons[i][j].setTest(0, true);
                }
            }
        }
        return false;
    }

    private int randValue(int fieldSize) {
        Random rand = new Random();
        return rand.nextInt(fieldSize);
    }
}

