package model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import view.ChangeColor;
import view.GameField;
import view.Result;
import view.ResultFrame;

import static org.junit.Assert.*;

public class PvMGameProcessTest {

    private PvMGameProcess pvmGameProcess;

    @Before
    public void initialize() {
        pvmGameProcess = new PvMGameProcess(3,1);
    }

    @Ignore
    public void returnTrueWhenMakeMoveForBotLvl() {
        EasyBot easyBot = new EasyBot(1);
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }
        boolean checkMove = false;
        boolean isBreak = false;
        PvMGameProcess.refreshData(buttons);
        easyBot.setFieldSize(3);
        easyBot.refreshData(buttons);
        PvMGameProcess.setEasyBot(easyBot);
        pvmGameProcess.lvl();

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
               if(buttons[i][j].getWho() > 0){
                   checkMove = true;
                   isBreak = true;
                   break;
               }
            }
            if(isBreak)
                break;
        }
    assertEquals(true,checkMove);
    }

    @Ignore
    public void checkThatIsWinnerCreatesRightImageLose() {
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setTest(1, false);
            }
        }
        PvMGameProcess.refreshData(buttons);
        String expected = "res/result/lose.png";

        PvMGameProcess.isWinner(0,0);
        ResultFrame result = PvMGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Ignore
    public void checkThatIsWinnerCreatesRightImageWin() {
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setTest(2, false);
            }
        }
        PvMGameProcess.refreshData(buttons);
        String expected = "res/result/win.png";

        PvMGameProcess.isWinner(0,0);
        ResultFrame result = PvMGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }
    @Ignore
    public void checkThatIsWinnerCreatesRightImageDraw() {
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setTest(3, false);            //3 is not of any type, but works to check draw
            }
        }
        PvMGameProcess.refreshData(buttons);
        String expected = "res/result/draw.png";

        PvMGameProcess.isWinner(0,0);
        ResultFrame result = PvMGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Test
    public void checkThatEndGameMakesAllButtonsInactive() {
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }
        buttons[1][1].setTest(0,false);
        pvmGameProcess.refreshData(buttons);
        pvmGameProcess.endGame();
        buttons = pvmGameProcess.getButtons();
        assertEquals(false,buttons[0][0].isFree());
    }

    @Test
    public void refresh() {
    }

    @Test
    public void isEndGame() {
    }

    @Test
    public void getTurn() {
    }

    @Test
    public void setTurn() {
    }

    @Test
    public void setComp() {
    }

    @Test
    public void refreshData() {
    }

    @Test
    public void setEndGame() {
    }
}