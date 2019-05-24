
package Bomberman;

public class Enemigo extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.getBomberman().morir();
    }
}