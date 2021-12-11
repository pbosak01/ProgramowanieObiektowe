package agh.ics.oop;


import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) throws IllegalArgumentException{
        /*try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2),new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
        }catch (IllegalArgumentException ex){
            System.out.println(ex);
        }*/
        Application.launch(App.class,args);

    }

}
