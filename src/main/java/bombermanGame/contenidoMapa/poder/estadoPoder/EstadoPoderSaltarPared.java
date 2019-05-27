package bombermanGame.contenidoMapa.poder.estadoPoder;

import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.Item;

public class EstadoPoderSaltarPared extends EstadoPoder {


    @Override
    public void accionBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }

    @Override
    public boolean tienePoderSaltarPared(){return true;}

    @Override
    public void moverme(Item item , Juego juego, Coordinate hacia) {
        item.saltarPared(juego,hacia);
    }
}
