package tictactoe;

import javax.swing.*;
import java.awt.*;

public class PvPMenu extends JPanel {

    private Image bgimg;
    private JButton three;
    private JButton five;
    private JButton seven;
    private JButton settings;

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
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(-165, 90, 0, -115);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        three = new JButton();
        three.setIcon(AllImages.three);
        three.setPreferredSize(new Dimension(three.getIcon().getIconWidth(), three.getIcon().getIconHeight()));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 30, 20, 0);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(three, c);

        five = new JButton();
        five.setIcon(AllImages.five);
        five.setPreferredSize(new Dimension(five.getIcon().getIconWidth(), five.getIcon().getIconHeight()));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0, 30, 20, 0);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(five, c);

        seven = new JButton();
        seven.setIcon(AllImages.seven);
        seven.setPreferredSize(new Dimension(seven.getIcon().getIconWidth(), seven.getIcon().getIconHeight()));
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
