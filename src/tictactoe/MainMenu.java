package tictactoe;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JPanel {

    private Image bgimg;
    private JButton pvm;
    private JButton pvp;
    private JButton settings;

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
        c.fill = GridBagConstraints.NONE;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(-180, 0, 0, -120);
        c.anchor = GridBagConstraints.NORTHEAST;
        add(settings, c);

        pvp = new JButton();
        pvp.setIcon(AllImages.pvp);
        pvp.setPreferredSize(new Dimension(pvp.getIcon().getIconWidth(), pvp.getIcon().getIconHeight()));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 40, 100, 10);
        c.anchor = GridBagConstraints.PAGE_START;
        add(pvp, c);

        pvm = new JButton();
        pvm.setIcon(AllImages.pvm);
        pvm.setPreferredSize(new Dimension(pvm.getIcon().getIconWidth(), pvm.getIcon().getIconHeight()));
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(100, 40, 0, 10);
        c.anchor = GridBagConstraints.PAGE_END;
        add(pvm, c);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
    }

    public JButton getPvPButton() {
        return pvp;
    }

    public JButton getPvMButton() {
        return pvm;
    }

}
