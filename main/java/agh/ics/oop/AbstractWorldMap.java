package agh.ics.oop;

import java.util.ArrayList;

public abstract class  AbstractWorldMap  implements IWorldMap{
    public ArrayList<Animal> animals = new ArrayList<>();
    public MapVisualizer map = new MapVisualizer(this);
    public ArrayList<Grass> grasses =new ArrayList<>();

    public boolean place(Animal animal){
        if (this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }
    public abstract boolean canMoveTo(Vector2d position);

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals){
            if (animal.getPosition().equals(position)){
                return true;
            }
        }
        for (Grass grass : grasses){
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        for (Grass grass : grasses){
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }

        return null;
    }

    public String toString(){
        Vector2d upperRight = new Vector2d(-2147483648,-2147483648);
        Vector2d lowerLeft = new Vector2d(2147483647,2147483647);
        for (Animal animal : animals){
            upperRight = upperRight.upperRight(animal.getPosition());
            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grasses){
            upperRight = upperRight.upperRight(grass.getPosition());
            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        return (map.draw(lowerLeft,upperRight));
    }

}
