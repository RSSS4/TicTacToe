package model;

import view.*;

import model.PvMGameProcess;
import model.PvPGameProcess;

import javax.swing.*;
import java.awt.*;


public class Buttons extends JButton{

    // first - 1, second - 2
    private int who;
    private boolean free;
    private int coordX;
    private int coordY;

    // 1 - pvp, 2 - pvm
    public Buttons(int whichGame) {
        if (whichGame == 1)
            gamePvP();
        else
            gameWithAI();

        free = true;


    }

    public void setWho(int who) {
        if (free) {
            free = false;
            this.who = who;
            if (who == 1)
                setIcon(GameField.getFieldSize() == 3 ? AllImages.x3
                        : (GameField.getFieldSize() == 5 ? AllImages.x5 : AllImages.x7));
            else
                setIcon(GameField.getFieldSize() == 3 ? AllImages.o3
                        : (GameField.getFieldSize() == 5 ? AllImages.o5 : AllImages.o7));
        }
    }

    public void setTest(int who, boolean free) {
        this.free = free;
        this.who = who;
    }

    public void gamePvP() {
        this.addActionListener( e -> {
            if (free) {
                setWho(PvPGameProcess.turn());
                free = false;
                PvPGameProcess.isWinner(coordX, coordY);
            }
        });
    }

    public void gameWithAI() {
        this.addActionListener( e -> {
            if (PvMGameProcess.getTurn() == 0 && free) {
                aiGameProcess ();
            }
            if (PvMGameProcess.getTurn() == 1 && free) {
                aiGameProcess ();
            }
        });
    }

    public void refresh() {
        who = 0;
        setIcon(null);
        setEnabled(true);
        free = true;
    }

    public void aiGameProcess ()
    {
        int which = PvMGameProcess.getTurn();
        setWho(which == 0 ? 2 : 1);
        PvMGameProcess.isWinner(coordX, coordY);
        PvMGameProcess.setComp(true);
        PvMGameProcess.lvl();
        PvMGameProcess.setComp(false);
    }

    public void endGame() {
        free = false;
    }

    public int getWho() {
        return who;
    }

    public boolean isFree() {
        return free;
    }

    public void setX(int coordX){this.coordX = coordX;}
    public void setY(int coordY){this.coordY = coordY;}

    public void setFree(boolean free){this.free=free;}

}
