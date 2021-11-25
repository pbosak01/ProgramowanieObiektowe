package agh.ics.oop;


import java.util.Random;

public class GrassField extends AbstractWorldMap{
    public int quantity;

    public GrassField(int quantity) {
        this.quantity = quantity;
        putGrass(quantity);

    }

    public void putGrass(int quantity){
        Random random = new Random();
        int x;
        int y;
        for (int i =0;i<quantity;i++){
            do {
                x = random.nextInt((int)Math.sqrt(quantity*10));
                y = random.nextInt((int)Math.sqrt(quantity*10));
            }
            while(isOccupied(new Vector2d(x,y)));
            elements.put(new Vector2d(x,y),new Grass(new Vector2d(x,y)));
        }
    }


    public boolean canMoveTo(Vector2d position){
        if (this.isOccupied(position)){
            return isGrass(this.objectAt(position));
        }
        return true;
    }


}






