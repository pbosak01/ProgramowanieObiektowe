package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
        private SortedSet<AbstractWorldMapElement> xSet = new TreeSet<>(new XComparator());
        private SortedSet<AbstractWorldMapElement> ySet = new TreeSet<>(new YComparator());

        /*public MapBoundary(HashMap<Vector2d,AbstractWorldMapElement> elements){
            for (AbstractWorldMapElement element : elements.values()){
                xSet.add(element);
                ySet.add(element);
            }
        }*/

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,AbstractWorldMapElement element) {
            xSet.remove(element);
            xSet.add(element);
            ySet.remove(element);
            ySet.add(element);
    }
    public Vector2d getUpper(){
            return new Vector2d(xSet.last().getPosition().x,ySet.last().getPosition().y);
    }
    public Vector2d getLower(){
        return new Vector2d(xSet.first().getPosition().x,ySet.first().getPosition().y);
    }
    public void addElement(AbstractWorldMapElement element){
        xSet.add(element);
        ySet.add(element);
    }


}

