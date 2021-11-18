package agh.ics.oop;

import java.util.Objects;

public class RectangularMap extends AbstractWorldMap{
    public int width;
    public int height;


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

}
