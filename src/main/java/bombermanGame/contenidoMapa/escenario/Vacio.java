package bombermanGame.contenidoMapa.escenario;

import bombermanGame.contenidoMapa.Item;
import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.Juego;

public class Vacio extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.setPosicionBomberman(coordenadaAIr);
    }

    @Override
    public boolean estaVacio() {
        return true;
    }
    @Override
    public void explote(Celda celda, Juego juego){

    }
}
