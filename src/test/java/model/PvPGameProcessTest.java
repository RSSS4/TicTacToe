package model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import view.ChangeColor;
import view.GameField;

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


    @Test
    public void refreshShouldChangeTurnOnTrue() {
        PvPGameProcess.setTurn(false);
        PvPGameProcess.refresh();
        assertEquals(true,PvPGameProcess.getTurn());
    }
}