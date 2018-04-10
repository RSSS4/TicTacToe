package view;

import model.*;

import java.awt.*;
import javax.swing.*;

public class GameField extends JPanel {

    private static int fieldSize;
    private static Buttons buttons[][];

    public GameField(int fieldSize, int whichGame) {
        this.fieldSize = fieldSize;

        setLayout(new GridLayout(fieldSize, fieldSize));
        setSize(400, 400);

        buttons = new Buttons[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                buttons[i][j] = new Buttons(whichGame);
                buttons[i][j].setX(i);
                buttons[i][j].setY(j);
                buttons[i][j].setBackground(new Color(127, 131, 135));
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    public static int getFieldSize() {
        return fieldSize;
    }

    public static Buttons[][] getButtons() {
        return buttons;
    }
}