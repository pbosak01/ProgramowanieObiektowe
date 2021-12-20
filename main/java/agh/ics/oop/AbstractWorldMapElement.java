package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMapElement {
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public abstract Vector2d getPosition();

    public abstract String toString();

    public abstract String getPath();

    public void addObserver(IPositionChangeObserver observer){
        for (IPositionChangeObserver observ : observers){
            if (observ.equals(observer)) return;
        }
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        int i =0;
        for (IPositionChangeObserver observ : observers){
            if(observ.equals(observer)){
                observers.remove(i);
                return;
            }
            i +=1;
        }
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,AbstractWorldMapElement element){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition,newPosition,element);
        }
    }
}
