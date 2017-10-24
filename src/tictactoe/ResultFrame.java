package tictactoe;

import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    private int result;
    private Result resultPanel;

    private String pvmWin = "pvmWin.png";
    private String pvmLose = "pvmLose.png";
    private String firstWin = "firstWin.png";
    private String secondWin = "secondWin.png";
    private String draw = "draw.png";

    public ResultFrame(int result) {
        this.result = result;
        pack();
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        switch (result) {
            case 1:
                resultPanel = new Result(firstWin);
                add(resultPanel);
                break;
            case 2:
                resultPanel = new Result(secondWin);
                add(resultPanel);
                break;
            case 3:
                resultPanel = new Result(pvmLose);
                add(resultPanel);
                break;
            case 4:
                resultPanel = new Result(pvmWin);
                add(resultPanel);
                break;
            default:
                resultPanel = new Result(draw);
                add(resultPanel);
        }
    }
}
