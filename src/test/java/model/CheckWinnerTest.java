package model;

//import org.junit.jupiter.api.Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

 public class CheckWinnerTest {

    @Test
    public void refreshData() {
    }

    @Test
     public void checkWin() {
    }

    @Test
    public void checkDraw() {
    }

    @Test
    public void checkOutOfField() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        assertEquals(true, checkWinner.checkOutOfField(4,4));
        assertEquals(false, checkWinner.checkOutOfField(5,4));
    }
}