package tictactoe.view;

import tictactoe.model.ResultVariable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrame extends JFrame {

    private ResultVariable.ResultVar result;
    private Result resultPanel;

    private String pvmWin = "res/result/win.png";
    private String pvmLose = "res/result/lose.png";
    private String firstWin = "res/result/firstWin.png";
    private String secondWin = "res/result/secondWin.png";
    private String draw = "res/result/draw.png";

    public ResultFrame(ResultVariable.ResultVar result) {

        setUndecorated(true);
        this.result = result;
        pack();
        setSize(450, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        switch (result) {
            case FIRSTWIN:
                resultPanel = new Result(firstWin);
                add(resultPanel);
                break;
            case SECONDWIN:
                resultPanel = new Result(secondWin);
                add(resultPanel);
                break;
            case WIN:
                resultPanel = new Result(pvmLose);
                add(resultPanel);
                break;
            case LOSE:
                resultPanel = new Result(pvmWin);
                add(resultPanel);
                break;
            default:
                resultPanel = new Result(draw);
                add(resultPanel);
        }

        resultPanel.GetOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });

    }
}
