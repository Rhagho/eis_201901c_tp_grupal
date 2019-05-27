package bombermanGame;

import bombermanGame.contenidoMapa.direccion.Coordinate;

public class Bomba {

    private Coordinate coordenada;
    private Juego juego;
    private int ticks;

    public Bomba(Coordinate posicionBomba, Juego juego,int ticks){
        this.coordenada = posicionBomba;
        this.juego = juego;
        this.ticks = ticks;
    }

    public void decrecerTicks(int t) {
        this.ticks -= t;
        if(this.ticks <= 0) {
            this.juego.estallarBomba(this);
        }
    }

    public Coordinate getCoordenada() {
        return this.coordenada;
    }

    public boolean yaExploto(){return ticks <= 0;}
}
