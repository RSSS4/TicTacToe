package model;

import view.GameField;

import java.util.Random;

public abstract class Bot {

    protected CheckWinner checkWinner;

    protected boolean isFind;
    protected boolean isFind2;

    protected int enemywho = 1;

    protected int pointToWin = 0;



    protected Buttons[][] buttons = GameField.getButtons();
    protected int fieldSize = GameField.getFieldSize();

    public abstract void hitBot();

    protected void randomMove(int who, int fieldSize) {
        int x;
        int y;
        boolean offFromloop = true;
        while (offFromloop) {
            x = randValue(fieldSize);
            y = randValue(fieldSize);
            if (buttons[x][y].isFree() && !PvMGameProcess.isEndGame()) {
                buttons[x][y].setWho(who);
                PvMGameProcess.isWinner(x, y);
                offFromloop = false;
            }
            if (PvMGameProcess.isEndGame())
                offFromloop = false;
        }
    }
    protected boolean winAttack(int who) {
        setEnemywho(who);
        setPointToWin(fieldSize);
        checkWinner = new CheckWinner(fieldSize,pointToWin);
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


    protected boolean defAttack(int who){
        setPointToWin(fieldSize);
        checkWinner = new CheckWinner(fieldSize, pointToWin);
            for (int i = 0; i < fieldSize; i++) {
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

    protected void setEnemywho(int who){
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
    protected void setPointToWin(int fieldSize){
        if(fieldSize == 3){
            pointToWin = 3;
        }else if(fieldSize == 5){
            pointToWin = 4;
        }else
            pointToWin = 5;
    }

    protected int getEnemywho(){return enemywho;}
    protected void setTestEnemyWho(int enemywho){this.enemywho=enemywho;}
    protected int getPointToWin(){return pointToWin;}
    protected void refreshData(Buttons[][] buttons) {
        this.buttons = buttons;
    }
    protected void setFieldSize(int fieldSize){this.fieldSize = fieldSize;}

}

