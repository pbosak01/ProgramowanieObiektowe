package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class App extends Application {
    GridPane gridPane = new GridPane();


    @Override
    public void start(Stage primaryStage){
        try{
            gridPane.getChildren().clear();
            Object[] args = getParameters().getRaw().toArray();
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            SimulationEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);

            AbstractWorldMap map1 = (AbstractWorldMap) map;
            AbstractWorldMapElement[] elements = map1.elements.values().toArray(new AbstractWorldMapElement[0]);
            Vector2d upperRight = map1.mapBoundary.getUpper();
            Vector2d lowerLeft = map1.mapBoundary.getLower();


            drawFrame(upperRight,lowerLeft);
            drawObjects(elements, upperRight, lowerLeft);

            gridPane.setGridLinesVisible(true);
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
    }catch (IllegalArgumentException ex){System.out.println(ex);}
    }
    private void drawFrame(Vector2d upperRight, Vector2d lowerLeft){
        Label label = new Label("y/x");
        gridPane.add(label,0,0);
        gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        gridPane.getRowConstraints().add(new RowConstraints(20));
        GridPane.setHalignment(label, HPos.CENTER);

        int i = lowerLeft.x;
        int position = 1;
        while(i < upperRight.x + 1){
            Label number = new Label(Integer.toString(i));
            gridPane.add(number, position, 0);
            gridPane.getColumnConstraints().add(new ColumnConstraints(35));
            GridPane.setHalignment(number, HPos.CENTER);
            position += 1;
            i += 1;
        }

        i = upperRight.y;
        position = 1;
        while(i >= lowerLeft.y){
            Label number = new Label(Integer.toString(i));
            gridPane.add(number, 0,  position);
            gridPane.getRowConstraints().add(new RowConstraints(35));
            GridPane.setHalignment(number, HPos.CENTER);
            position += 1;
            i -= 1;
        }
    }
    private void drawObjects(AbstractWorldMapElement[] elements, Vector2d upperRight,Vector2d lowerLeft) {
        for(AbstractWorldMapElement element : elements) {
            Label label = new Label(element.toString());
            gridPane.add(label, element.getPosition().x - lowerLeft.x + 1, upperRight.y - element.getPosition().y + 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

}
