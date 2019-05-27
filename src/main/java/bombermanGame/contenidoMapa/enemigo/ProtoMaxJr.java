package bombermanGame.contenidoMapa.enemigo;

import bombermanGame.contenidoMapa.escenario.Celda;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.poder.Poder;
import bombermanGame.contenidoMapa.poder.PoderSaltarPared;

public class ProtoMaxJr extends Enemigo {
    private Poder poder;

    public ProtoMaxJr() {
        this.poder = new PoderSaltarPared();
    }

    @Override
    public void explote(Celda celda, Juego juego) {
        celda.setItem(this.poder);
    }
}
