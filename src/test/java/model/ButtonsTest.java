package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ButtonsTest {

    @Test
    public void refreshWho() {
        Buttons buttons = new Buttons(1);
        buttons.setWho(1);
        buttons.refresh();
        assertEquals(0,buttons.getWho());
    }

    @Test
    public void refreshFree() {
        Buttons buttons = new Buttons(1);
        buttons.setFree(false);
        buttons.refresh();
        assertEquals(true,buttons.isFree());
    }


    @Test
    public void endGame() {
        Buttons buttons = new Buttons(1);
        buttons.setFree(true);
        buttons.endGame();
        assertEquals(false,buttons.isFree());
    }


}