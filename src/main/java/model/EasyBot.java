package model;


public class EasyBot extends Bot {

    private int who;


    public EasyBot(int who) {
        this.who = who;
        getEnemywho(who);
    }

    @Override
    public void hitBot() {
        if (!defAttack(who)) {
            randomMove(who, fieldSize);
        }
    }
}
