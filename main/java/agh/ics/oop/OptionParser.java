package agh.ics.oop;

import java.util.ArrayList;

public class OptionParser{
    public ArrayList<MoveDirection> moves;

    public static ArrayList<MoveDirection> parse(String[] list){
        ArrayList<MoveDirection> result = new ArrayList<>();
        for(String element : list){
            switch(element){
                case "f","forward":
                    result.add(MoveDirection.FORWARD);
                    break;
                case "b","backward":
                    result.add(MoveDirection.BACKWARD);
                    break;
                case "l","left":
                    result.add(MoveDirection.LEFT);
                    break;
                case "r","right":
                    result.add(MoveDirection.RIGHT);
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
