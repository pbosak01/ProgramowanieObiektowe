package agh.ics.oop;


import agh.ics.oop.gui.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SimulationEngine implements IEngine,IPositionChangeObserver,Runnable{
    public MoveDirection[] moves;
    public IWorldMap map;
    public Vector2d[] positions;
    private ArrayList<Vector2d> animals = new ArrayList<>();
    private App app;


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions,App app) {
        this.moves = moves;
        this.map = map;
        this.positions = positions;
        this.app = app;


        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if(map.place(animal)){
                animal.addObserver(this);
                animals.add(position);
            }

        }
    }

    public void run()  {
        AbstractWorldMap map1 = (AbstractWorldMap) map;
        Animal animal;
        int quantity = animals.size();
        int i = 0;
        for (MoveDirection move : moves){
            if(move==null){
                return;
            }
            animal = (Animal) map1.elements.get(positions[i%quantity]);
            animal.move(move);
            i+=1;
            try {
                app.drawMap();
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException exception) {
                System.out.println(exception.toString());
            }
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,AbstractWorldMapElement element) {
        for(int i=0;i<this.positions.length;i+=1){
            if(this.positions[i].equals(oldPosition)){
                this.positions[i]=newPosition;
            }
        }
        
    }
}
