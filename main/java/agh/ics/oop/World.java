package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();

        System.out.println(animal.toString());
        OptionParser optionParser = new OptionParser();
        String[] movesString =  {"l","f","l","b"};
        optionParser.moves = OptionParser.parse(movesString);
        for(MoveDirection move : optionParser.moves){
            animal.move(move);
        }
        System.out.println(animal.toString());


    }

}
