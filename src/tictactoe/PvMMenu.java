package tictactoe;

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
    private JButton playPvM;
    private JButton settings;

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
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(-165, 90, 70, -150);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        ButtonGroup selectSize = new ButtonGroup();

        three = new JRadioButton();
        three.setBackground(new Color(74, 112, 121));
        three.setSelected(true);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(20, -70, 40, 30);
        c.anchor = GridBagConstraints.WEST;
        add(three, c);
        selectSize.add(three);

        five = new JRadioButton();
        five.setBackground(new Color(73, 90, 97));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, -70, 40, 30);
        c.anchor = GridBagConstraints.WEST;
        add(five, c);
        selectSize.add(five);

        seven = new JRadioButton();
        seven.setBackground(new Color(74, 74, 74));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, -70, 40, 30);
        c.anchor = GridBagConstraints.WEST;
        add(seven, c);
        selectSize.add(seven);

        ButtonGroup selectDifficulty = new ButtonGroup();

        easy = new JRadioButton();
        easy.setBackground(new Color(75, 97, 111));
        easy.setSelected(true);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(20, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(easy, c);
        selectDifficulty.add(easy);

        medium = new JRadioButton();
        medium.setBackground(new Color(75, 97, 111));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(0, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(medium, c);
        selectDifficulty.add(medium);

        hard = new JRadioButton();
        hard.setBackground(new Color(74, 74, 74));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(0, 150, 40, 0);
        c.anchor = GridBagConstraints.WEST;
        add(hard, c);
        selectDifficulty.add(hard);

        playPvM = new JButton();
        playPvM.setIcon(AllImages.play);
        playPvM.setPreferredSize(new Dimension(playPvM.getIcon().getIconWidth(), playPvM.getIcon().getIconHeight()));
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(50, 0, -120, 0);
        c.anchor = GridBagConstraints.CENTER;
        add(playPvM, c);
    }

    public JButton getPlayPvMButton() {
        return playPvM;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
    }
}
