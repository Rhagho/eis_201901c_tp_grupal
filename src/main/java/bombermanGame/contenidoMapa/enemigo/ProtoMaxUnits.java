package bombermanGame.contenidoMapa.enemigo;

import bombermanGame.contenidoMapa.escenario.Celda;
import bombermanGame.Juego;
import bombermanGame.contenidoMapa.poder.Poder;
import bombermanGame.contenidoMapa.poder.PoderSaltarYLanzar;

public class ProtoMaxUnits extends Enemigo {
        private Poder poder;

        public ProtoMaxUnits() {
            this.poder = new PoderSaltarYLanzar();
        }

        @Override
        public void explote(Celda celda, Juego juego) {
            celda.setItem(this.poder);
        }
    }