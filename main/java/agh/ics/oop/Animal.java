package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "orientation=" + orientation +
                ", position=" + position ;
    }
    public void move(MoveDirection direction){
        switch (direction){
            case LEFT :
                this.orientation = this.orientation.previous();
                break;
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case FORWARD:
                Vector2d unitVector = this.orientation.toUnitVector();
                if (this.position.add(unitVector).precedes(new Vector2d(4,4))
                        && this.position.add(unitVector).follows(new Vector2d(0,0))){
                    this.position = this.position.add(unitVector);
                }
                break;
            case BACKWARD:
                Vector2d unitVector1 = this.orientation.toUnitVector();
                if (this.position.subtract(unitVector1).precedes(new Vector2d(4,4))
                        && this.position.subtract(unitVector1).follows(new Vector2d(0,0))){
                    this.position = this.position.subtract(unitVector1);
                }
                break;
        }
    }



}
