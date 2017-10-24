package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {

    private String bgimg = "bg.jpg";
    private String bgforfield = "bgforfield.png";
    private String bgforpvp = "bgforpvp.jpg";
    private String bgforpvm = "bgforpvm.jpg";

    private int fieldSize;
    private int difficulty;

    private MainMenu mainMenu;
    private PvPMenu pvpMenu;
    private PvMMenu pvmMenu;
    private GamePanel GameField;

    private PvPGameProcess pvpgame;
    private PvMGameProcess pvmgame;

    private XOButton buttons[][];

    public GameFrame() {
        super("TicTacToe");

        mainMenu = new MainMenu(bgimg);
        pvpMenu = new PvPMenu(bgforpvp);
        pvmMenu = new PvMMenu(bgforpvm);

        add(mainMenu);

        pack();
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        mainMenu.setVisible(true);
        pvpMenu.setVisible(false);
        refresh();

        mainMenu.getPvPButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                add(pvpMenu);
                pvpMenu.setVisible(true);
                mainMenu.setVisible(false);
                refresh();
            }
        });

        pvpMenu.getThreeButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameField = new GamePanel(bgforfield, 3, 0,1);
                add(GameField);
                GameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(3);
                refresh();
            }
        });

        pvpMenu.getFiveButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameField = new GamePanel(bgforfield, 5, 0,1);
                add(GameField);
                GameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(5);
                refresh();
            }
        });

        pvpMenu.getSevenButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameField = new GamePanel(bgforfield, 7, 0,1);
                add(GameField);
                GameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(7);
                refresh();
            }
        });

        mainMenu.getPvMButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add(pvmMenu);
                pvmMenu.setVisible(true);
                mainMenu.setVisible(false);
                refresh();
            }
        });

        pvmMenu.getPlayPvMButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (pvmMenu.three.isSelected())
                    fieldSize = 3;
                else if (pvmMenu.five.isSelected())
                    fieldSize = 5;
                else
                    fieldSize = 7;
                if (pvmMenu.easy.isSelected())
                    difficulty = 1;
                else if (pvmMenu.medium.isSelected())
                    difficulty = 2;
                else
                    difficulty = 3;

                GameField = new GamePanel(bgforfield, fieldSize, difficulty,2);
                pvmgame = new PvMGameProcess(fieldSize,difficulty);
                GameField.setVisible(true);
                pvmMenu.setVisible(false);
                add(GameField);

                refresh();
            }
        });
    }

    private void refresh() {
        validate();
        repaint();
    }
}
