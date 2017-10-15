package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton {

    // first - 1, second - 2
    private int who;
    private boolean free;

    // 1 - pvp, 2 - pvm
    public XOButton(int whichGame) {
        if (whichGame == 1)
            gamePvP();
        else
            gameWithAI();

        free = true;

        setBackground(new Color(81, 99, 109));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }

    public void setWho(int who) {
        if (free) {
            free = false;
            this.who = who;
            if (who == 1)
                setIcon(GameField.getfieldSize() == 3 ? AllImages.x3
                        : (GameField.getfieldSize() == 5 ? AllImages.x5 : AllImages.x7));
            else
                setIcon(GameField.getfieldSize() == 3 ? AllImages.o3
                        : (GameField.getfieldSize() == 5 ? AllImages.o5 : AllImages.o7));
        }
    }

    public void gamePvP() {
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setWho(PvPGameProcess.turn());
                free = false;
                PvPGameProcess.isWinner();
            }
        });
    }

    public void gameWithAI() {
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (PvMGameProcess.getTurn() == 0) {
                    PvMGameProcess.isWinner();
                    int which = PvMGameProcess.getTurn();
                    setWho(which == 0 ? 2 : 1);
                    PvMGameProcess.isWinner();
                    PvMGameProcess.setComp(true);
                    PvMGameProcess.getBot().BotHit();
                }
                if (PvMGameProcess.getTurn() == 1) {
                    int which = PvMGameProcess.getTurn();
                    setWho(which == 0 ? 2 : 1);
                    PvMGameProcess.isWinner();
                    PvMGameProcess.setComp(true);
                    PvMGameProcess.getBot().BotHit();
                    PvMGameProcess.setComp(false);
                    PvMGameProcess.isWinner();
                }
            }
        });
    }

    public void refresh() {
        who = 0;
        setIcon(null);
        setEnabled(true);
        free = true;
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

    public void setFree(boolean free) {
        this.free = free;
    }

}
