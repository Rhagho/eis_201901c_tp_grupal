package Bomberman;

public class West extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.decrementX();
    }

    @Override
    public Coordinate giveNextCoordinate(Coordinate coordinate){
        Coordinate newCoordinate = new Coordinate(coordinate.getX(),coordinate.getY());
        newCoordinate.decrementX();
        return newCoordinate;
    }
}
