package tictactoe;

public class MediumBot extends Bot {
    private int difficulty;
    private int fieldSize;

    private int enemywho;
    private int who;

    private boolean isFind = false;

    private XOButton[][] buttons;
    private static CheckWinner checkWinner;

    public MediumBot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    }

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
        isFind = false;
        for (int k = 0; k < fieldSize; k++) {
            if (isFind) break;
            for (int s = 0; s < fieldSize; s++) {
                checkWinner.refreshData(buttons);
                if (buttons[k][s].isFree() && !PvMGameProcess.isEndGame()) {
                    buttons[k][s].setTest(enemywho);
                    if (checkWinner.CheckWin(enemywho, k, s)) {
                        buttons[k][s].setWho(who);
                        isFind = true;
                        PvMGameProcess.isWinner(k, s);
                        break;
                    } else buttons[k][s].setTest(0);
                }
            }
        }
        if (!isFind) {
            Bot hit = new EasyBot(fieldSize, difficulty, who);
            hit.HitBot();
        }


    }


}
