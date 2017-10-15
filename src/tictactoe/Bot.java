package tictactoe;

import java.awt.*;
import java.util.Random;

public class Bot {

    private int i;
    private int j;

    private int difficulty;
    private int fieldSize;

    private int who;

    private XOButton[][] buttons;

    public Bot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
    }

    public void BotHit() {
        if (PvMGameProcess.getComp()) {
            if (difficulty == 1)
                BotEasy();
            else if (difficulty == 2)
                BotMedium();
            else
                BotHard();
        }
    }

    public void BotEasy() {
        while (true) {
            i = RandValue();
            j = RandValue();
            if (buttons[i][j].isFree() && !PvMGameProcess.isEndGame()) {
                buttons[i][j].setWho(who);
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

    public void BotMedium() {

    }

    public void BotHard() {

    }

}
