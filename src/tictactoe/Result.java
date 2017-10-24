package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Result extends JPanel {

    private Image bgimg;

    public Result(String bgimg) {
        this(new ImageIcon(bgimg).getImage());
    }

    public Result(Image bgimg) {
        this.bgimg = bgimg;

        setVisible(true);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
    }
}

