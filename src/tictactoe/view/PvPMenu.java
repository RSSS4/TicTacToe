package tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class PvPMenu extends JPanel {

    private Image bgimg;
    private JButton three;
    private JButton five;
    private JButton seven;
    private JButton settings;
    private JButton music;
    private JButton mainM;
    private JButton exit;

    public PvPMenu(String bgimg) {
        this(new ImageIcon(bgimg).getImage());
    }

    public PvPMenu(Image bgimg) {
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
        c.insets = new Insets(-190, 90, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        music = new JButton();
        music.setIcon(AllImages.music);
        music.setPreferredSize(new Dimension(music.getIcon().getIconWidth(), music.getIcon().getIconHeight()));
        music.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(-130, 90, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        music.setVisible(false);
        add(music, c);

        mainM = new JButton();
        mainM.setIcon(AllImages.mainM);
        mainM.setPreferredSize(new Dimension(mainM.getIcon().getIconWidth(), mainM.getIcon().getIconHeight()));
        mainM.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(-70, 90, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        mainM.setVisible(false);
        add(mainM, c);

        exit = new JButton();
        exit.setIcon(AllImages.exit);
        exit.setPreferredSize(new Dimension(exit.getIcon().getIconWidth(), exit.getIcon().getIconHeight()));
        exit.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(-10, 90, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        exit.setVisible(false);
        add(exit, c);

        three = new JButton();
        three.setIcon(AllImages.three);
        three.setPreferredSize(new Dimension(three.getIcon().getIconWidth(), three.getIcon().getIconHeight()));
        three.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 30, 20, 0);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(three, c);

        five = new JButton();
        five.setIcon(AllImages.five);
        five.setPreferredSize(new Dimension(five.getIcon().getIconWidth(), five.getIcon().getIconHeight()));
        five.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0, 30, 20, 0);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(five, c);

        seven = new JButton();
        seven.setIcon(AllImages.seven);
        seven.setPreferredSize(new Dimension(seven.getIcon().getIconWidth(), seven.getIcon().getIconHeight()));
        seven.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 30, -150, 0);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(seven, c);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
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

    public JButton getThreeButton() {
        return three;
    }

    public JButton getFiveButton() {
        return five;
    }

    public JButton getSevenButton() {
        return seven;
    }
}
