package view;

import org.junit.Test;

import javax.swing.*;
import java.awt.Color;

import static org.junit.Assert.*;

public class ChangeColorTest {

    @Test
    public void changePvPTextColor() {
        String bgforfield = "res/bg/bg3.jpg";
        GamePanel gameField = new GamePanel(bgforfield, 3, 0, 1);
        JTextArea playerLeftText = new JTextArea();
        playerLeftText.setForeground(gameField.playerLeftText().getForeground());

        ChangeColor color = new ChangeColor();
        color.changePvPTextColor(true);

        assertNotEquals(playerLeftText,gameField.playerLeftText());
    }

    @Test
    public void changePvMTextColor() {
        String bgforfield = "res/bg/bg3.jpg";
        GamePanel gameField = new GamePanel(bgforfield, 3, 0, 1);
        JTextArea playerLeftText = new JTextArea();
        playerLeftText.setForeground(gameField.playerLeftText().getForeground());

        ChangeColor color = new ChangeColor();
        color.changePvMTextColor(true);

        assertNotEquals(playerLeftText,gameField.playerLeftText());
    }
}