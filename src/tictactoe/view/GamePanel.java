package tictactoe.view;

import tictactoe.model.PvMGameProcess;
import tictactoe.model.PvPGameProcess;
import tictactoe.model.Buttons;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {

    private Image bgforfield;

    private GameField field;

    private JButton restart;
    private JButton settings;
    private JButton music;
    private JButton mainM;
    private JButton exit;

    private int fieldSize;
    private int difficulty;

    private static JTextArea playerLeftText = new JTextArea("Player #1");
    private JTextArea playerCenterText = new JTextArea("VS");
    private static JTextArea playerRightText = new JTextArea("Player #2");
    private static JTextArea playerText = new JTextArea("Player");
    private static JTextArea modtText = new JTextArea("Jarvis");

    private Font fontOfText = new Font("Verdana", Font.BOLD, 30);

    private GridBagConstraints c;

    public GamePanel(String bgforfield, int size, int difficulty, int whichGame) {
        this(new ImageIcon(bgforfield).getImage(), size, difficulty, whichGame);
    }

    public GamePanel(Image bgforfield, int size, int difficulty, int whichGame) {
        this.bgforfield = bgforfield;
        this.fieldSize = size;
        this.difficulty = difficulty;
        setPreferredSize(new Dimension(600, 600));

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        playerLeftText.setEditable(false);
        playerLeftText.setFont(fontOfText);
        playerLeftText.setForeground(new Color(255, 255, 255));
        playerLeftText.setBackground(new Color(127, 131, 135));

        playerCenterText.setEditable(false);
        playerCenterText.setFont(fontOfText);
        playerCenterText.setForeground(new Color(255, 255, 255));
        playerCenterText.setBackground(new Color(127, 131, 135));

        playerRightText.setEditable(false);
        playerRightText.setFont(fontOfText);
        playerRightText.setForeground(new Color(255, 255, 255));
        playerRightText.setBackground(new Color(127, 131, 135));

        playerText.setEditable(false);
        playerText.setFont(fontOfText);
        playerText.setBackground(new Color(127, 131, 135));

        modtText.setEditable(false);
        modtText.setFont(fontOfText);
        modtText.setForeground(new Color(255, 255, 255));
        modtText.setBackground(new Color(127, 131, 135));

        JPanel panelfortext = new JPanel();
        panelfortext.setBackground(new Color(127, 131, 135));
        if (difficulty == 0) {
            panelfortext.add(playerLeftText);
            panelfortext.add(playerCenterText);
            panelfortext.add(playerRightText);
        } else {
            panelfortext.add(playerText);
            panelfortext.add(playerCenterText);
            panelfortext.add(modtText);
        }
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(30, 0, 10, 0);
        c.anchor = GridBagConstraints.NORTH;
        add(panelfortext, c);

        settings = new JButton();
        settings.setIcon(AllImages.settings);
        settings.setPreferredSize(new Dimension(settings.getIcon().getIconWidth(), settings.getIcon().getIconHeight()));
        settings.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(10, 90, -10, 10);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        music = new JButton();
        music.setIcon(AllImages.music);
        music.setPreferredSize(new Dimension(music.getIcon().getIconWidth(), music.getIcon().getIconHeight()));
        music.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(-15, 90, 0, 10);
        c.anchor = GridBagConstraints.NORTHEAST;
        music.setVisible(false);
        add(music, c);

        mainM = new JButton();
        mainM.setIcon(AllImages.mainM);
        mainM.setPreferredSize(new Dimension(mainM.getIcon().getIconWidth(), mainM.getIcon().getIconHeight()));
        mainM.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(50, 90, 0, 10);
        c.anchor = GridBagConstraints.NORTHEAST;
        mainM.setVisible(false);
        add(mainM, c);

        exit = new JButton();
        exit.setIcon(AllImages.exit);
        exit.setPreferredSize(new Dimension(exit.getIcon().getIconWidth(), exit.getIcon().getIconHeight()));
        exit.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(115, 90, 0, 10);
        c.anchor = GridBagConstraints.NORTHEAST;
        exit.setVisible(false);
        add(exit, c);

        field = new GameField(size, whichGame);
        field.setSize(400, 400);
        field.setBackground(new Color(81, 99, 109));
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 7;
        c.gridheight = 7;
        c.weightx = 5.0;
        c.weighty = 5.0;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(60, 130, 130, 130);
        c.anchor = GridBagConstraints.CENTER;
        add(field, c);

        restart = new JButton();
        restart.setIcon(AllImages.restart);
        restart.setPreferredSize(new Dimension(restart.getIcon().getIconWidth(), restart.getIcon().getIconHeight()));
        restart.setBorderPainted(false);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buttons[][] buttons = field.getButtons();
                for (int i = 0; i < fieldSize; i++)
                    for (int j = 0; j < fieldSize; j++)
                        buttons[i][j].refresh();
                if (whichGame == 1)
                    PvPGameProcess.refresh();
                else PvMGameProcess.refresh();
            }
        });
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(-10, 0, 30, 0);
        c.anchor = GridBagConstraints.SOUTH;
        add(restart, c);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgforfield, 0, 0, null);
    }

    public JButton getSettings() {
        return settings;
    }

    public JButton getMusic() {
        return music;
    }

    public JButton getMainMenu() {
        return mainM;
    }

    public static JTextArea playerLeftText() {
        return playerLeftText;
    }

    public static JTextArea playerRightText() {
        return playerRightText;
    }

    public static JTextArea modText() {
        return modtText;
    }

    public static JTextArea playerText() {
        return playerText;
    }

    public JButton getExit() {
        return exit;
    }

}
