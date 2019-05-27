package bombermanGame.contenidoMapa.direccion;

public class East extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.incrementX();
    }

    @Override
    public Coordinate giveNextCoordinate(Coordinate coordinate){
        Coordinate newCoordinate = new Coordinate(coordinate.getX(),coordinate.getY());
        newCoordinate.incrementX();
        return newCoordinate;
    }
}
