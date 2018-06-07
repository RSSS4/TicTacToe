package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediumBotTest {
    private MediumBot mediumBot;
    private PvMGameProcess pvMGameProcess;
    @Before
    public void creat(){
        mediumBot = new MediumBot(2);
        pvMGameProcess = new PvMGameProcess(3,2);
    }

    @Test
    public void MediumBotCloseWinAttackOn2StepsForward() {
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }
        buttons[2][0].setWho(1);
        mediumBot.setFieldSize(3);
        mediumBot.refreshData(buttons);
        PvMGameProcess.setTurn(1);
        PvMGameProcess.refreshData(buttons);
        mediumBot.hitBot();
        assertEquals(2,buttons[0][0].getWho());
    }
}