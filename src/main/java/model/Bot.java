package model;

import view.GameField;

import java.util.Random;

public abstract class Bot {

    protected CheckWinner checkWinner;

    protected boolean isFind;
    protected boolean isFind2;

    protected int enemywho;



    protected Buttons[][] buttons = GameField.getButtons();
    protected int fieldSize = GameField.getFieldSize();

    public abstract void hitBot();

    protected void randomMove(int who, int fieldSize) {
        int x;
        int y;
        while (true) {
            x = randValue(fieldSize);
            y = randValue(fieldSize);
            if (buttons[x][y].isFree() && !PvMGameProcess.isEndGame()) {
                buttons[x][y].setWho(who);
                PvMGameProcess.isWinner(x, y);
                break;
            }
            if (PvMGameProcess.isEndGame())
                break;
        }
    }
    protected boolean winAttack(int fieldSize,int who ) {
        getEnemywho(who);
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
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


    protected boolean defAttack(int fieldSize, int who){
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
            isFind = false;
            for (int i = 0; i < fieldSize; i++) {
                if (isFind) break;
                for (int j = 0; j < fieldSize; j++) {
                    checkWinner.refreshData(buttons);
                    if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                        buttons[i][j].setTest(enemywho, false);
                        if (checkWinner.checkWin(enemywho, i, j)) {
                            buttons[i][j].setTest(0, true);
                            buttons[i][j].setWho(who);
                            isFind = true;
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

    protected void getEnemywho(int who){
        if (PvMGameProcess.getTurn() == 0) {
            if (who == 0) {
                enemywho = 1;
            } else enemywho = 2;
        } else {
            if (who == 0) {
                enemywho = 2;
            } else enemywho = 1;
        }

    }
}

