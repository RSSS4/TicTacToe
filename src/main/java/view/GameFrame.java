package view;

import model.PvMGameProcess;
import model.PvPGameProcess;
import model.Buttons;

import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame {

    private String bgimg = "res/bg/bg.jpg";
    private String bgforfield;
    private String bgforpvm = "res/bg/bgforpvm.jpg";
    private String bgforpvp = "res/bg/bgforpvp.jpg";

    private int fieldSize;
    private int difficulty;
    private int settIsClicked = 0;
    private boolean musicPlay = true;

    private MainMenu mainMenu;
    private PvPMenu pvpMenu;
    private PvMMenu pvmMenu;
    private GamePanel gameField;
    private Music music;

    private PvPGameProcess pvpgame;
    private PvMGameProcess pvmgame;

    private Buttons[][] buttons;

    public GameFrame() {
        setUndecorated(true);

        mainMenu = new MainMenu(bgimg);
        pvpMenu = new PvPMenu(bgforpvp);
        pvmMenu = new PvMMenu(bgforpvm);
        music = new Music();

        add(mainMenu);

        music.playMusic();

        pack();
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        mainMenu.setVisible(true);
        pvpMenu.setVisible(false);
        refresh();


        mainMenu.getSettings().addActionListener((ActionEvent arg0) -> {
            if (settIsClicked == 0) {
                settIsClicked = 1;
                mainMenu.getSettings().setIcon(AllImages.close);
                mainMenu.getMusic().setVisible(true);
                if (musicPlay)
                    mainMenu.getMusic().setIcon(AllImages.music);
                else
                    mainMenu.getMusic().setIcon(AllImages.nomusic);
                mainMenu.getMusic().addActionListener(e -> {
                    if (musicPlay) {
                        musicPlay = false;
                        music.getMusic().stop();
                        mainMenu.getMusic().setIcon(AllImages.nomusic);
                        refresh();
                    } else {
                        musicPlay = true;
                        music.getMusic().start();
                        music.getMusic().loop(10);
                        mainMenu.getMusic().setIcon(AllImages.music);
                        refresh();
                    }
                });
                mainMenu.getExit().setVisible(true);
                mainMenu.getExit().addActionListener(arg0114 -> exit());
                refresh();
            } else {
                settIsClicked = 0;
                mainMenu.getSettings().setIcon(AllImages.settings);
                mainMenu.getMusic().setVisible(false);
                mainMenu.getExit().setVisible(false);
                refresh();
            }
        });

        mainMenu.getPvPButton().addActionListener(arg0 -> {
            settIsClicked = 0;
            mainMenu.getSettings().setIcon(AllImages.settings);
            mainMenu.getMusic().setVisible(false);
            mainMenu.getExit().setVisible(false);
            add(pvpMenu);
            pvpMenu.setVisible(true);
            mainMenu.setVisible(false);
            refresh();
        });

        pvpMenu.getSettings().addActionListener(arg0 -> {
            if (settIsClicked == 0) {
                settIsClicked = 1;
                pvpMenu.getSettings().setIcon(AllImages.close);
                pvpMenu.getMusic().setVisible(true);
                if (musicPlay)
                    pvpMenu.getMusic().setIcon(AllImages.music);
                else
                    pvpMenu.getMusic().setIcon(AllImages.nomusic);
                pvpMenu.getMusic().addActionListener(e -> {
                    if (musicPlay) {
                        musicPlay = false;
                        music.getMusic().stop();
                        pvpMenu.getMusic().setIcon(AllImages.nomusic);
                        refresh();
                    } else {
                        musicPlay = true;
                        music.getMusic().start();
                        music.getMusic().loop(10);
                        pvpMenu.getMusic().setIcon(AllImages.music);
                        refresh();
                    }
                });
                pvpMenu.getMainMenu().setVisible(true);
                pvpMenu.getMainMenu().addActionListener(arg01 -> {
                    settIsClicked = 0;
                    pvpMenu.getSettings().setIcon(AllImages.settings);
                    pvpMenu.getMusic().setVisible(false);
                    pvpMenu.getMainMenu().setVisible(false);
                    pvpMenu.getExit().setVisible(false);
                    mainMenu.setVisible(true);
                    pvpMenu.setVisible(false);
                    refresh();
                });
                pvpMenu.getExit().setVisible(true);
                pvpMenu.getExit().addActionListener(arg012 -> exit());
                refresh();
            } else {
                settIsClicked = 0;
                pvpMenu.getSettings().setIcon(AllImages.settings);
                pvpMenu.getMusic().setVisible(false);
                pvpMenu.getMainMenu().setVisible(false);
                pvpMenu.getExit().setVisible(false);
                refresh();
            }
        });

        pvpMenu.getThreeButton().addActionListener(e -> {
            settIsClicked = 0;
            pvpMenu.getSettings().setIcon(AllImages.settings);
            pvpMenu.getMusic().setVisible(false);
            pvpMenu.getMainMenu().setVisible(false);
            pvpMenu.getExit().setVisible(false);
            bgforfield = "res/bg/bg3.jpg";
            gameField = new GamePanel(bgforfield, 3, 0, 1);
            gameField.getSettings().addActionListener(arg0 -> {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    gameField.getSettings().setIcon(AllImages.close);
                    gameField.getMusic().setVisible(true);
                    if (musicPlay)
                        gameField.getMusic().setIcon(AllImages.music);
                    else
                        gameField.getMusic().setIcon(AllImages.nomusic);
                    gameField.getMusic().addActionListener(e1 -> {
                        if (musicPlay) {
                            musicPlay = false;
                            music.getMusic().stop();
                            gameField.getMusic().setIcon(AllImages.nomusic);
                            refresh();
                        } else {
                            musicPlay = true;
                            music.getMusic().start();
                            music.getMusic().loop(10);
                            gameField.getMusic().setIcon(AllImages.music);
                            refresh();
                        }
                    });
                    gameField.getMainMenu().setVisible(true);
                    gameField.getMainMenu().addActionListener(arg013 -> {
                        mainMenu.setVisible(true);
                        gameField.setVisible(false);
                        refresh();
                    });
                    gameField.getMainMenu().addActionListener(arg014 -> {
                        mainMenu.setVisible(true);
                        gameField.setVisible(false);
                        refresh();
                    });
                    gameField.getExit().setVisible(true);
                    gameField.getExit().addActionListener(arg015 -> exit());
                    refresh();
                } else {
                    settIsClicked = 0;
                    gameField.getSettings().setIcon(AllImages.settings);
                    gameField.getMusic().setVisible(false);
                    gameField.getMainMenu().setVisible(false);
                    gameField.getExit().setVisible(false);
                    refresh();
                }
            });
            add(gameField);
            gameField.setVisible(true);
            pvpMenu.setVisible(false);
            mainMenu.setVisible(false);
            pvpgame = new PvPGameProcess(3);
            refresh();
        });

        pvpMenu.getFiveButton().addActionListener(e -> {
            settIsClicked = 0;
            pvpMenu.getSettings().setIcon(AllImages.settings);
            pvpMenu.getMusic().setVisible(false);
            pvpMenu.getMainMenu().setVisible(false);
            pvpMenu.getExit().setVisible(false);
            bgforfield = "res/bg/bg5.jpg";
            gameField = new GamePanel(bgforfield, 5, 0, 1);
            gameField.getSettings().addActionListener(arg0 -> {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    gameField.getSettings().setIcon(AllImages.close);
                    gameField.getMusic().setVisible(true);
                    if (musicPlay)
                        gameField.getMusic().setIcon(AllImages.music);
                    else
                        gameField.getMusic().setIcon(AllImages.nomusic);
                    gameField.getMusic().addActionListener(e12 -> {
                        if (musicPlay) {
                            musicPlay = false;
                            music.getMusic().stop();
                            gameField.getMusic().setIcon(AllImages.nomusic);
                            refresh();
                        } else {
                            musicPlay = true;
                            music.getMusic().start();
                            music.getMusic().loop(10);
                            gameField.getMusic().setIcon(AllImages.music);
                            refresh();
                        }
                    });
                    gameField.getMainMenu().setVisible(true);
                    gameField.getMainMenu().addActionListener(arg016 -> {
                        mainMenu.setVisible(true);
                        gameField.setVisible(false);
                        refresh();
                    });
                    gameField.getExit().setVisible(true);
                    gameField.getExit().addActionListener(arg017 -> exit());
                    refresh();
                } else {
                    settIsClicked = 0;
                    gameField.getSettings().setIcon(AllImages.settings);
                    gameField.getMusic().setVisible(false);
                    gameField.getMainMenu().setVisible(false);
                    gameField.getExit().setVisible(false);
                    refresh();
                }
            });
            add(gameField);
            gameField.setVisible(true);
            pvpMenu.setVisible(false);
            mainMenu.setVisible(false);
            pvpgame = new PvPGameProcess(5);
            refresh();
        });

        pvpMenu.getSevenButton().addActionListener(e -> {
            settIsClicked = 0;
            pvpMenu.getSettings().setIcon(AllImages.settings);
            pvpMenu.getMusic().setVisible(false);
            pvpMenu.getMainMenu().setVisible(false);
            pvpMenu.getExit().setVisible(false);
            bgforfield = "res/bg/bg7.jpg";
            gameField = new GamePanel(bgforfield, 7, 0, 1);
            gameField.getSettings().addActionListener(arg0 -> {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    gameField.getSettings().setIcon(AllImages.close);
                    gameField.getMusic().setVisible(true);
                    if (musicPlay)
                        gameField.getMusic().setIcon(AllImages.music);
                    else
                        gameField.getMusic().setIcon(AllImages.nomusic);
                    gameField.getMusic().addActionListener(e13 -> {
                        if (musicPlay) {
                            musicPlay = false;
                            music.getMusic().stop();
                            gameField.getMusic().setIcon(AllImages.nomusic);
                            refresh();
                        } else {
                            musicPlay = true;
                            music.getMusic().start();
                            music.getMusic().loop(10);
                            gameField.getMusic().setIcon(AllImages.music);
                            refresh();
                        }
                    });
                    gameField.getMainMenu().setVisible(true);
                    gameField.getMainMenu().addActionListener(arg018 -> {
                        mainMenu.setVisible(true);
                        gameField.setVisible(false);
                        refresh();
                    });
                    gameField.getExit().setVisible(true);
                    gameField.getExit().addActionListener(arg019 -> exit());
                    refresh();
                } else {
                    settIsClicked = 0;
                    gameField.getSettings().setIcon(AllImages.settings);
                    gameField.getMusic().setVisible(false);
                    gameField.getMainMenu().setVisible(false);
                    gameField.getExit().setVisible(false);
                    refresh();
                }
            });
            add(gameField);
            gameField.setVisible(true);
            pvpMenu.setVisible(false);
            mainMenu.setVisible(false);
            pvpgame = new PvPGameProcess(7);
            refresh();
        });

        mainMenu.getPvMButton().addActionListener(e -> {
            settIsClicked = 0;
            mainMenu.getSettings().setIcon(AllImages.settings);
            mainMenu.getMusic().setVisible(false);
            mainMenu.getExit().setVisible(false);
            add(pvmMenu);
            pvmMenu.setVisible(true);
            mainMenu.setVisible(false);
            refresh();
        });

        pvmMenu.getSettings().addActionListener(arg0 -> {
            if (settIsClicked == 0) {
                settIsClicked = 1;
                pvmMenu.getSettings().setIcon(AllImages.close);
                pvmMenu.getMusic().setVisible(true);
                if (musicPlay)
                    pvmMenu.getMusic().setIcon(AllImages.music);
                else
                    pvmMenu.getMusic().setIcon(AllImages.nomusic);
                pvmMenu.getMusic().addActionListener(e -> {
                    if (musicPlay) {
                        musicPlay = false;
                        music.getMusic().stop();
                        pvmMenu.getMusic().setIcon(AllImages.nomusic);
                        refresh();
                    } else {
                        musicPlay = true;
                        music.getMusic().start();
                        music.getMusic().loop(10);
                        pvmMenu.getMusic().setIcon(AllImages.music);
                        refresh();
                    }
                });
                pvmMenu.getMainMenu().setVisible(true);
                pvmMenu.getMainMenu().addActionListener(arg0110 -> {
                    settIsClicked = 0;
                    pvmMenu.getSettings().setIcon(AllImages.settings);
                    pvmMenu.getMusic().setVisible(false);
                    pvmMenu.getMainMenu().setVisible(false);
                    pvmMenu.getExit().setVisible(false);
                    mainMenu.setVisible(true);
                    pvmMenu.setVisible(false);
                    refresh();
                });
                pvmMenu.getExit().setVisible(true);
                pvmMenu.getExit().addActionListener(arg0111 -> exit());
                refresh();
            } else {
                settIsClicked = 0;
                pvmMenu.getSettings().setIcon(AllImages.settings);
                pvmMenu.getMusic().setVisible(false);
                pvmMenu.getMainMenu().setVisible(false);
                pvmMenu.getExit().setVisible(false);
                refresh();
            }
        });

        pvmMenu.getPlayPvMButton().addActionListener(e -> {
            settIsClicked = 0;
            pvmMenu.getSettings().setIcon(AllImages.settings);
            pvmMenu.getMusic().setVisible(false);
            pvmMenu.getMainMenu().setVisible(false);
            pvmMenu.getExit().setVisible(false);
            if (pvmMenu.getThree().isSelected()) {
                fieldSize = 3;
                bgforfield = "res/bg/bg3.jpg";
            } else if (pvmMenu.getFive().isSelected()) {
                fieldSize = 5;
                bgforfield = "res/bg/bg5.jpg";
            } else {
                fieldSize = 7;
                bgforfield = "res/bg/bg7.jpg";
            }
            if (pvmMenu.getEasy().isSelected())
                difficulty = 1;
            else if (pvmMenu.getMedium().isSelected())
                difficulty = 2;
            else if (pvmMenu.getHard().isSelected())
                difficulty = 3;
            else
                difficulty = 4;
            gameField = new GamePanel(bgforfield, fieldSize, difficulty, 2);
            gameField.getSettings().addActionListener(arg0 -> {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    gameField.getSettings().setIcon(AllImages.close);
                    gameField.getMusic().setVisible(true);
                    if (musicPlay)
                        gameField.getMusic().setIcon(AllImages.music);
                    else
                        gameField.getMusic().setIcon(AllImages.nomusic);
                    gameField.getMusic().addActionListener(e14 -> {
                        if (musicPlay) {
                            musicPlay = false;
                            music.getMusic().stop();
                            gameField.getMusic().setIcon(AllImages.nomusic);
                            refresh();
                        } else {
                            musicPlay = true;
                            music.getMusic().start();
                            music.getMusic().loop(10);
                            gameField.getMusic().setIcon(AllImages.music);
                            refresh();
                        }
                    });
                    gameField.getMainMenu().setVisible(true);
                    gameField.getMainMenu().addActionListener(arg0112 -> {
                        gameField.setVisible(false);
                        mainMenu.setVisible(true);
                        refresh();
                    });
                    gameField.getExit().setVisible(true);
                    gameField.getExit().addActionListener(arg0113 -> exit());
                    refresh();
                } else {
                    settIsClicked = 0;
                    gameField.getSettings().setIcon(AllImages.settings);
                    gameField.getMusic().setVisible(false);
                    gameField.getMainMenu().setVisible(false);
                    gameField.getExit().setVisible(false);
                    refresh();
                }
            });
            pvmgame = new PvMGameProcess(fieldSize, difficulty);
            PvMGameProcess.refresh();
            gameField.setVisible(true);
            pvmMenu.setVisible(false);
            add(gameField);

        });
    }

    private void exit() {
        music.getMusic().stop();
        dispose();
        refresh();
    }

    public void refresh() {
        validate();
        repaint();
    }

}
