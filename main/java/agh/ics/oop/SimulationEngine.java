package agh.ics.oop;


public class SimulationEngine implements IEngine{
    public MoveDirection[] moves;
    public IWorldMap map;
    public Vector2d[] positions;


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        this.positions = positions;

        for (Vector2d position : positions) {
            map.place(new Animal(map, position));
        }
    }

    public void run() {
        RectangularMap map1 = (RectangularMap) map;
        int len = map1.animals.size();
        int i = 0;
        for (MoveDirection move : moves){
            if(move==null){
                return;
            }
            map1.animals.get(i%len).move(move);
            i+=1;
        }

    }
}
