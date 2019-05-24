package Bomberman;

public class Bomba {

    private Coordinate coordenada;
    private Juego juego;
    private int ticks;

    public Bomba(Coordinate posicionBomba, Juego juego) {
        this.coordenada = posicionBomba;
        this.juego = juego;
        this.ticks = 3;
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
}