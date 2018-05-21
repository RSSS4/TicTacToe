package model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import view.ChangeColor;
import view.GameField;
import view.ResultFrame;

import static org.junit.Assert.*;

public class PvPGameProcessTest {

    @Before
    public void initialize() {
        PvPGameProcess pvPGameProcess = new PvPGameProcess(5);
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
    public  void CheckThatIsWinnerSetRightObj(){
        Buttons buttons[][] = new Buttons[5][5];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setWho(2);
            }
        }
        PvPGameProcess.refreshData(buttons);
        ResultFrame expectedResult = new ResultFrame(ResultVariable.ResultVar.DRAW);
        PvPGameProcess.isWinner(1,1);
        assertEquals(expectedResult,PvPGameProcess.getResult());
    }
    @Test
    public void CheckThatEndGameSetAllUnfilledButtonsOnFalse(){
        Buttons buttons[][] = new Buttons[5][5];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Buttons(1);
            }
            buttons[i][0].setTest(1,false);
        }
        PvPGameProcess.refreshData(buttons);
        PvPGameProcess.endGame();
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 5 ; j++) {
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