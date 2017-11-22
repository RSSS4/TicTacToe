package tictactoe.view;

import tictactoe.view.GameField;
import tictactoe.view.GamePanel;
import tictactoe.view.ResultFrame;
import tictactoe.view.XOButton;
import java.awt.Color;

import javax.swing.*;

public class ChangeColor {


    public static void ChangePvPTextColor(boolean turn){
        if(turn) {
            GamePanel.PlayerLeftText().setForeground(new Color(139, 0, 0));
            GamePanel.PlayerRightText().setForeground(new Color(255, 255, 255));
        }
        else
        {
            GamePanel.PlayerLeftText().setForeground(new Color(255, 255, 255));
            GamePanel.PlayerRightText().setForeground(new Color(139, 0, 0));
        }
    }
    public static void ChangePvMTextColor(boolean turn){
        if(turn) {
            GamePanel.PlayerText().setForeground(new Color(255, 255, 255));
            GamePanel.ModText().setForeground(new Color(139, 0, 0));
        }
        else
        {
            GamePanel.ModText().setForeground(new Color(255, 255, 255));
            GamePanel.PlayerText().setForeground(new Color(139, 0, 0));
        }
    }
}
