package agh.ics.oop;



public class OptionsParser{

    public static MoveDirection[] parse(String[] list){
        int len = list.length;
        MoveDirection[] result = new MoveDirection[len];
        int i =0;
        for(String element : list){
            switch(element){
                case "f", "forward":
                    result[i]=(MoveDirection.FORWARD);
                    break;
                case "b","backward":
                    result[i]=(MoveDirection.BACKWARD);
                    break;
                case "l","left":
                    result[i]=(MoveDirection.LEFT);
                    break;
                case "r","right":
                    result[i]=(MoveDirection.RIGHT);
                    break;
                default:
                    i -=1;
                    break;
            }
            i+=1;
        }
        return result;
    }
}
