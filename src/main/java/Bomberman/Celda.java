package Bomberman;

import java.util.List;

public class Celda {

    private Item item;
    private Coordinate coordenada;

    public Celda(Coordinate coordenada){
        this.item = new Vacio();
        this.coordenada = coordenada;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void moverABomberman(Juego juego, Coordinate hacia)  throws Exception{
        juego.getBomberman().moverse(this.item,juego,hacia);
    }

    public boolean esLaCoordenadaCorrecta(Coordinate c) {
        int x1 = coordenada.getX();
        int y1 = coordenada.getY();
        int x2 = c.getX();
        int y2 = c.getY();
        boolean result = coordenada.getX() == (c.getX()) && coordenada.getY() == (c.getY());
        return result;
    }

    public boolean estaEnElRadio(Coordinate c, int radio) {
        return this.calcularRadio(c.getX(), this.coordenada.getX(), radio) && this.calcularRadio(c.getX(), this.coordenada.getX(), radio);
    }

    private boolean calcularRadio(int eje, int ejeMio, int radio) {
        return Math.abs(eje - ejeMio) <= radio;
    }

    public boolean estaVacio() {
        return this.item.estaVacio();
    }

    public void explotar(Juego juego) {
        this.item.explote(this,juego);
    }

    public boolean estaEnElSegmento(List<Coordinate> segmento){

        return segmento.contains(this.coordenada);
    }

    public Coordinate getCoordenada(){
        return this.coordenada;
    }

    public boolean hayPoder(){ return this.item.hayPoder();}

    public boolean hayPoderLanzarBombas(){return this.item.hayPoderLanzarBombas();}

    public boolean hayPoderSaltarPared(){return this.item.hayPoderSaltarPared();}

    public boolean hayPoderSaltarYLanzar(){return this.item.hayPoderSaltarYLanzar();}

    public boolean hayEnemigo(){return this.item.hayEnemigo();}

}
