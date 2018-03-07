package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckWinnerTest {

    @Test
    void refreshData() {
    }

    @Test
    void checkWin() {
    }

    @Test
    void checkDraw() {
    }

    @Test
    void checkOutOfField() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        assertEquals(true, checkWinner.checkOutOfField(4,4));
        assertEquals(false, checkWinner.checkOutOfField(5,4));
    }
}