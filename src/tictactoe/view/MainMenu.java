package tictactoe.view;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JPanel {

    private Image bgimg;
    private JButton pvm;
    private JButton pvp;
    private JButton settings;
    private JButton music;
    private JButton exit;

    public MainMenu(String bgimg) {
        this(new ImageIcon(bgimg).getImage());
    }

    public MainMenu(Image bgimg) {
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
        c.insets = new Insets(-190, 0, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        music = new JButton();
        music.setIcon(AllImages.music);
        music.setPreferredSize(new Dimension(music.getIcon().getIconWidth(), music.getIcon().getIconHeight()));
        music.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(-130, 0, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        music.setVisible(false);
        add(music, c);

        exit = new JButton();
        exit.setIcon(AllImages.exit);
        exit.setPreferredSize(new Dimension(exit.getIcon().getIconWidth(), exit.getIcon().getIconHeight()));
        exit.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(-70, 0, 0, -130);
        c.anchor = GridBagConstraints.NORTHEAST;
        exit.setVisible(false);
        add(exit, c);

        pvp = new JButton();
        pvp.setIcon(AllImages.pvp);
        pvp.setPreferredSize(new Dimension(pvp.getIcon().getIconWidth(), pvp.getIcon().getIconHeight()));
        pvp.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 40, 100, 10);
        c.anchor = GridBagConstraints.PAGE_START;
        add(pvp, c);

        pvm = new JButton();
        pvm.setIcon(AllImages.pvm);
        pvm.setPreferredSize(new Dimension(pvm.getIcon().getIconWidth(), pvm.getIcon().getIconHeight()));
        pvm.setBorderPainted(false);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(120, 40, 0, 10);
        c.anchor = GridBagConstraints.PAGE_END;
        add(pvm, c);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
    }

    public JButton getSettings() {
        return settings;
    }

    public JButton getPvPButton() {
        return pvp;
    }

    public JButton getPvMButton() {
        return pvm;
    }

    public JButton getMusic() {
        return music;
    }

    public JButton getExit() {
        return exit;
    }

}
