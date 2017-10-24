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
    private int settIsClicked = 0;

    private MainMenu mainMenu;
    private PvPMenu pvpMenu;
    private PvMMenu pvmMenu;
    private GamePanel gameField;

    private PvPGameProcess pvpgame;
    private PvMGameProcess pvmgame;

    private XOButton buttons[][];

    public GameFrame() {
        setUndecorated(true);

        mainMenu = new MainMenu(bgimg);
        pvpMenu = new PvPMenu(bgforpvp);
        pvmMenu = new PvMMenu(bgforpvm);

        add(mainMenu);

        pack();
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        mainMenu.setVisible(true);
        pvpMenu.setVisible(false);
        refresh();


        mainMenu.getSettings().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    mainMenu.getSettings().setIcon(AllImages.close);
                    mainMenu.getMusic().setVisible(true);
                    mainMenu.getExit().setVisible(true);
                    mainMenu.getExit().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            dispose();
                            refresh();
                        }
                    });
                    refresh();
                } else {
                    settIsClicked = 0;
                    mainMenu.getSettings().setIcon(AllImages.settings);
                    mainMenu.getMusic().setVisible(false);
                    mainMenu.getExit().setVisible(false);
                    refresh();
                }
            }
        });

        mainMenu.getPvPButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                settIsClicked = 0;
                mainMenu.getSettings().setIcon(AllImages.settings);
                mainMenu.getMusic().setVisible(false);
                mainMenu.getExit().setVisible(false);
                add(pvpMenu);
                pvpMenu.setVisible(true);
                mainMenu.setVisible(false);
                refresh();
            }
        });

        pvpMenu.getSettings().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    pvpMenu.getSettings().setIcon(AllImages.close);
                    pvpMenu.getMusic().setVisible(true);
                    pvpMenu.getMainMenu().setVisible(true);
                    pvpMenu.getMainMenu().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            settIsClicked = 0;
                            pvpMenu.getSettings().setIcon(AllImages.settings);
                            pvpMenu.getMusic().setVisible(false);
                            pvpMenu.getMainMenu().setVisible(false);
                            pvpMenu.getExit().setVisible(false);
                            mainMenu.setVisible(true);
                            pvpMenu.setVisible(false);
                            refresh();
                        }
                    });
                    pvpMenu.getExit().setVisible(true);
                    pvpMenu.getExit().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            dispose();
                            refresh();
                        }
                    });
                    refresh();
                } else {
                    settIsClicked = 0;
                    pvpMenu.getSettings().setIcon(AllImages.settings);
                    pvpMenu.getMusic().setVisible(false);
                    pvpMenu.getMainMenu().setVisible(false);
                    pvpMenu.getExit().setVisible(false);
                    refresh();
                }
            }
        });

        pvpMenu.getThreeButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvpMenu.getSettings().setIcon(AllImages.settings);
                pvpMenu.getMusic().setVisible(false);
                pvpMenu.getMainMenu().setVisible(false);
                pvpMenu.getExit().setVisible(false);
                gameField = new GamePanel(bgforfield, 3, 0, 1);
                gameField.getSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        gameField.getMusic().setVisible(true);
                        gameField.getMusic().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent arg0) {

                                refresh();
                            }
                        });
                        gameField.getMainMenu().setVisible(true);
                        gameField.getMainMenu().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                mainMenu.setVisible(true);
                                gameField.setVisible(false);
                                refresh();
                            }
                        });
                        gameField.getMainMenu().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                mainMenu.setVisible(true);
                                gameField.setVisible(false);
                                refresh();
                            }
                        });
                        gameField.getExit().setVisible(true);
                        gameField.getExit().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                dispose();
                                refresh();
                            }
                        });
                        refresh();
                    }
                });
                add(gameField);
                gameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(3);
                refresh();
            }
        });

        pvpMenu.getFiveButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvpMenu.getSettings().setIcon(AllImages.settings);
                pvpMenu.getMusic().setVisible(false);
                pvpMenu.getMainMenu().setVisible(false);
                pvpMenu.getExit().setVisible(false);
                gameField = new GamePanel(bgforfield, 5, 0, 1);
                gameField.getSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        gameField.getMusic().setVisible(true);
                        gameField.getMainMenu().setVisible(true);
                        gameField.getMainMenu().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                mainMenu.setVisible(true);
                                gameField.setVisible(false);
                                refresh();
                            }
                        });
                        gameField.getExit().setVisible(true);
                        gameField.getExit().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                dispose();
                                refresh();
                            }
                        });
                        refresh();
                    }
                });
                add(gameField);
                gameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(5);
                refresh();
            }
        });

        pvpMenu.getSevenButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvpMenu.getSettings().setIcon(AllImages.settings);
                pvpMenu.getMusic().setVisible(false);
                pvpMenu.getMainMenu().setVisible(false);
                pvpMenu.getExit().setVisible(false);
                gameField = new GamePanel(bgforfield, 7, 0, 1);
                gameField.getSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        gameField.getMusic().setVisible(true);
                        gameField.getMainMenu().setVisible(true);
                        gameField.getMainMenu().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                mainMenu.setVisible(true);
                                gameField.setVisible(false);
                                refresh();
                            }
                        });
                        gameField.getExit().setVisible(true);
                        gameField.getExit().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                dispose();
                                refresh();
                            }
                        });
                        refresh();
                    }
                });
                add(gameField);
                gameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(7);
                refresh();
            }
        });

        mainMenu.getPvMButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                mainMenu.getSettings().setIcon(AllImages.settings);
                mainMenu.getMusic().setVisible(false);
                mainMenu.getExit().setVisible(false);
                add(pvmMenu);
                pvmMenu.setVisible(true);
                mainMenu.setVisible(false);
                refresh();
            }
        });

        pvmMenu.getSettings().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    pvmMenu.getSettings().setIcon(AllImages.close);
                    pvmMenu.getMusic().setVisible(true);
                    pvmMenu.getMainMenu().setVisible(true);
                    pvmMenu.getMainMenu().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            settIsClicked = 0;
                            pvmMenu.getSettings().setIcon(AllImages.settings);
                            pvmMenu.getMusic().setVisible(false);
                            pvmMenu.getMainMenu().setVisible(false);
                            pvmMenu.getExit().setVisible(false);
                            mainMenu.setVisible(true);
                            pvmMenu.setVisible(false);
                            refresh();
                        }
                    });
                    pvmMenu.getExit().setVisible(true);
                    pvmMenu.getExit().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            dispose();
                            refresh();
                        }
                    });
                    refresh();
                } else {
                    settIsClicked = 0;
                    pvmMenu.getSettings().setIcon(AllImages.settings);
                    pvmMenu.getMusic().setVisible(false);
                    pvmMenu.getMainMenu().setVisible(false);
                    pvmMenu.getExit().setVisible(false);
                    refresh();
                }
            }
        });

        pvmMenu.getPlayPvMButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvmMenu.getSettings().setIcon(AllImages.settings);
                pvmMenu.getMusic().setVisible(false);
                pvmMenu.getMainMenu().setVisible(false);
                pvmMenu.getExit().setVisible(false);
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

                gameField = new GamePanel(bgforfield, fieldSize, difficulty, 2);
                gameField.getSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        gameField.getMusic().setVisible(true);
                        gameField.getMainMenu().setVisible(true);
                        gameField.getMainMenu().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                mainMenu.setVisible(true);
                                gameField.setVisible(false);
                                refresh();
                            }
                        });
                        gameField.getExit().setVisible(true);
                        gameField.getExit().addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                dispose();
                                refresh();
                            }
                        });
                        refresh();
                    }
                });
                pvmgame = new PvMGameProcess(fieldSize, difficulty);
                gameField.setVisible(true);
                pvmMenu.setVisible(false);
                add(gameField);

                refresh();
            }
        });
    }

    private void refresh() {
        validate();
        repaint();
    }
}
