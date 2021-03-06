package view;

import javax.swing.*;
import java.awt.*;


public class Result extends JPanel{
    private transient Image bgimg;
    private JButton ok;
    private String nameImg;

    public Result(String bgimg) {
        this(new ImageIcon(bgimg).getImage());
        nameImg = bgimg;

    }

    public Result(Image bgimg) {
        this.bgimg = bgimg;
        setVisible(true);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        ok = new JButton();
        ok.setIcon(AllImages.ok);
        ok.setPreferredSize(new Dimension(ok.getIcon().getIconWidth(), ok.getIcon().getIconHeight()));
        c.fill = GridBagConstraints.SOUTH;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(200, 0, 0, 0);
        c.anchor = GridBagConstraints.SOUTH;
        add(ok, c);
    }

    public JButton getOk() {
        return ok;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
    }
    public String getNameImg(){return nameImg;}
}

