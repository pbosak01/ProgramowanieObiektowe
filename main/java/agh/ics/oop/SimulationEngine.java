package agh.ics.oop;


public class SimulationEngine implements IEngine{
    public MoveDirection[] moves;
    public IWorldMap map;
    public Vector2d[] positions;
    private int quantity=0;


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        this.positions = positions;

        for (Vector2d position : positions) {
            if(map.place(new Animal(map, position))){
                quantity +=1;
            };
        }
    }

    public void run() {
        GrassField map1 = (GrassField) map;
        int i = 0;
        for (MoveDirection move : moves){
            if(move==null){
                return;
            }
            map1.animals.get(i%this.quantity).move(move);
            i+=1;
        }

    }
}
