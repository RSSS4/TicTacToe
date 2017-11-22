package tictactoe.model;

import tictactoe.view.ChangeColor;
import tictactoe.view.GameField;
import tictactoe.view.ResultFrame;
import tictactoe.view.XOButton;

import java.util.Random;

public class PvMGameProcess{

    private static ResultFrame result;

    private static CheckWinner checkWinner;
    private static int difficulty;

    // 0 - comp, 1 - player
    private static int turn;
    private static int fieldSize;

    private static boolean player;
    private static boolean comp;

    private static boolean EndGame = false;

    private static Bot boteasy;
    private static Bot botmid;
    private static Bot bothard;

    public PvMGameProcess(int fieldSize, int difficulty) {
        this.fieldSize = fieldSize;
        this.difficulty = difficulty;
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
        turn = randFirstTurn();
        boteasy = new EasyBot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        botmid = new MediumBot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        bothard = new HardBot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        System.out.println(turn + " turn");
        player = turn == 0 ? false : true;
        comp = turn == 0 ? true : false;
        if (comp){
            Lvl();
        }
        else
            ChangeColor.ChangePvMTextColor(false);
    }

    public static void Lvl(){
        ChangeColor.ChangePvMTextColor(true);
        if (difficulty == 1)
            boteasy.HitBot();
        else if (difficulty == 2) {
            botmid.HitBot();
        } else
            bothard.HitBot();
        ChangeColor.ChangePvMTextColor(false);
    }

    private static int randFirstTurn() {
        Random r = new Random();
        return r.nextInt(2);
    }

    public static void isWinner(int X,int Y) {
        XOButton[][] buttons = GameField.getButtons();
        checkWinner.refreshData(buttons);
        if (checkWinner.CheckWin(1, X, Y)) {
            endGame();
            if (turn == 0)
                result = new ResultFrame(ResultVariable.ResultVar.WIN);
            else
                result = new ResultFrame(ResultVariable.ResultVar.LOSE);
        } else if (checkWinner.CheckWin(2, X, Y)) {
            endGame();
            if (turn == 0)
                result = new ResultFrame(ResultVariable.ResultVar.LOSE);
            else
                result = new ResultFrame(ResultVariable.ResultVar.WIN);
        } else if (checkWinner.CheckDraw()) {
            endGame();
            result = new ResultFrame(ResultVariable.ResultVar.DRAW);
        }
    }

    public static void endGame() {
        EndGame = true;
        XOButton[][] buttons = GameField.getButtons();
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (buttons[i][j].getWho() == 0)
                    buttons[i][j].endGame();
            }
        }
    }

    public static void refresh() {
        EndGame = false;
        turn = randFirstTurn();
        System.out.println(turn + " turn");
        boteasy = new EasyBot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        botmid = new MediumBot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        bothard = new HardBot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        player = turn == 0 ? false : true;
        comp = turn == 0 ? true : false;
        if (comp) {
            if (difficulty == 1)
                boteasy.HitBot();
            else if (difficulty == 2) {
                botmid.HitBot();
            } else
                bothard.HitBot();
        }
    }

    public static boolean isEndGame() {
        return EndGame;
    }

    public static int getTurn() {
        return turn;
    }

    public static boolean getPlayer() {
        return player;
    }

    public static void setPlayer(boolean player) {
        PvMGameProcess.player = player;
    }

    public static boolean getComp() {
        return comp;
    }

    public static void setComp(boolean comp) {
        PvMGameProcess.comp = comp;
    }

//    public static Bot getBot() {
//        return bot;
//    }

    public static int getfieldSize() {
        return fieldSize;
    }
}