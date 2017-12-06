package tictactoe.view;

import tictactoe.view.GameField;
import tictactoe.view.GamePanel;
import tictactoe.view.ResultFrame;

import java.awt.Color;

import javax.swing.*;

public class ChangeColor {


    public static void changePvPTextColor(boolean turn) {
        if (turn) {
            GamePanel.playerLeftText().setForeground(new Color(139, 0, 0));
            GamePanel.playerRightText().setForeground(new Color(255, 255, 255));
        } else {
            GamePanel.playerLeftText().setForeground(new Color(255, 255, 255));
            GamePanel.playerRightText().setForeground(new Color(139, 0, 0));
        }
    }

    public static void changePvMTextColor(boolean turn) {
        if (turn) {
            GamePanel.playerText().setForeground(new Color(255, 255, 255));
            GamePanel.modText().setForeground(new Color(139, 0, 0));
        } else {
            GamePanel.modText().setForeground(new Color(255, 255, 255));
            GamePanel.playerText().setForeground(new Color(139, 0, 0));
        }
    }
}
