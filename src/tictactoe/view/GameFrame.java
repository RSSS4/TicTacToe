package tictactoe.view;

import tictactoe.model.PvMGameProcess;
import tictactoe.model.PvPGameProcess;

import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame {

    private String bgimg = "res/bg/bg.jpg";
    private String bgforfield;
    private String bgforpvp = "res/bg/bgforpvp.jpg";
    private String bgforpvm = "res/bg/bgforpvm.jpg";

    private int fieldSize;
    private int difficulty;
    private int settIsClicked = 0;
    private static boolean musicPlay = true;

    private MainMenu mainMenu;
    private PvPMenu pvpMenu;
    private PvMMenu pvmMenu;
    private GamePanel gameField;
    private Music music;

    private PvPGameProcess pvpgame;
    private PvMGameProcess pvmgame;

    private XOButton buttons[][];

    public GameFrame() {
        setUndecorated(true);

        mainMenu = new MainMenu(bgimg);
        pvpMenu = new PvPMenu(bgforpvp);
        pvmMenu = new PvMMenu(bgforpvm);
        music = new Music();

        add(mainMenu);

        music.PlayMusic();

        pack();
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        mainMenu.setVisible(true);
        pvpMenu.setVisible(false);
        Refresh();


        mainMenu.GetSettings().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    mainMenu.GetSettings().setIcon(AllImages.close);
                    mainMenu.GetMusic().setVisible(true);
                    if (musicPlay == true)
                        mainMenu.GetMusic().setIcon(AllImages.music);
                    else
                        mainMenu.GetMusic().setIcon(AllImages.nomusic);
                    mainMenu.GetMusic().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (musicPlay == true) {
                                musicPlay = false;
                                music.GetMusic().stop();
                                mainMenu.GetMusic().setIcon(AllImages.nomusic);
                                Refresh();
                            } else {
                                musicPlay = true;
                                music.GetMusic().start();
                                music.GetMusic().loop(10);
                                mainMenu.GetMusic().setIcon(AllImages.music);
                                Refresh();
                            }
                        }
                    });
                    mainMenu.GetExit().setVisible(true);
                    mainMenu.GetExit().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            exit();
                        }
                    });
                    Refresh();
                } else {
                    settIsClicked = 0;
                    mainMenu.GetSettings().setIcon(AllImages.settings);
                    mainMenu.GetMusic().setVisible(false);
                    mainMenu.GetExit().setVisible(false);
                    Refresh();
                }
            }
        });

        mainMenu.GetPvPButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                settIsClicked = 0;
                mainMenu.GetSettings().setIcon(AllImages.settings);
                mainMenu.GetMusic().setVisible(false);
                mainMenu.GetExit().setVisible(false);
                add(pvpMenu);
                pvpMenu.setVisible(true);
                mainMenu.setVisible(false);
                Refresh();
            }
        });

        pvpMenu.GetSettings().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    pvpMenu.GetSettings().setIcon(AllImages.close);
                    pvpMenu.GetMusic().setVisible(true);
                    if (musicPlay == true)
                        pvpMenu.GetMusic().setIcon(AllImages.music);
                    else
                        pvpMenu.GetMusic().setIcon(AllImages.nomusic);
                    pvpMenu.GetMusic().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (musicPlay == true) {
                                musicPlay = false;
                                music.GetMusic().stop();
                                pvpMenu.GetMusic().setIcon(AllImages.nomusic);
                                Refresh();
                            } else {
                                musicPlay = true;
                                music.GetMusic().start();
                                music.GetMusic().loop(10);
                                pvpMenu.GetMusic().setIcon(AllImages.music);
                                Refresh();
                            }
                        }
                    });
                    pvpMenu.GetMainMenu().setVisible(true);
                    pvpMenu.GetMainMenu().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            settIsClicked = 0;
                            pvpMenu.GetSettings().setIcon(AllImages.settings);
                            pvpMenu.GetMusic().setVisible(false);
                            pvpMenu.GetMainMenu().setVisible(false);
                            pvpMenu.GetExit().setVisible(false);
                            mainMenu.setVisible(true);
                            pvpMenu.setVisible(false);
                            Refresh();
                        }
                    });
                    pvpMenu.GetExit().setVisible(true);
                    pvpMenu.GetExit().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            exit();
                        }
                    });
                    Refresh();
                } else {
                    settIsClicked = 0;
                    pvpMenu.GetSettings().setIcon(AllImages.settings);
                    pvpMenu.GetMusic().setVisible(false);
                    pvpMenu.GetMainMenu().setVisible(false);
                    pvpMenu.GetExit().setVisible(false);
                    Refresh();
                }
            }
        });

        pvpMenu.GetThreeButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvpMenu.GetSettings().setIcon(AllImages.settings);
                pvpMenu.GetMusic().setVisible(false);
                pvpMenu.GetMainMenu().setVisible(false);
                pvpMenu.GetExit().setVisible(false);
                bgforfield = "res/bg/bg3.jpg";
                gameField = new GamePanel(bgforfield, 3, 0, 1);
                gameField.GetSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if (settIsClicked == 0) {
                            settIsClicked = 1;
                            gameField.GetSettings().setIcon(AllImages.close);
                            gameField.GetMusic().setVisible(true);
                            if (musicPlay == true)
                                gameField.GetMusic().setIcon(AllImages.music);
                            else
                                gameField.GetMusic().setIcon(AllImages.nomusic);
                            gameField.GetMusic().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (musicPlay == true) {
                                        musicPlay = false;
                                        music.GetMusic().stop();
                                        gameField.GetMusic().setIcon(AllImages.nomusic);
                                        Refresh();
                                    } else {
                                        musicPlay = true;
                                        music.GetMusic().start();
                                        music.GetMusic().loop(10);
                                        gameField.GetMusic().setIcon(AllImages.music);
                                        Refresh();
                                    }
                                }
                            });
                            gameField.GetMainMenu().setVisible(true);
                            gameField.GetMainMenu().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    mainMenu.setVisible(true);
                                    gameField.setVisible(false);
                                    Refresh();
                                }
                            });
                            gameField.GetMainMenu().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    mainMenu.setVisible(true);
                                    gameField.setVisible(false);
                                    Refresh();
                                }
                            });
                            gameField.GetExit().setVisible(true);
                            gameField.GetExit().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    exit();
                                }
                            });
                            Refresh();
                        } else {
                            settIsClicked = 0;
                            gameField.GetSettings().setIcon(AllImages.settings);
                            gameField.GetMusic().setVisible(false);
                            gameField.GetMainMenu().setVisible(false);
                            gameField.GetExit().setVisible(false);
                            Refresh();
                        }
                    }
                });
                add(gameField);
                gameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(3);
                Refresh();
            }
        });

        pvpMenu.GetFiveButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvpMenu.GetSettings().setIcon(AllImages.settings);
                pvpMenu.GetMusic().setVisible(false);
                pvpMenu.GetMainMenu().setVisible(false);
                pvpMenu.GetExit().setVisible(false);
                bgforfield = "res/bg/bg5.jpg";
                gameField = new GamePanel(bgforfield, 5, 0, 1);
                gameField.GetSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if (settIsClicked == 0) {
                            settIsClicked = 1;
                            gameField.GetSettings().setIcon(AllImages.close);
                            gameField.GetMusic().setVisible(true);
                            if (musicPlay == true)
                                gameField.GetMusic().setIcon(AllImages.music);
                            else
                                gameField.GetMusic().setIcon(AllImages.nomusic);
                            gameField.GetMusic().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (musicPlay == true) {
                                        musicPlay = false;
                                        music.GetMusic().stop();
                                        gameField.GetMusic().setIcon(AllImages.nomusic);
                                        Refresh();
                                    } else {
                                        musicPlay = true;
                                        music.GetMusic().start();
                                        music.GetMusic().loop(10);
                                        gameField.GetMusic().setIcon(AllImages.music);
                                        Refresh();
                                    }
                                }
                            });
                            gameField.GetMainMenu().setVisible(true);
                            gameField.GetMainMenu().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    mainMenu.setVisible(true);
                                    gameField.setVisible(false);
                                    Refresh();
                                }
                            });
                            gameField.GetExit().setVisible(true);
                            gameField.GetExit().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    exit();
                                }
                            });
                            Refresh();
                        } else {
                            settIsClicked = 0;
                            gameField.GetSettings().setIcon(AllImages.settings);
                            gameField.GetMusic().setVisible(false);
                            gameField.GetMainMenu().setVisible(false);
                            gameField.GetExit().setVisible(false);
                            Refresh();
                        }
                    }
                });
                add(gameField);
                gameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(5);
                Refresh();
            }
        });

        pvpMenu.GetSevenButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvpMenu.GetSettings().setIcon(AllImages.settings);
                pvpMenu.GetMusic().setVisible(false);
                pvpMenu.GetMainMenu().setVisible(false);
                pvpMenu.GetExit().setVisible(false);
                bgforfield = "res/bg/bg7.jpg";
                gameField = new GamePanel(bgforfield, 7, 0, 1);
                gameField.GetSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if (settIsClicked == 0) {
                            settIsClicked = 1;
                            gameField.GetSettings().setIcon(AllImages.close);
                            gameField.GetMusic().setVisible(true);
                            if (musicPlay == true)
                                gameField.GetMusic().setIcon(AllImages.music);
                            else
                                gameField.GetMusic().setIcon(AllImages.nomusic);
                            gameField.GetMusic().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (musicPlay == true) {
                                        musicPlay = false;
                                        music.GetMusic().stop();
                                        gameField.GetMusic().setIcon(AllImages.nomusic);
                                        Refresh();
                                    } else {
                                        musicPlay = true;
                                        music.GetMusic().start();
                                        music.GetMusic().loop(10);
                                        gameField.GetMusic().setIcon(AllImages.music);
                                        Refresh();
                                    }
                                }
                            });
                            gameField.GetMainMenu().setVisible(true);
                            gameField.GetMainMenu().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    mainMenu.setVisible(true);
                                    gameField.setVisible(false);
                                    Refresh();
                                }
                            });
                            gameField.GetExit().setVisible(true);
                            gameField.GetExit().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    exit();
                                }
                            });
                            Refresh();
                        } else {
                            settIsClicked = 0;
                            gameField.GetSettings().setIcon(AllImages.settings);
                            gameField.GetMusic().setVisible(false);
                            gameField.GetMainMenu().setVisible(false);
                            gameField.GetExit().setVisible(false);
                            Refresh();
                        }
                    }
                });
                add(gameField);
                gameField.setVisible(true);
                pvpMenu.setVisible(false);
                mainMenu.setVisible(false);
                pvpgame = new PvPGameProcess(7);
                Refresh();
            }
        });

        mainMenu.GetPvMButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                mainMenu.GetSettings().setIcon(AllImages.settings);
                mainMenu.GetMusic().setVisible(false);
                mainMenu.GetExit().setVisible(false);
                add(pvmMenu);
                pvmMenu.setVisible(true);
                mainMenu.setVisible(false);
                Refresh();
            }
        });

        pvmMenu.GetSettings().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (settIsClicked == 0) {
                    settIsClicked = 1;
                    pvmMenu.GetSettings().setIcon(AllImages.close);
                    pvmMenu.GetMusic().setVisible(true);
                    if (musicPlay == true)
                        pvmMenu.GetMusic().setIcon(AllImages.music);
                    else
                        pvmMenu.GetMusic().setIcon(AllImages.nomusic);
                    pvmMenu.GetMusic().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (musicPlay == true) {
                                musicPlay = false;
                                music.GetMusic().stop();
                                pvmMenu.GetMusic().setIcon(AllImages.nomusic);
                                Refresh();
                            } else {
                                musicPlay = true;
                                music.GetMusic().start();
                                music.GetMusic().loop(10);
                                pvmMenu.GetMusic().setIcon(AllImages.music);
                                Refresh();
                            }
                        }
                    });
                    pvmMenu.GetMainMenu().setVisible(true);
                    pvmMenu.GetMainMenu().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            settIsClicked = 0;
                            pvmMenu.GetSettings().setIcon(AllImages.settings);
                            pvmMenu.GetMusic().setVisible(false);
                            pvmMenu.GetMainMenu().setVisible(false);
                            pvmMenu.GetExit().setVisible(false);
                            mainMenu.setVisible(true);
                            pvmMenu.setVisible(false);
                            Refresh();
                        }
                    });
                    pvmMenu.GetExit().setVisible(true);
                    pvmMenu.GetExit().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            exit();
                        }
                    });
                    Refresh();
                } else {
                    settIsClicked = 0;
                    pvmMenu.GetSettings().setIcon(AllImages.settings);
                    pvmMenu.GetMusic().setVisible(false);
                    pvmMenu.GetMainMenu().setVisible(false);
                    pvmMenu.GetExit().setVisible(false);
                    Refresh();
                }
            }
        });

        pvmMenu.GetPlayPvMButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settIsClicked = 0;
                pvmMenu.GetSettings().setIcon(AllImages.settings);
                pvmMenu.GetMusic().setVisible(false);
                pvmMenu.GetMainMenu().setVisible(false);
                pvmMenu.GetExit().setVisible(false);
                if (pvmMenu.three.isSelected()) {
                    fieldSize = 3;
                    bgforfield = "res/bg/bg3.jpg";
                } else if (pvmMenu.five.isSelected()) {
                    fieldSize = 5;
                    bgforfield = "res/bg/bg5.jpg";
                } else {
                    fieldSize = 7;
                    bgforfield = "res/bg/bg7.jpg";
                }
                if (pvmMenu.easy.isSelected())
                    difficulty = 1;
                else if (pvmMenu.medium.isSelected())
                    difficulty = 2;
                else
                    difficulty = 3;
                gameField = new GamePanel(bgforfield, fieldSize, difficulty, 2);
                gameField.GetSettings().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if (settIsClicked == 0) {
                            settIsClicked = 1;
                            gameField.GetSettings().setIcon(AllImages.close);
                            gameField.GetMusic().setVisible(true);
                            if (musicPlay == true)
                                gameField.GetMusic().setIcon(AllImages.music);
                            else
                                gameField.GetMusic().setIcon(AllImages.nomusic);
                            gameField.GetMusic().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (musicPlay == true) {
                                        musicPlay = false;
                                        music.GetMusic().stop();
                                        gameField.GetMusic().setIcon(AllImages.nomusic);
                                        Refresh();
                                    } else {
                                        musicPlay = true;
                                        music.GetMusic().start();
                                        music.GetMusic().loop(10);
                                        gameField.GetMusic().setIcon(AllImages.music);
                                        Refresh();
                                    }
                                }
                            });
                            gameField.GetMainMenu().setVisible(true);
                            gameField.GetMainMenu().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    gameField.setVisible(false);
                                    mainMenu.setVisible(true);
                                    Refresh();
                                }
                            });
                            gameField.GetExit().setVisible(true);
                            gameField.GetExit().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    exit();
                                }
                            });
                            Refresh();
                        } else {
                            settIsClicked = 0;
                            gameField.GetSettings().setIcon(AllImages.settings);
                            gameField.GetMusic().setVisible(false);
                            gameField.GetMainMenu().setVisible(false);
                            gameField.GetExit().setVisible(false);
                            Refresh();
                        }
                    }
                });
                pvmgame = new PvMGameProcess(fieldSize, difficulty);
                PvMGameProcess.Refresh();
                gameField.setVisible(true);
                pvmMenu.setVisible(false);
                add(gameField);

                Refresh();
            }
        });
    }

    private void exit() {
        music.GetMusic().stop();
        dispose();
        Refresh();
    }

    private void Refresh() {
        validate();
        repaint();
    }
}
