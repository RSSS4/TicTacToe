package view;


import view.GamePanel;


import java.awt.Color;

import javax.swing.*;

public class ChangeColor {


    public void changePvPTextColor(boolean turn) {
        if (turn) {
            GamePanel.playerLeftText().setForeground(new Color(139, 0, 0));
            GamePanel.playerRightText().setForeground(new Color(255, 255, 255));
        } else {
            GamePanel.playerLeftText().setForeground(new Color(255, 255, 255));
            GamePanel.playerRightText().setForeground(new Color(139, 0, 0));
        }
    }

    public void changePvMTextColor(boolean turn) {
        if (turn) {
            GamePanel.playerText().setForeground(new Color(255, 255, 255));
            GamePanel.modText().setForeground(new Color(139, 0, 0));
        } else {
            GamePanel.modText().setForeground(new Color(255, 255, 255));
            GamePanel.playerText().setForeground(new Color(139, 0, 0));
        }
    }

}
