package model;

import view.GameField;

public class MediumBot extends Bot {

    private int who;


    public MediumBot(int who) {
        this.who = who;
    }

    @Override
    public void hitBot() {
        if (!winAttack(fieldSize, who)) {
            if (!defAttack(fieldSize, who)) {
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
                                        if (checkWinner.checkWin(enemywho, k, l)) {
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
                    randomMove(who, fieldSize);
                }
            }
        }
    }


}
