import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.GrassField;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    void testCanMoveto(){
        GrassField map = new GrassField(10);
        map.animals.add(new Animal(map,new Vector2d(1,2)));
        map.animals.add(new Animal(map,new Vector2d(4,3)));
        map.animals.add(new Animal(map,new Vector2d(100,-100)));

        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(1000,-100)));
        assertFalse(map.canMoveTo(new Vector2d(1,2)));
        assertFalse(map.canMoveTo(new Vector2d(4,3)));
        assertFalse(map.canMoveTo(new Vector2d(100,-100)));
    }

    @Test
    void testPlace(){
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(map, new Vector2d(3, 4));
        Animal animal2 = new Animal(map, new Vector2d(3, 4));
        Animal animal3 = new Animal(map, new Vector2d(-343, 400));
        Animal animal4 = new Animal(map, new Vector2d(-33, 400));

        assertTrue(map.place(animal1));
        assertTrue(map.place(animal3));
        assertTrue(map.place(animal4));
        assertFalse(map.place(animal2));
    }

    @Test
    void testIsOccupied() {
        GrassField map = new GrassField(0);
        map.animals.add(new Animal(map,new Vector2d(1,2)));
        map.animals.add(new Animal(map,new Vector2d(4,3)));
        map.animals.add(new Animal(map,new Vector2d(100,-100)));
        map.grasses.add(new Grass(new Vector2d(5,6)));
        map.grasses.add(new Grass(new Vector2d(50,6)));

        assertTrue(map.isOccupied(new Vector2d(1,2)));
        assertTrue(map.isOccupied(new Vector2d(4,3)));
        assertTrue(map.isOccupied(new Vector2d(100,-100)));
        assertTrue(map.isOccupied(new Vector2d(5,6)));
        assertTrue(map.isOccupied(new Vector2d(50,6)));
        assertFalse(map.isOccupied(new Vector2d(500,600)));
        assertFalse(map.isOccupied(new Vector2d(0,-60)));
    }
    @Test
    void testObjectAt(){
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(3, 4));
        Animal animal2 = new Animal(map, new Vector2d(31, 4));
        Animal animal3 = new Animal(map, new Vector2d(-343, 400));
        Grass grass1 = new Grass(new Vector2d(23, 43));
        Grass grass2 = new Grass(new Vector2d(-23, 3));

        map.animals.add(animal1);
        map.animals.add(animal2);
        map.animals.add(animal3);
        map.grasses.add(grass1);
        map.grasses.add(grass2);

        assertEquals(animal1,map.objectAt(new Vector2d(3,4)));
        assertEquals(animal2,map.objectAt(new Vector2d(31,4)));
        assertEquals(animal3,map.objectAt(new Vector2d(-343,400)));
        assertEquals(grass1,map.objectAt(new Vector2d(23,43)));
        assertEquals(grass2,map.objectAt(new Vector2d(-23,3)));
        assertNull(map.objectAt(new Vector2d(0,0)));
        assertNull(map.objectAt(new Vector2d(43423,33)));
    }

}
