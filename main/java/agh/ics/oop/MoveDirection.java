package agh.ics.oop;


public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT,
    ;

    public String toString() {
        return switch (this) {
            case FORWARD -> "f";
            case BACKWARD -> "b";
            case RIGHT -> "r";
            case LEFT -> "l";

        };
    }
}