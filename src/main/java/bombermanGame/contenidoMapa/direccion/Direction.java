package bombermanGame.contenidoMapa.direccion;

public abstract class Direction {
    public abstract void moveCoordinate(Coordinate coordinate);
    public abstract Coordinate giveNextCoordinate(Coordinate coordinate);

    public void moveNCoordinate(Coordinate coordinate,int cantidad){

        for(int i=0; i < cantidad;i++){
            this.moveCoordinate(coordinate);
        }

    }
}
