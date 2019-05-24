package Bomberman;

public abstract class Item {
    public abstract void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr);

    public void explote(Celda celda) {
        celda.setItem(new Vacio());
    }

    public boolean estaVacio() {
        return false;
    }
}