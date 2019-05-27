package bombermanGame.contenidoMapa.direccion;

public class North extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.incrementY();
    }

    @Override
    public Coordinate giveNextCoordinate(Coordinate coordinate){
        Coordinate newCoordinate = new Coordinate(coordinate.getX(),coordinate.getY());
        newCoordinate.incrementY();
        return newCoordinate;
    }
}
