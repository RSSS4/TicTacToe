package tictactoe;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.util.Random;

public class Bot {
    private static CheckWinner checkWinner;

    private int i;
    private int j;

    private int difficulty;
    private int fieldSize;

    private boolean isFind = false;
    private int enemywho;
    private int who;

    private XOButton[][] buttons;

    public Bot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    }

    public void BotHit() {
        System.out.println(fieldSize);
        if (PvMGameProcess.getComp()) {

            if (difficulty == 1)
                BotEasy();
            else if (difficulty == 2) {
                BotMedium();
            }
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

    public void BotMedium() {
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
            BotEasy();
        }


    }

    public void BotHard() {

    }

}
