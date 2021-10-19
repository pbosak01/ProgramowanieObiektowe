import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Vector2dTest {
    @Test
    void testEquals(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(0, 2);
        int v4 = 1;
        boolean v5 = true;


        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(v4));
        assertFalse(v2.equals(v5));
    }

    @Test
    void testToString(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 2);
        Vector2d v3 = new Vector2d(0, 2);

        assertEquals("(1,2)",v1.toString());
        assertEquals("(-1,2)",v2.toString());
        assertEquals("(0,2)",v3.toString());
    }

    @Test
    void testPrecedes(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertTrue(v2.precedes(v1));
        assertTrue(v1.precedes(v1));
        assertTrue(v3.precedes(v5));
        assertFalse(v1.precedes(v4));
        assertFalse(v2.precedes(v3));
    }

    @Test
    void testFollows(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertFalse(v2.follows(v1));
        assertTrue(v1.follows(v1));
        assertFalse(v3.follows(v5));
        assertFalse(v1.follows(v4));
        assertTrue(v2.follows(v3));
        assertTrue(v5.follows(v3));
    }

    @Test
    void testUpperRight(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertEquals(new Vector2d(2,2),v1.upperRight(v4));
        assertEquals(new Vector2d(2,2),v4.upperRight(v1));
        assertEquals(new Vector2d(10,12),v5.upperRight(v3));
        assertEquals(new Vector2d(2,1),v4.upperRight(v2));
    }
    @Test
    void testLowerLeft(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertEquals(new Vector2d(1,1),v1.lowerLeft(v4));
        assertEquals(new Vector2d(1,1),v4.lowerLeft(v1));
        assertEquals(new Vector2d(-2,-2),v5.lowerLeft(v3));
        assertEquals(new Vector2d(-1,1),v4.lowerLeft(v2));
    }
    @Test
    void testAdd(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertEquals(new Vector2d(0,3),v1.add(v2));
        assertEquals(new Vector2d(0,3),v2.add(v1));
        assertEquals(new Vector2d(0,-1),v3.add(v4));
        assertEquals(new Vector2d(12,13),v5.add(v4));
        assertEquals(new Vector2d(10,11),v5.add(v4).add(v3));
    }

    @Test
    void testSubstarct(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertEquals(new Vector2d(2,1),v1.subtract(v2));
        assertNotEquals(new Vector2d(2,1),v2.subtract(v1));
        assertEquals(new Vector2d(4,3),v4.subtract(v3));
        assertEquals(new Vector2d(0,0),v5.subtract(v5));
    }

    @Test
    void testOpposite(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, 1);
        Vector2d v3 = new Vector2d(-2, -2);
        Vector2d v4 = new Vector2d(2, 1);
        Vector2d v5 = new Vector2d(10, 12);

        assertEquals(new Vector2d(-1,-2),v1.opposite());
        assertEquals(new Vector2d(1,-1),v2.opposite());
        assertEquals(new Vector2d(2,2),v3.opposite());
        assertEquals(new Vector2d(-2,-1),v4.opposite());
        assertEquals(new Vector2d(-10,-12),v5.opposite());
    }

}
