package agh.ics.oop;

import java.util.ArrayList;
import java.util.Objects;

public class Animal extends AbstractWorldMapElement{
    private final IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;


    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.addObserver((IPositionChangeObserver) map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return orientation == animal.orientation && Objects.equals(position, animal.position);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }


    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";

        };
    }
    public void move(MoveDirection direction){
        Vector2d unitVector = this.orientation.toUnitVector();
        Vector2d oldPosition = this.position;
        GrassField map1 = (GrassField) map;
        switch (direction){
            case LEFT :
                this.orientation = this.orientation.previous();
                break;
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case FORWARD:
                if (this.map.canMoveTo(this.position.add(unitVector))){
                    this.position = this.position.add(unitVector);
                    positionChanged(oldPosition,this.position,this);

                }
                break;
            case BACKWARD:
                if (this.map.canMoveTo(this.position.add(unitVector))){
                    this.position = this.position.subtract(unitVector);
                    positionChanged(oldPosition,this.position,this);
                }
                break;
        }
    }


}
