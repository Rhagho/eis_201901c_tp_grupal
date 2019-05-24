package Bomberman;

public class South extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.decrementY();
    }

    @Override
    public Coordinate giveNextCoordinate(Coordinate coordinate){
        Coordinate newCoordinate = new Coordinate(coordinate.getX(),coordinate.getY());
        newCoordinate.decrementY();
        return newCoordinate;
    }
}