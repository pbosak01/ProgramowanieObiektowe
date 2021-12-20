package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application implements IPositionChangeObserver{
    GridPane gridPane = new GridPane();
    AbstractWorldMap map;


    @Override
    public void start(Stage primaryStage){
        try{
            gridPane.getChildren().clear();
            Object[] args = getParameters().getRaw().toArray();
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

            SimulationEngine engine = new SimulationEngine(directions, map, positions,this);
            Thread engineThread = new Thread(engine);
            engineThread.start();
            //engine.run();
            System.out.println(map);

            //AbstractWorldMap map1 = (AbstractWorldMap) map;
//            AbstractWorldMapElement[] elements = map.elements.values().toArray(new AbstractWorldMapElement[0]);
//            Vector2d upperRight = map.mapBoundary.getUpper();
//            Vector2d lowerLeft = map.mapBoundary.getLower();
//
//
//            drawFrame(upperRight,lowerLeft);
//            drawObjects(elements, upperRight, lowerLeft);


            gridPane.setGridLinesVisible(true);
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
    }catch (IllegalArgumentException ex){System.out.println(ex);}
    }

    public void drawMap() throws FileNotFoundException {
        Platform.runLater(() -> {
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(false);
            gridPane.setGridLinesVisible(true);

            AbstractWorldMapElement[] elements = map.elements.values().toArray(new AbstractWorldMapElement[0]);
        Vector2d upperRight = map.mapBoundary.getUpper();
        Vector2d lowerLeft = map.mapBoundary.getLower();


        drawFrame(upperRight,lowerLeft);
            try {
                drawObjects(elements, upperRight, lowerLeft);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    private void drawFrame(Vector2d upperRight, Vector2d lowerLeft){
        Label label = new Label("y/x");
        gridPane.add(label,0,0);
        gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        gridPane.getRowConstraints().add(new RowConstraints(30));
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
    private void drawObjects(AbstractWorldMapElement[] elements, Vector2d upperRight,Vector2d lowerLeft) throws FileNotFoundException {
        for(AbstractWorldMapElement element : elements) {
            GuiElementBox guiElementBox = new GuiElementBox(element);
            VBox vBox = guiElementBox.getvBox();
            gridPane.add(vBox, element.getPosition().x - lowerLeft.x + 1, upperRight.y - element.getPosition().y + 1);
            GridPane.setHalignment(vBox, HPos.CENTER);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition, AbstractWorldMapElement element) {
        gridPane.getChildren().clear();

        //drawFrame(upperRight,lowerLeft);
        //drawObjects(elements, upperRight, lowerLeft);
    }
}
