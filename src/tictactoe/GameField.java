package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.bind.ValidationEvent;

public class GameField extends JPanel {

    private static int fieldSize;
    private static XOButton buttons[][];

    public GameField(int fieldSize,int whichGame){
        this.fieldSize = fieldSize;

        setLayout(new GridLayout(fieldSize, fieldSize));
        setSize(400,400);

        buttons = new XOButton[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                buttons[i][j] = new XOButton(whichGame);
                buttons[i][j].X = i;
                buttons[i][j].Y = j;
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    public static int getfieldSize() {
        return fieldSize;
    }

    public static XOButton[][] getButtons() {
        return buttons;
    }
}
