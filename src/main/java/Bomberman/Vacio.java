package Bomberman;

public class Vacio extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.setPosicionBomberman(coordenadaAIr);
    }

    @Override
    public boolean estaVacio() {
        return true;
    }
}