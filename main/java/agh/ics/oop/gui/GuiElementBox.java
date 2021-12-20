package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.Grass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private VBox vBox;
    public GuiElementBox(AbstractWorldMapElement element) throws FileNotFoundException {

        Image image = new Image(new FileInputStream(element.getPath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Label label = new Label(element.getPosition().toString());
        if (element instanceof Grass){
            label = new Label("Trawa");
        }
        vBox = new VBox();
        vBox.getChildren().add(imageView);
        vBox.getChildren().add(label);
        vBox.setAlignment(Pos.CENTER);

    }

    public VBox getvBox() {
        return vBox;
    }

}
