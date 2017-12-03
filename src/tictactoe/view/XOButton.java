package tictactoe.view;

import tictactoe.model.PvMGameProcess;
import tictactoe.model.PvPGameProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton {

    // first - 1, second - 2
    private int who;
    private boolean free;
    int X, Y;

    // 1 - pvp, 2 - pvm
    public XOButton(int whichGame) {
        if (whichGame == 1)
            GamePvP();
        else
            GameWithAI();

        free = true;

        setBackground(new Color(127, 131, 135));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }

    public void SetWho(int who) {
        if (free) {
            free = false;
            this.who = who;
            if (who == 1)
                setIcon(GameField.GetFieldSize() == 3 ? AllImages.x3
                        : (GameField.GetFieldSize() == 5 ? AllImages.x5 : AllImages.x7));
            else
                setIcon(GameField.GetFieldSize() == 3 ? AllImages.o3
                        : (GameField.GetFieldSize() == 5 ? AllImages.o5 : AllImages.o7));
        }
    }

    public void SetTest(int who, boolean free) {
        this.free = free;
        this.who = who;
    }

    public void GamePvP() {
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (free) {
                    SetWho(PvPGameProcess.Turn());
                    free = false;
                    PvPGameProcess.IsWinner(X, Y);
                }
            }
        });
    }

    public void GameWithAI() {
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (PvMGameProcess.GetTurn() == 0 && free) {
                    int which = PvMGameProcess.GetTurn();
                    SetWho(which == 0 ? 2 : 1);
                    PvMGameProcess.IsWinner(X, Y);
                    PvMGameProcess.SetComp(true);
                    PvMGameProcess.Lvl();
                    PvMGameProcess.SetComp(false);
                }
                if (PvMGameProcess.GetTurn() == 1 && free) {
                    int which = PvMGameProcess.GetTurn();
                    SetWho(which == 0 ? 2 : 1);
                    PvMGameProcess.IsWinner(X, Y);
                    PvMGameProcess.SetComp(true);
                    PvMGameProcess.Lvl();
                    PvMGameProcess.SetComp(false);
                }
            }
        });
    }

    public void Refresh() {
        who = 0;
        setIcon(null);
        setEnabled(true);
        free = true;
    }

    public void EndGame() {
        free = false;
    }

    public int GetWho() {
        return who;
    }

    public boolean IsFree() {
        return free;
    }

}
