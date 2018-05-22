package model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BotTest {
    private EasyBot easyBot;
    private PvMGameProcess pvMGameProcess;

    @Before
    public void initialize() {
        pvMGameProcess = new PvMGameProcess(3,1);
        easyBot = new EasyBot(1);
    }

    @Test
    public void winAttack() {
        Buttons buttons[][] = new Buttons[3][3];
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Buttons(1);
            }
        }
        buttons[0][0].setWho(1);
        buttons[0][1].setWho(1);
        easyBot.setFieldSize(3);
        easyBot.refreshData(buttons);
        PvMGameProcess.refreshData(buttons);
        easyBot.winAttack(1);
        assertEquals(1,buttons[0][2].getWho());

    }

    @Ignore
    public void defAttack() {
        Buttons buttons[][] = new Buttons[5][5];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Buttons(1);
            }
        }
        buttons[0][0].setWho(2);
        buttons[0][1].setWho(2);
        buttons[0][2].setWho(2);
        easyBot.setFieldSize(5);
        easyBot.setTestEnemyWho(2);
        easyBot.refreshData(buttons);
        PvMGameProcess.refreshData(buttons);
        easyBot.defAttack(1);
        assertEquals(1,buttons[0][3].getWho());

    }

    @Test
    public void setEnemyWho() {
        EasyBot easyBot = new EasyBot(1);
        PvMGameProcess.setTurn(0);
        int expected = 1;
        easyBot.setEnemywho(0);
        assertEquals(expected,easyBot.getEnemywho());
    }

    @Test
    public void getPointToWin() {
        EasyBot easyBot = new EasyBot(1);
        int expected = 3;
        easyBot.setPointToWin(3);
        assertEquals(expected,easyBot.getPointToWin());

    }
}