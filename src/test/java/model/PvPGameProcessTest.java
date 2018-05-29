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

    @Before
    public void initialize() {
        PvPGameProcess pvPGameProcess = new PvPGameProcess(3);
    }

    @Test
    public void Return_1_WhenTurnIsFalse() {
        int expected = 1;
        int actual = PvPGameProcess.turn();
        assertEquals(expected,actual);
    }
    @Test
    public void Return_2_WhenTurnIsTrue() {
        PvPGameProcess.setTurn(false);
        int expected = 2;
        int actual = PvPGameProcess.turn();
        assertEquals(expected,actual);
    }
    @Ignore
    public  void CheckThatIsWinnerCreatesRightObjWithFirstWinImgName(){
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setWho(1);
            }
        }
        PvPGameProcess.refreshData(buttons);
        String expected = "res/result/firstWin.png";
        PvPGameProcess.isWinner(1,1);
        ResultFrame result = PvPGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Ignore
    public  void CheckThatIsWinnerCreatesRightObjWithSecondWinImgName(){
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setWho(2);
            }
        }
        PvPGameProcess.refreshData(buttons);
        String expected = "res/result/secondWin.png";
        PvPGameProcess.isWinner(1,1);
        ResultFrame result = PvPGameProcess.getResult();
        Result resultPanel = result.getResultPanel();
        String actual = resultPanel.getNameImg();
        assertEquals(expected,actual);
    }

    @Ignore
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
        PvPGameProcess.refreshData(buttons);
        String expected = "res/result/draw.png";
        PvPGameProcess.isWinner(1,1);
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
        PvPGameProcess.refreshData(buttons);
        PvPGameProcess.endGame();
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3 ; j++) {
                assertEquals(false,buttons[i][j].isFree());
            }
        }
    }
    @Test
    public void refreshShouldChangeTurnOnTrue() {
        PvPGameProcess.setTurn(false);
        PvPGameProcess.refresh();
        assertEquals(true,PvPGameProcess.getTurn());
    }
}