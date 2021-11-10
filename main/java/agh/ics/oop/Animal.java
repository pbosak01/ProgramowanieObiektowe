package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private final IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
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
        switch (direction){
            case LEFT :
                this.orientation = this.orientation.previous();
                break;
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case FORWARD:
                Vector2d unitVector = this.orientation.toUnitVector();
                if (this.map.canMoveTo(this.position.add(unitVector))){
                    this.position = this.position.add(unitVector);
                }
                break;
            case BACKWARD:
                Vector2d unitVector1 = this.orientation.toUnitVector();
                if (this.map.canMoveTo(this.position.add(unitVector1))){
                    this.position = this.position.subtract(unitVector1);
                }
                break;
        }
    }



}
