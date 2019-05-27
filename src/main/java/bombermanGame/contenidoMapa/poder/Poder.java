package bombermanGame.contenidoMapa.poder;

import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoder;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.Item;
import bombermanGame.contenidoMapa.escenario.Vacio;

public abstract class Poder extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr)  throws Exception{
        juego.setPosicionBomberman(coordenadaAIr);
        juego.darPoderABomberman(this);
        juego.setItemEnCeldaBomberman(new Vacio());
    }

    public abstract EstadoPoder crearEstadoPoder();

    @Override
    public boolean hayPoder(){ return true;}

    @Override
    public boolean hayPoderLanzarBombas(){return false;}

    @Override
    public boolean hayPoderSaltarPared(){return false;}

    @Override
    public boolean hayPoderSaltarYLanzar(){return false;}

    @Override
    public boolean hayPoderSoltarVariasBombas(){return false;}

}

