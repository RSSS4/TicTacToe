package tictactoe;

import java.util.Random;

public class PvMGameProcess {

    private static CheckWinner checkWinner;
    private static int difficulty;

    // 0 - comp, 1 - player
    private static int turn;
    private static int fieldSize;

    private static boolean player;
    private static boolean comp;

    private static boolean EndGame = false;

    private static Bot bot;

    public PvMGameProcess(int fieldSize, int difficulty) {
        this.fieldSize = fieldSize;
        this.difficulty = difficulty;
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
        turn = randFirstTurn();
        System.out.println(turn + " turn");
        bot = new Bot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        player = turn == 0 ? false : true;
        comp = turn == 0 ? true : false;
        if(comp)
            bot.BotHit();
    }

    private static int randFirstTurn() {
        Random r = new Random();
        return r.nextInt(2);
    }

    public boolean checkIfPlayerTerned() {
        int count = 0;
        XOButton[][] buttons = GameField.getButtons();
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                if (buttons[i][j].isFree())
                    count++;
        if (count % 2 == 0)
            return true;
        return false;
    }

    public static void isWinner() {
        checkWinner.refreshData(GameField.getButtons());
        if (checkWinner.CheckWin(1) || checkWinner.CheckWin(2) || checkWinner.CheckDraw())
            endGame();
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

    public static void refresh(){
        EndGame = false;
        turn = randFirstTurn();
        System.out.println(turn + " turn");
        bot = new Bot(fieldSize, difficulty, turn == 0 ? 1 : 2);
        player = turn == 0 ? false : true;
        comp = turn == 0 ? true : false;
        if(comp)
            bot.BotHit();
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

    public static Bot getBot() {
        return bot;
    }

    public static int getfieldSize(){
        return fieldSize;
    }
}
