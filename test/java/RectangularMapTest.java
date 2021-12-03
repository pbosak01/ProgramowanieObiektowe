import agh.ics.oop.Animal;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void testPlace(){
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal1 = new Animal(map, new Vector2d(1, 2));
        Animal animal2 = new Animal(map, new Vector2d(0, 2));
        Animal animal3 = new Animal(map, new Vector2d(4, 4));
        Animal animal4 = new Animal(map, new Vector2d(0, 2));

        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));
        assertTrue(map.place(animal3));
        try {
            map.place(animal4);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Position (0,2) is occupied", ex.getMessage());
        }
    }


    @Test
    void testCanMoveTo(){
        RectangularMap map = new RectangularMap(4, 4);
        assertTrue(map.canMoveTo(new Vector2d(1,1)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
        assertFalse(map.canMoveTo(new Vector2d(0,-1)));
        assertFalse(map.canMoveTo(new Vector2d(0,5)));
        assertFalse(map.canMoveTo(new Vector2d(100,5)));

        map.place(new Animal(map,new Vector2d(1,1)));
        map.place(new Animal(map,new Vector2d(4,2)));

        assertFalse(map.canMoveTo(new Vector2d(1,1)));
        assertFalse(map.canMoveTo(new Vector2d(4,2)));
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    void testIsOccupied(){
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal1 = new Animal(map, new Vector2d(1, 2));
        Animal animal2 = new Animal(map, new Vector2d(0, 2));
        Animal animal3 = new Animal(map, new Vector2d(4, 4));

        assertFalse(map.isOccupied(new Vector2d(0,0)));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertTrue(map.isOccupied(new Vector2d(1,2)));
        assertTrue(map.isOccupied(new Vector2d(0,2)));
        assertTrue(map.isOccupied(new Vector2d(4,4)));
        assertFalse(map.isOccupied(new Vector2d(3,3)));
    }

    @Test
    void testObjectAt(){
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal1 = new Animal(map, new Vector2d(1, 2));
        Animal animal2 = new Animal(map, new Vector2d(0, 2));
        Animal animal3 = new Animal(map, new Vector2d(4, 4));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertEquals(animal1,map.objectAt(new Vector2d(1,2)));
        assertEquals(animal2,map.objectAt(new Vector2d(0,2)));
        assertEquals(animal3,map.objectAt(new Vector2d(4,4)));
        assertNull(map.objectAt(new Vector2d(3, 3)));
    }
}
