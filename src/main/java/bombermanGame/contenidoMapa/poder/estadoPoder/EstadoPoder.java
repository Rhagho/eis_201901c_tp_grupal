package bombermanGame.contenidoMapa.poder.estadoPoder;

import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.Item;

public abstract class EstadoPoder {

    public void accionBomba(Juego juego){}

    public boolean noTieneNingunPoder(){return false;}

    public boolean tienePoderLanzarBombas(){return false;}

    public boolean tienePoderSaltarPared(){return false;}

    public boolean tienePoderSaltarYLanzarBombas(){return this.tienePoderSaltarPared() && this.tienePoderLanzarBombas();}

    public void moverme(Item item , Juego juego, Coordinate hacia)  throws Exception{
        item.bombermanSeMueve(juego,hacia);
    }

}
