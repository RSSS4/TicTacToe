package tictactoe.model;

import tictactoe.view.GameField;
import tictactoe.view.XOButton;

public class HardBot extends Bot {

    private int difficulty;
    private int fieldSize;

    private int enemywho;
    private int who;

    private boolean isFind;
    private boolean isFind2;
    private boolean isFind3;
    private boolean isFind4;
    private boolean nextprediction = false;
    private boolean nextprediction2 = false;
    private boolean nextprediction3 = false;

    private XOButton[][] buttons;
    private static CheckWinner checkWinner;

    public HardBot(int fieldSize, int difficulty, int who) {
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
        nextprediction = false;
        if (!WinAttack()) {
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
            nextprediction2 = false;
            if (!PredictionAttack()) {
                nextprediction2 = true;
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
                                            buttons[k][l].setTest(0, true);
                                            buttons[k][l].setWho(who);
                                            isFind = true;
                                            nextprediction2 = false;
                                            buttons[i][j].setTest(0, true);
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
            }
        }
        if (nextprediction2) {
            nextprediction3 = false;
            if (!PredictionAttack2()) {
                nextprediction3 = true;
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
                                    isFind3 = false;
                                    if (buttons[k][l].isFree() && !PvMGameProcess.isEndGame()) {
                                        buttons[k][l].setTest(enemywho, false);
                                        isFind3 = true;
                                        for (int m = 0; m < fieldSize; m++) {
                                            if (isFind) break;
                                            for (int n = 0; n < fieldSize; n++) {
                                                if (buttons[m][n].isFree() && !PvMGameProcess.isEndGame()) {
                                                    buttons[m][n].setTest(enemywho, false);
                                                    if (checkWinner.CheckWin(enemywho, m, n)) {
                                                        buttons[m][n].setTest(0, true);
                                                        buttons[m][n].setWho(who);
                                                        nextprediction3 = false;
                                                        isFind = true;
                                                        buttons[i][j].setTest(0, true);
                                                        buttons[k][l].setTest(0, true);
                                                        PvMGameProcess.isWinner(i, j);
                                                        break;
                                                    } else buttons[m][n].setTest(0, true);
                                                }
                                            }
                                        }
                                    }
                                    if (isFind) break;
                                    if (isFind3) buttons[k][l].setTest(0, true);
                                }
                            }
                        }
                        if (isFind) break;
                        if (isFind2) buttons[i][j].setTest(0, true);
                    }
                }
                if (!isFind && fieldSize != 7) {
                    RandomMove(who, fieldSize);
                }
            }
        }
        if (nextprediction3 && fieldSize == 7) {
            if (!PredictionAttack3()) {
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
                                    isFind3 = false;
                                    if (buttons[k][l].isFree() && !PvMGameProcess.isEndGame()) {
                                        buttons[k][l].setTest(enemywho, false);
                                        isFind3 = true;
                                        for (int m = 0; m < fieldSize; m++) {
                                            if (isFind) break;
                                            for (int n = 0; n < fieldSize; n++) {
                                                isFind4 = false;
                                                if (buttons[m][n].isFree() && !PvMGameProcess.isEndGame()) {
                                                    buttons[m][n].setTest(enemywho, false);
                                                    isFind4 = true;
                                                    for (int o = 0; o < fieldSize; o++) {
                                                        if (isFind) break;
                                                        for (int p = 0; p < fieldSize; p++) {
                                                            if (buttons[o][p].isFree() && !PvMGameProcess.isEndGame()) {
                                                                buttons[o][p].setTest(enemywho, false);
                                                                if (checkWinner.CheckWin(enemywho, o, p)) {
                                                                    buttons[o][p].setTest(0, true);
                                                                    buttons[o][p].setWho(who);
                                                                    isFind = true;
                                                                    buttons[i][j].setTest(0, true);
                                                                    buttons[m][n].setTest(0, true);
                                                                    buttons[k][l].setTest(0, true);
                                                                    PvMGameProcess.isWinner(i, j);
                                                                    break;
                                                                } else buttons[o][p].setTest(0, true);
                                                            }
                                                        }
                                                    }
                                                }
                                                if (isFind) break;
                                                if (isFind4) buttons[m][n].setTest(0, true);
                                            }
                                        }
                                    }
                                    if (isFind) break;
                                    if (isFind3) buttons[k][l].setTest(0, true);
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

    private boolean PredictionAttack() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                isFind2 = false;
                checkWinner.refreshData(buttons);
                if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                    buttons[i][j].setTest(who, false);
                    isFind2 = true;
                    for (int k = 0; k < fieldSize; k++) {
                        for (int l = 0; l < fieldSize; l++) {
                            if (buttons[k][l].isFree() && !PvMGameProcess.isEndGame()) {
                                buttons[k][l].setTest(who, false);
                                if (checkWinner.CheckWin(who, k, l)) {
                                    buttons[k][l].setTest(0, true);
                                    buttons[k][l].setWho(who);
                                    buttons[i][j].setTest(0, true);
                                    PvMGameProcess.isWinner(i, j);
                                    return true;
                                } else buttons[k][l].setTest(0, true);
                            }
                        }
                    }
                }
                if (isFind2) buttons[i][j].setTest(0, true);
            }
        }
        return false;
    }

    private boolean PredictionAttack2() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                isFind2 = false;
                checkWinner.refreshData(buttons);
                if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                    buttons[i][j].setTest(who, false);
                    isFind2 = true;
                    for (int k = 0; k < fieldSize; k++) {
                        for (int l = 0; l < fieldSize; l++) {
                            isFind3 = false;
                            if (buttons[k][l].isFree() && !PvMGameProcess.isEndGame()) {
                                buttons[k][l].setTest(who, false);
                                isFind3 = true;
                                for (int m = 0; m < fieldSize; m++) {
                                    for (int n = 0; n < fieldSize; n++) {
                                        if (buttons[m][n].isFree() && !PvMGameProcess.isEndGame()) {
                                            buttons[m][n].setTest(who, false);
                                            if (checkWinner.CheckWin(who, m, n)) {
                                                buttons[m][n].setTest(0, true);
                                                buttons[m][n].setWho(who);
                                                nextprediction3 = false;
                                                buttons[i][j].setTest(0, true);
                                                buttons[k][l].setTest(0, true);
                                                PvMGameProcess.isWinner(i, j);
                                                return true;
                                            } else buttons[m][n].setTest(0, true);
                                        }
                                    }
                                }
                            }
                            if (isFind3) buttons[k][l].setTest(0, true);
                        }
                    }
                }
                if (isFind2) buttons[i][j].setTest(0, true);
            }
        }
        return false;
    }

    private boolean PredictionAttack3() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                isFind2 = false;
                checkWinner.refreshData(buttons);
                if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                    buttons[i][j].setTest(who, false);
                    isFind2 = true;
                    for (int k = 0; k < fieldSize; k++) {
                        for (int l = 0; l < fieldSize; l++) {
                            isFind3 = false;
                            if (buttons[k][l].isFree() && !PvMGameProcess.isEndGame()) {
                                buttons[k][l].setTest(who, false);
                                isFind3 = true;
                                for (int m = 0; m < fieldSize; m++) {
                                    for (int n = 0; n < fieldSize; n++) {
                                        isFind4 = false;
                                        if (buttons[m][n].isFree() && !PvMGameProcess.isEndGame()) {
                                            buttons[m][n].setTest(who, false);
                                            isFind4 = true;
                                            for (int o = 0; o < fieldSize; o++) {
                                                for (int p = 0; p < fieldSize; p++) {
                                                    if (buttons[o][p].isFree() && !PvMGameProcess.isEndGame()) {
                                                        buttons[o][p].setTest(who, false);
                                                        if (checkWinner.CheckWin(who, o, p)) {
                                                            buttons[o][p].setTest(0, true);
                                                            buttons[o][p].setWho(who);
                                                            buttons[i][j].setTest(0, true);
                                                            buttons[m][n].setTest(0, true);
                                                            buttons[k][l].setTest(0, true);
                                                            PvMGameProcess.isWinner(i, j);
                                                            return true;
                                                        } else buttons[o][p].setTest(0, true);
                                                    }
                                                }
                                            }
                                        }
                                        if (isFind4) buttons[m][n].setTest(0, true);
                                    }
                                }
                            }
                            if (isFind3) buttons[k][l].setTest(0, true);
                        }
                    }
                }
                if (isFind2) buttons[i][j].setTest(0, true);
            }
        }
        return false;
    }
}
