package model;

import view.ChangeColor;
import view.GameField;
import view.ResultFrame;

import java.util.Random;

public class PvMGameProcess {

    private static ResultFrame result;

    private static CheckWinner checkWinner;
    private static int difficulty;

    // 0 - comp, 1 - player
    private static int turn;
    private static int fieldSize;

    private static boolean player;
    private static boolean comp;

    private static boolean endGame = false;

    private static ChangeColor color;
    private static Bot boteasy;
    private static Bot botmid;
    private static Bot bothard;
    private static Bot botultr;
    private static Buttons[][] buttons;

    public PvMGameProcess(int fieldSize, int difficulty) {
        setData(fieldSize, difficulty);

    }
private void setData(int fieldSize, int difficulty){
    this.fieldSize = fieldSize;
    this.difficulty = difficulty;
    checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
    turn = randFirstTurn();
    boteasy = new EasyBot(turn == 0 ? 1 : 2);
    botmid = new MediumBot(turn == 0 ? 1 : 2);
    bothard = new HardBot(turn == 0 ? 1 : 2);
    botultr = new UltrBot(turn == 0 ? 1 : 2);
    color = new ChangeColor();
    player = turn == 0 ? false : true;
    comp = turn == 0 ? true : false;
    buttons = GameField.getButtons();
    if (!comp)
        color.changePvMTextColor(false);
}
    public static void lvl() {
        color.changePvMTextColor(true);
        if (difficulty == 1)
            boteasy.hitBot();
        else if (difficulty == 2) {
            botmid.hitBot();
        } else if (difficulty == 3)
            bothard.hitBot();
        else {
            botultr.hitBot();
        }
        color.changePvMTextColor(false);
    }

    private static int randFirstTurn() {
        Random r = new Random();
        return r.nextInt(2);
    }

    public static void isWinner(int X, int Y) {
        checkWinner.refreshData(buttons);
        if (checkWinner.checkWin(1, X, Y)) {
            endGame();
            if (turn == 0)
                result = new ResultFrame(ResultVariable.ResultVar.WIN);
            else
                result = new ResultFrame(ResultVariable.ResultVar.LOSE);
        } else if (checkWinner.checkWin(2, X, Y)) {
            endGame();
            if (turn == 0)
                result = new ResultFrame(ResultVariable.ResultVar.LOSE);
            else
                result = new ResultFrame(ResultVariable.ResultVar.WIN);
        } else if (checkWinner.checkDraw()) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.DRAW);
        }
    }

    public static void endGame() {
        endGame = true;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (buttons[i][j].getWho() == 0)
                    buttons[i][j].endGame();
            }
        }
    }

    public static void refresh() {
        endGame = false;
        turn = randFirstTurn();
        boteasy = new EasyBot(turn == 0 ? 1 : 2);
        botmid = new MediumBot(turn == 0 ? 1 : 2);
        bothard = new HardBot(turn == 0 ? 1 : 2);
        botultr = new UltrBot(turn == 0 ? 1 : 2);
        player = turn == 0 ? false : true;
        comp = turn == 0 ? true : false;
        if (comp) {
            if (difficulty == 1)
                boteasy.hitBot();
            else if (difficulty == 2) {
                botmid.hitBot();
            } else if (difficulty == 3)
                bothard.hitBot();
            else
                botultr.hitBot();
        }
    }

    public static boolean isEndGame() {
        return endGame;
    }

    public static int getTurn() {
        return turn;
    }
    public static void setTurn(int turn){PvMGameProcess.turn = turn;}

    public static void setComp(boolean comp) {
        PvMGameProcess.comp = comp;
    }
    public static void refreshData(Buttons[][] buttons) {
        PvMGameProcess.buttons = buttons;
    }

}