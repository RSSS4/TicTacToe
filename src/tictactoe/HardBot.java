package tictactoe;

public class HardBot extends Bot {

    private int difficulty;
    private int fieldSize;

    private int enemywho;
    private int who;

    private XOButton[][] buttons;

    public HardBot(int fieldSize, int difficulty, int who) {
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
    }


    public void HitBot(){

    }
}
