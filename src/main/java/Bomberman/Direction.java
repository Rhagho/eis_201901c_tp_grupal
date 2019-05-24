package Bomberman;

public abstract class Direction {
    public abstract void moveCoordinate(Coordinate coordinate);
    public abstract Coordinate giveNextCoordinate(Coordinate coordinate);
}