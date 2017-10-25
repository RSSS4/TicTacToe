package tictactoe;

import java.util.Random;

public class EasyBot extends Bot{
    private int i;
    private int j;

    private int difficulty;
    private int fieldSize;
    private int who;

    private XOButton[][] buttons;

    public EasyBot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
    }

    public void HitBot() {
        while (true) {
            i = RandValue();
            j = RandValue();
            if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                buttons[i][j].setWho(who);
                PvMGameProcess.isWinner(i, j);
                break;
            }
            if (PvMGameProcess.isEndGame())
                break;
        }
    }

    private int RandValue() {
        Random rand = new Random();
        return rand.nextInt(fieldSize);
    }

}
