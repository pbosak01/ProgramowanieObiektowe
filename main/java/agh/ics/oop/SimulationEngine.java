package agh.ics.oop;


import java.util.ArrayList;

public class SimulationEngine implements IEngine,IPositionChangeObserver{
    public MoveDirection[] moves;
    public IWorldMap map;
    public Vector2d[] positions;
    private ArrayList<Vector2d> animals = new ArrayList<>();


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        this.positions = positions;


        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if(map.place(animal)){
                animal.addObserver(this);
                animals.add(position);
            }
        }
    }

    public void run() {
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
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for(int i=0;i<this.positions.length;i+=1){
            if(this.positions[i].equals(oldPosition)){
                this.positions[i]=newPosition;
            }
        }
    }
}
