package model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import view.ChangeColor;
import view.GameField;
import view.Result;
import view.ResultFrame;

import static org.junit.Assert.*;

public class PvPGameProcessTest {
    private PvPGameProcess pvPGameProcess;
    @Before
    public void initialize() {
        pvPGameProcess = new PvPGameProcess(3);
    }

    @Test
    public void Return_1_WhenTurnIsFalse() {
        int expected = 1;
        int actual = pvPGameProcess.turn();
        assertEquals(expected,actual);
    }
    @Test
    public void Return_2_WhenTurnIsTrue() {
        pvPGameProcess.setTurn(false);
        int expected = 2;
        int actual = pvPGameProcess.turn();
        assertEquals(expected,actual);
    }
    @Test
    public  void CheckThatIsWinnerCreatesRightObjWithFirstWinImgName(){
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setWho(1);
            }
        }
        pvPGameProcess.refreshData(buttons);
        String expected = "res/result/firstWin.png";
        pvPGameProcess.isWinner(1,1);
        ResultFrame result = PvPGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Test
    public  void CheckThatIsWinnerCreatesRightObjWithSecondWinImgName(){
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setWho(2);
            }
        }
        pvPGameProcess.refreshData(buttons);
        String expected = "res/result/secondWin.png";
        pvPGameProcess.isWinner(1,1);
        ResultFrame result = PvPGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Test
    public  void CheckThatIsWinnerCreatesRightObjWithDrawImgName(){
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
            }
        }
        buttons[0][0].setWho(1);
        buttons[0][1].setWho(2);
        buttons[0][2].setWho(1);
        buttons[1][0].setWho(2);
        buttons[1][1].setWho(1);
        buttons[1][2].setWho(2);
        buttons[2][0].setWho(2);
        buttons[2][1].setWho(1);
        buttons[2][2].setWho(2);
        pvPGameProcess.refreshData(buttons);
        String expected = "res/result/draw.png";
        pvPGameProcess.isWinner(1,1);
        ResultFrame result = PvPGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Test
    public void CheckThatEndGameSetAllUnfilledButtonsOnFalse(){
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
            }
            buttons[i][0].setTest(1,false);
        }
        pvPGameProcess.refreshData(buttons);
        pvPGameProcess.endGame();
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3 ; j++) {
                assertEquals(false,buttons[i][j].isFree());
            }
        }
    }
    @Test
    public void refreshShouldChangeTurnOnTrue() {
        pvPGameProcess.setTurn(false);
        pvPGameProcess.refresh();
        assertEquals(true,PvPGameProcess.getTurn());
    }
}