package agh.ics.oop;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public abstract class  AbstractWorldMap  implements IWorldMap,IPositionChangeObserver{
    public Map<Vector2d,AbstractWorldMapElement> elements = new HashMap<>();
    public MapVisualizer map = new MapVisualizer(this);
    public MapBoundary mapBoundary = new MapBoundary();


    public boolean place(Animal animal){
        if (this.canMoveTo(animal.getPosition())){
            elements.put(animal.getPosition(),animal);
            mapBoundary.addElement(animal);
            return true;
        }
        else{
            throw new IllegalArgumentException("Position " +  animal.getPosition().toString() + " is occupied");
        }
    }
    public abstract boolean canMoveTo(Vector2d position);

    public boolean isOccupied(Vector2d position) {
        return elements.containsKey(position);
    }

    public Object objectAt(Vector2d position) {
        return elements.get(position);
    }


    public String toString(){
        Vector2d upperRight = new Vector2d(-2147483648,-2147483648);
        Vector2d lowerLeft = new Vector2d(2147483647,2147483647);
        Set<Vector2d> animalSet = elements.keySet();
        for (Vector2d position : animalSet){
            upperRight = upperRight.upperRight(position);
            lowerLeft = lowerLeft.lowerLeft(position);
        }
        return (map.draw(lowerLeft,upperRight));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,AbstractWorldMapElement element) {
        //AbstractWorldMapElement animal = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition,element);
    }
    public boolean isGrass(Object object){
        Grass grass = new Grass(new Vector2d(1, 1));
        return (object.getClass()==grass.getClass());
    }

}
