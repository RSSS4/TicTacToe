package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void getXTest() {
        Point point = new Point(23,23);
        assertEquals(23,point.getX());
    }

    @Test
    public void getYTest() {
        Point point = new Point(23,23);
        assertEquals(23,point.getY());
    }

    @Test
    public void setXTest() {
        Point point = new Point(0,0);
        point.setX(15);
        assertEquals(15,point.getX());
    }

    @Test
    public void setYTest() {
        Point point = new Point(0,0);
        point.setY(15);
        assertEquals(15,point.getY());
    }
}