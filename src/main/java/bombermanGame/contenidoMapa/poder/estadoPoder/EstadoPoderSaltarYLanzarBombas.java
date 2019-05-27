package bombermanGame.contenidoMapa.poder.estadoPoder;

import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.Item;

public class EstadoPoderSaltarYLanzarBombas extends EstadoPoderLanzarBombas {

    public EstadoPoderSaltarYLanzarBombas(int alcance, int velocidadExplosion){
        super(alcance,velocidadExplosion);
    }

    @Override
    public boolean tienePoderSaltarPared(){return true;}

    @Override
    public boolean tienePoderLanzarBombas(){return true;}

    @Override
    public void moverme(Item item , Juego juego, Coordinate hacia) {
        item.saltarPared(juego,hacia);
    }


}
