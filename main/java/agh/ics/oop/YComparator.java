package agh.ics.oop;

import java.util.Comparator;

public class YComparator implements Comparator<AbstractWorldMapElement> {
    @Override
    public int compare(AbstractWorldMapElement o1, AbstractWorldMapElement o2) {
        Vector2d position1 = o1.getPosition();
        Vector2d position2 = o2.getPosition();
        if (position1.y == position2.y){
            if(position1.x== position2.x){
                if(o1.getClass()==Animal.class){
                    if(o2.getClass()==Animal.class){
                        return 0;
                    }
                    return 1;
                }
                return -1;
            }
            return position1.x- position2.x;
        }
        return position1.y - position2.y;
    }
}
