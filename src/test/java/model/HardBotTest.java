package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HardBotTest {
    private HardBot hardBot;
    private PvMGameProcess pvMGameProcess;
    @Before
    public void creat(){
        hardBot = new HardBot(2);
        pvMGameProcess = new PvMGameProcess(3,2);
    }

    @Test
    public void HardBotCloseWinAttackOn4StepsForward() {
        Buttons buttons[][] = new Buttons[7][7];
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }
        buttons[0][0].setWho(1);
        hardBot.setFieldSize(7);
        hardBot.refreshData(buttons);
        PvMGameProcess.setTurn(1);
        PvMGameProcess.refreshData(buttons);
        hardBot.hitBot();
        assertEquals(2,buttons[0][4].getWho());
    }

    @Test
    public void HardBotCloseWinAttackOn3StepsForward() {
        Buttons buttons[][] = new Buttons[7][7];
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }
        buttons[0][0].setWho(1);
        buttons[1][1].setWho(1);
        hardBot.setFieldSize(7);
        hardBot.refreshData(buttons);
        PvMGameProcess.setTurn(1);
        PvMGameProcess.refreshData(buttons);
        hardBot.hitBot();
        assertEquals(2,buttons[4][4].getWho());
    }
    @Test
    public void HardBotCloseWinAttackOn2StepsForward() {
        Buttons buttons[][] = new Buttons[7][7];
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new Buttons(2);
            }
        }
        buttons[2][2].setWho(1);
        buttons[2][3].setWho(1);
        buttons[2][4].setWho(1);
        hardBot.setFieldSize(7);
        hardBot.refreshData(buttons);
        PvMGameProcess.setTurn(1);
        PvMGameProcess.refreshData(buttons);
        hardBot.hitBot();
        assertEquals(2,buttons[2][1].getWho());
    }
}