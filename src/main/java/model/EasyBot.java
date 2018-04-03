package model;


public class EasyBot extends Bot {
    private int fieldSize;

    private int who;


    public EasyBot(int fieldSize, int who) {
        this.fieldSize = fieldSize;
        this.who = who;
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));

    }

    @Override
    public void hitBot() {
        if (!defAttack(fieldSize, who)) {
            randomMove(who, fieldSize);
        }
    }
}
