package Bomberman;

public class Enemigo extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.matarBomberman();
    }

    @Override
    public void explote(Celda celda, Juego juego) {
        celda.setItem(new Vacio());
    }

    @Override
    public boolean hayEnemigo(){
        return true;
    }


}
