package agh.ics.oop;


import java.util.ArrayList;
import java.util.Objects;

public class RectangularMap implements IWorldMap{
    public int width;
    public int height;
    public ArrayList <Animal> animals = new ArrayList<>();
    public MapVisualizer map = new MapVisualizer(this);



    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangularMap that = (RectangularMap) o;
        return width == that.width && height == that.height && Objects.equals(animals, that.animals);
    }



    public boolean canMoveTo(Vector2d position){
        return (position.precedes(new Vector2d(width,height))
                && position.follows(new Vector2d(0,0))
                && !this.isOccupied(position));
    }

    public boolean place(Animal animal){
        if (this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;

    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals){
            if (animal.getPosition().equals(position)){
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
        return null;
    }
    public String toString(){
        return (map.draw(new  Vector2d(0,0),new Vector2d(width,height)));
    }
}
