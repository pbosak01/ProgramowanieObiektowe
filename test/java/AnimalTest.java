import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    void TestOrientation(){
        Animal animal = new Animal();
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
    void TestPosition(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3),animal.getPosition());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(1,3),animal.getPosition());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(1,0),animal.getPosition());

    }

    @Test
    void TestMap(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal.getPosition());
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,0),animal.getPosition());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(0,0),animal.getPosition());
    }


    @Test
    void TestOptionParser(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        OptionParser optionParser = new OptionParser();
        String[] moves1 =  {"l","f","l","b"};
        String[] moves2 =  {"left","forward","left","backward"};
        String[] moves3 =  {"right","r","f","f","f","f"};
        String[] moves4 =  {"l","b","b","right","forward","f","f","f","f","x","F","23"};

        optionParser.moves = OptionParser.parse(moves1);
        for(MoveDirection move : optionParser.moves){
            animal1.move(move);
        }
        assertEquals(new Vector2d(1,3), animal1.getPosition());
        optionParser.moves = OptionParser.parse(moves2);
        for(MoveDirection move : optionParser.moves){
            animal2.move(move);
        }
        assertEquals(new Vector2d(1,3), animal2.getPosition());

        optionParser.moves = OptionParser.parse(moves3);
        for(MoveDirection move : optionParser.moves){
            animal2.move(move);
        }
        assertEquals(new Vector2d(1,4), animal2.getPosition());

        optionParser.moves = OptionParser.parse(moves4);
        for(MoveDirection move : optionParser.moves){
            animal1.move(move);
        }
        assertEquals(new Vector2d(0,0), animal1.getPosition());



    }

}
