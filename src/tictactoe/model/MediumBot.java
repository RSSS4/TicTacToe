package tictactoe.model;

import tictactoe.view.GameField;
import tictactoe.view.XOButton;

public class MediumBot extends Bot {
    private int difficulty;
    private int fieldSize;

    private int enemywho;
    private int who;

    private boolean isFind;
    private boolean isFind2;
    private boolean nextprediction;

    private XOButton[][] buttons;
    private static CheckWinner checkWinner;

    public MediumBot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    }

    @Override
    public void HitBot() {
        if (PvMGameProcess.getTurn() == 0) {
            if (who == 0) {
                enemywho = 1;
            } else enemywho = 2;
        } else {
            if (who == 0) {
                enemywho = 2;
            } else enemywho = 1;
        }
        if(!WinAttack()) {
            isFind = false;
            nextprediction = true;
            for (int i = 0; i < fieldSize; i++) {
                if (isFind) break;
                for (int j = 0; j < fieldSize; j++) {
                    checkWinner.refreshData(buttons);
                    if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                        buttons[i][j].setTest(enemywho, false);
                        if (checkWinner.CheckWin(enemywho, i, j)) {
                            buttons[i][j].setTest(0, true);
                            buttons[i][j].setWho(who);
                            isFind = true;
                            nextprediction = false;
                            PvMGameProcess.isWinner(i, j);
                            break;
                        } else buttons[i][j].setTest(0, true);
                    }
                }
            }
        }
        if (nextprediction) {
            isFind = false;
            for (int i = 0; i < fieldSize; i++) {
                if (isFind) break;
                for (int j = 0; j < fieldSize; j++) {
                    isFind2 = false;
                    checkWinner.refreshData(buttons);
                    if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                        buttons[i][j].setTest(enemywho, false);
                        isFind2 = true;
                        for (int k = 0; k < fieldSize; k++) {
                            if (isFind) break;
                            for (int l = 0; l < fieldSize; l++) {
                                if (buttons[k][l].isFree() && !PvMGameProcess.isEndGame()) {
                                    buttons[k][l].setTest(enemywho, false);
                                    if (checkWinner.CheckWin(enemywho, k, l)) {
                                        buttons[i][j].setTest(0, true);
                                        buttons[i][j].setWho(who);
                                        isFind = true;
                                        buttons[k][l].setTest(0, true);
                                        PvMGameProcess.isWinner(i, j);
                                        break;
                                    } else buttons[k][l].setTest(0, true);
                                }
                            }
                        }
                    }
                    if (isFind) break;
                    if (isFind2) buttons[i][j].setTest(0, true);
                }
            }
            if (!isFind) {
                RandomMove(who, fieldSize);
            }
        }
    }
    private boolean WinAttack() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                checkWinner.refreshData(buttons);
                if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                    buttons[i][j].setTest(who, false);
                    if (checkWinner.CheckWin(who, i, j)) {
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


}
