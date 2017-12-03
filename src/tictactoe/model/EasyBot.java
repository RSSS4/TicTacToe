package tictactoe.model;

import tictactoe.view.GameField;
import tictactoe.view.XOButton;

public class EasyBot extends Bot {
    private int difficulty;
    private int fieldSize;

    private int enemywho;
    private int who;

    private boolean isFind = false;

    private XOButton[][] buttons;
    private static CheckWinner checkWinner;

    public EasyBot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.GetButtons();
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    }

    @Override
    public void HitBot() {
        if (PvMGameProcess.GetTurn() == 0) {
            if (who == 0) {
                enemywho = 1;
            } else enemywho = 2;
        } else {
            if (who == 0) {
                enemywho = 2;
            } else enemywho = 1;
        }
        isFind = false;
        for (int k = 0; k < fieldSize; k++) {
            if (isFind) break;
            for (int s = 0; s < fieldSize; s++) {
                checkWinner.RefreshData(buttons);
                if (buttons[k][s].IsFree() && !PvMGameProcess.IsEndGame()) {
                    buttons[k][s].SetTest(enemywho, false);
                    if (checkWinner.CheckWin(enemywho, k, s)) {
                        buttons[k][s].SetTest(0, true);
                        buttons[k][s].SetWho(who);
                        isFind = true;
                        PvMGameProcess.IsWinner(k, s);
                        break;
                    } else buttons[k][s].SetTest(0, true);
                }
            }
        }
        if (!isFind) {
            RandomMove(who, fieldSize);
        }


    }


}
