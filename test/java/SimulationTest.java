import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {

    @Test
    void oneAnimalTest(){
        String[] directions1 = {"f","f","b","l","f","l"};
        String[] directions2 = {"b","x","f","f","f","f","r","r"};
        MoveDirection[] directionsParsed1 = OptionsParser.parse(directions1);
        MoveDirection[] directionsParsed2 = OptionsParser.parse(directions2);
        IWorldMap map1 = new RectangularMap(10,10);
        IWorldMap map2 = new RectangularMap(10,10);
        Vector2d[] positions1 = {new Vector2d(2,2)};
        Vector2d[] positions2 = {new Vector2d(1,0)};
        IEngine engine1 = new SimulationEngine(directionsParsed1,map1,positions1);
        IEngine engine2 = new SimulationEngine(directionsParsed2,map2,positions2);
        engine1.run();
        engine2.run();

        assertEquals(map1,map2);
    }

    @Test
    void twoAnimalsTest(){
        String[] directions1 = {"f","f","b","l","f","l"};
        String[] directions2 = {"f","l","f","l","b"};
        MoveDirection[] directionsParsed1 = OptionsParser.parse(directions1);
        MoveDirection[] directionsParsed2 = OptionsParser.parse(directions2);
        IWorldMap map1 = new RectangularMap(10,10);
        IWorldMap map2 = new RectangularMap(10,10);
        Vector2d[] positions1 = {new Vector2d(2,2),new Vector2d(0,0)};
        Vector2d[] positions2 = {new Vector2d(2,2),new Vector2d(0,1)};
        IEngine engine1 = new SimulationEngine(directionsParsed1,map1,positions1);
        IEngine engine2 = new SimulationEngine(directionsParsed2,map2,positions2);
        engine1.run();
        engine2.run();

        assertEquals(map1,map2);
    }

    @Test
    void treeAnimalsTest(){
        String[] directions1 = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        String[] directions2 = {};
        MoveDirection[] directionsParsed1 = OptionsParser.parse(directions1);
        MoveDirection[] directionsParsed2 = OptionsParser.parse(directions2);
        IWorldMap map1 = new RectangularMap(10,10);
        IWorldMap map2 = new RectangularMap(10,10);
        Vector2d[] positions1 = {new Vector2d(0,2),new Vector2d(0,1), new Vector2d(0,0)};
        Vector2d[] positions2 = {new Vector2d(0,10),new Vector2d(0,9),new Vector2d(0,8)};
        IEngine engine1 = new SimulationEngine(directionsParsed1,map1,positions1);
        IEngine engine2 = new SimulationEngine(directionsParsed2,map2,positions2);
        engine1.run();
        engine2.run();

        assertEquals(map1,map2);
    }

}
