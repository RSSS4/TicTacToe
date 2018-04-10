package model;


public class EasyBot extends Bot {
    private int fieldSize;

    private int who;


    public EasyBot(int fieldSize, int who) {
        this.fieldSize = fieldSize;
        this.who = who;

    }

    @Override
    public void hitBot() {
        if (!defAttack(fieldSize, who)) {
            randomMove(who, fieldSize);
        }
    }
}
