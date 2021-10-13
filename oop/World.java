package agh.ics.oop;
import java.util.ArrayList;

//Piotr Bosak
public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        ArrayList<Direction> dir = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f":
                    dir.add(Direction.FORWARD);
                    break;
                case "b":
                    dir.add(Direction.BACKWARD);
                    break;
                case "r":
                    dir.add(Direction.RIGHT);
                    break;
                case "l":
                    dir.add(Direction.LEFT);
                    break;
            }
        }

        run(dir);
        System.out.println("Stop");
    }

    static void run(ArrayList<Direction> arguments) {
        for (Direction argument : arguments) {
            switch (argument) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }

        }
    }
}
