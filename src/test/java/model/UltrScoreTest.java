package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UltrScoreTest {

    @Test
    public void getRawTest() {
        UltrScore ult = new UltrScore();
        ult.setRaw(5);
        assertEquals(5,ult.getRaw());
    }

    @Test
    public void getColTest() {
        UltrScore ult = new UltrScore();
        ult.setCol(5);
        assertEquals(5,ult.getCol());
    }

    @Test
    public void getScoreTest() {
        UltrScore ult = new UltrScore();
        ult.setScore(5);
        assertEquals(5,ult.getScore());
    }

    @Test
    public void setRawTest() {
        UltrScore ult = new UltrScore();
        ult.setRaw(5);
        assertEquals(5,ult.getRaw());
    }

    @Test
    public void setColTest() {
        UltrScore ult = new UltrScore();
        ult.setCol(5);
        assertEquals(5,ult.getCol());
    }

    @Test
    public void setScoreTest() {
        UltrScore ult = new UltrScore();
        ult.setScore(5);
        assertEquals(5,ult.getScore());
    }
}