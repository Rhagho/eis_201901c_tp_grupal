package bombermanGame.contenidoMapa.enemigo;

import bombermanGame.contenidoMapa.escenario.Celda;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.poder.Poder;
import bombermanGame.contenidoMapa.poder.PoderLanzarBombas;

public class Bagulaa extends Enemigo {

    private Poder poder;

    public Bagulaa(){
        this.poder = new PoderLanzarBombas();
    }

    @Override
    public void explote(Celda celda, Juego juego) {
        celda.setItem(this.poder);
    }
}
