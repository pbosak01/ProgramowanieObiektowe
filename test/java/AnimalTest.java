import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class AnimalTest {

        @Test
        void TestOrientation() {
            AbstractWorldMap map = new GrassField(10);
            Animal animal = new Animal(map, new Vector2d(2, 2));
            animal.move(MoveDirection.RIGHT);
            assertEquals(MapDirection.EAST, animal.getOrientation());
            animal.move(MoveDirection.RIGHT);
            assertEquals(MapDirection.SOUTH, animal.getOrientation());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.RIGHT);
            assertEquals(MapDirection.WEST, animal.getOrientation());
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.LEFT);
            assertEquals(MapDirection.WEST, animal.getOrientation());

        }

        @Test
        void TestPosition() {
            AbstractWorldMap map = new GrassField(10);
            Animal animal = new Animal(map, new Vector2d(2, 2));
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(2, 3), animal.getPosition());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.BACKWARD);
            assertEquals(new Vector2d(1, 3), animal.getPosition());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(1, 0), animal.getPosition());

        }

        @Test
        void TestMap() {
            AbstractWorldMap map = new GrassField(10);
            Animal animal = new Animal(map, new Vector2d(2, 2));
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(2, 9), animal.getPosition());
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.BACKWARD);
            assertEquals(new Vector2d(2, 4), animal.getPosition());
        }


        @Test
        void TestOptionParser() {
            AbstractWorldMap map1 = new GrassField(4);
            AbstractWorldMap map2 = new GrassField(4);
            Animal animal1 = new Animal(map1, new Vector2d(2, 2));
            Animal animal2 = new Animal(map2, new Vector2d(2, 2));

            String[] moves1 = {"l", "f", "l", "b"};
            String[] moves2 = {"left", "forward", "left", "backward"};
            String[] moves3 = {"right", "r", "f", "f", "f", "f"};
            String[] moves4 = {"l", "b", "b", "x"};

            MoveDirection[] moves = new OptionsParser().parse(moves1);
            for (MoveDirection move : moves) {
                animal1.move(move);
            }
            assertEquals(new Vector2d(1, 3), animal1.getPosition());

            moves = new OptionsParser().parse(moves2);
            for (MoveDirection move : moves) {
                animal2.move(move);
            }
            assertEquals(new Vector2d(1, 3), animal2.getPosition());

            moves = new OptionsParser().parse(moves3);
            for (MoveDirection move : moves) {
                animal2.move(move);
            }
            assertEquals(new Vector2d(1, 7), animal2.getPosition());


            try {
                moves = new OptionsParser().parse(moves4);
                fail();
            } catch (IllegalArgumentException ex) {
                assertEquals("x is not legal move specification", ex.getMessage());
            }
        }
    }

