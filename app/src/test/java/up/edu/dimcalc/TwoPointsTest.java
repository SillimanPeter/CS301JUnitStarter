package up.edu.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    @Test
    public void randomValue() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        //the point (100, 100) is beyond the boundaries of randomValue() return possibilities.
        testPoints.setPoint(0, 100, 100);
        testPoints.randomValue(0);
        testPoints.setPoint(1, 100, 100);
        testPoints.randomValue(0);
        assertNotEquals(100, testPoints.getPoint(0).x);
        assertNotEquals(100, testPoints.getPoint(0).y);
        assertNotEquals(100, testPoints.getPoint(1).x);
        assertNotEquals(100, testPoints.getPoint(0).y);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 2, -3);
        testPoints.setPoint(1, -4, 5);
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        assertEquals(0, testPoints.getPoint(0).x);
        assertEquals(0, testPoints.getPoint(0).x);
        assertEquals(0, testPoints.getPoint(1).x);
        assertEquals(0, testPoints.getPoint(1).y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        //check copy point 0 to 1
        testPoints.setPoint(0, 2, -3);
        testPoints.setPoint(1, -4, 5);
        testPoints.copy(0, 1);
        int tpx = testPoints.getPoint(1).x;
        int tpy = testPoints.getPoint(1).y;
        //checks the values are the same
        assertEquals(testPoints.getPoint(0).x, tpx);
        assertEquals(testPoints.getPoint(0).y, tpy);
        //checks the value is the correct value
        assertEquals(2, tpx);
        assertEquals(-3, tpy);

        //check copy point 1 to 0
        testPoints.setPoint(0, 2, -3);
        testPoints.setPoint(1, -4, 5);
        testPoints.copy(1, 0);
        tpx = testPoints.getPoint(0).x;
        tpy = testPoints.getPoint(0).y;
        assertEquals(-4, tpx);
        assertEquals(5, tpy);
        assertEquals(testPoints.getPoint(1).x, tpx);
        assertEquals(testPoints.getPoint(1).y, tpy);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 3);
        testPoints.setPoint(1, 2, 7);
        double ptd = testPoints.distance();
        assertEquals(5.0, ptd, 0.1);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 3);
        testPoints.setPoint(1, 3, 7);
        double slope = testPoints.slope();
        assertEquals(-2, slope, 0.1);
    }
}