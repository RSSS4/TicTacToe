package tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class PvMMenu extends JPanel {

    private Image bgimg;
    public JRadioButton three;
    public JRadioButton five;
    public JRadioButton seven;
    public JRadioButton easy;
    public JRadioButton medium;
    public JRadioButton hard;
    public JRadioButton ultra;
    private JButton playPvM;
    private JButton settings;
    private JButton music;
    private JButton mainM;
    private JButton exit;

    public PvMMenu(String bgimg) {
        this(new ImageIcon(bgimg).getImage());
    }

    public PvMMenu(Image bgimg) {
        this.bgimg = bgimg;

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        settings = new JButton();
        settings.setIcon(AllImages.settings);
        settings.setPreferredSize(new Dimension(settings.getIcon().getIconWidth(), settings.getIcon().getIconHeight()));
        settings.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(-150, 90, 0, -155);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        music = new JButton();
        music.setIcon(AllImages.music);
        music.setPreferredSize(new Dimension(music.getIcon().getIconWidth(), music.getIcon().getIconHeight()));
        music.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(-90, 90, 0, -155);
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
        c.insets = new Insets(-30, 90, 0, -155);
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
        c.insets = new Insets(30, 90, -5, -155);
        c.anchor = GridBagConstraints.NORTHEAST;
        exit.setVisible(false);
        add(exit, c);

        ButtonGroup selectSize = new ButtonGroup();

        three = new JRadioButton();
        three.setBackground(new Color(50, 63, 69));
        three.setSelected(true);
        three.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(40, -70, 40, 30);
        c.anchor = GridBagConstraints.WEST;
        add(three, c);
        selectSize.add(three);

        five = new JRadioButton();
        five.setBackground(new Color(73, 90, 97));
        five.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5, -70, 40, 30);
        c.anchor = GridBagConstraints.WEST;
        add(five, c);
        selectSize.add(five);

        seven = new JRadioButton();
        seven.setBackground(new Color(92, 97, 91));
        seven.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5, -70, 40, 30);
        c.anchor = GridBagConstraints.WEST;
        add(seven, c);
        selectSize.add(seven);

        ButtonGroup selectDifficulty = new ButtonGroup();

        easy = new JRadioButton();
        easy.setBackground(new Color(117, 111, 99));
        easy.setSelected(true);
        easy.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(40, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(easy, c);
        selectDifficulty.add(easy);

        medium = new JRadioButton();
        medium.setBackground(new Color(119, 115, 103));
        medium.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(5, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(medium, c);
        selectDifficulty.add(medium);

        hard = new JRadioButton();
        hard.setBackground(new Color(106, 108, 103));
        hard.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(5, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(hard, c);
        selectDifficulty.add(hard);

        ultra = new JRadioButton();
        ultra.setBackground(new Color(106, 103, 98));
        ultra.setBorder(null);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 5;
        c.insets = new Insets(5, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(ultra, c);
        selectDifficulty.add(ultra);

        playPvM = new JButton();
        playPvM.setIcon(AllImages.play);
        playPvM.setPreferredSize(new Dimension(playPvM.getIcon().getIconWidth(), playPvM.getIcon().getIconHeight()));
        playPvM.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(50, 0, -120, 0);
        c.anchor = GridBagConstraints.CENTER;
        add(playPvM, c);
    }

    public JButton getPlayPvMButton() {
        return playPvM;
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

    public JButton getExit() {
        return exit;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
    }
}
