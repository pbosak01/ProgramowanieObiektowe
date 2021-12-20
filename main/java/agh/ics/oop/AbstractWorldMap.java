package agh.ics.oop;

import java.util.Map;
import java.util.HashMap;


public abstract class  AbstractWorldMap  implements IWorldMap,IPositionChangeObserver{
    public Map<Vector2d,AbstractWorldMapElement> elements = new HashMap<>();
    public MapVisualizer map = new MapVisualizer(this);
    public MapBoundary mapBoundary = new MapBoundary();


    public boolean place(Animal animal){
        if (this.canMoveTo(animal.getPosition())){
            elements.put(animal.getPosition(),animal);
            mapBoundary.addElement(animal);
            animal.addObserver(mapBoundary);
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
        return (map.draw(mapBoundary.getLower(), mapBoundary.getUpper()));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,AbstractWorldMapElement element) {
        elements.remove(oldPosition);
        elements.put(newPosition,element);
    }
    public boolean isGrass(Object object){
        return (object instanceof Grass);
    }

}
