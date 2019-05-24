package Bomberman;

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

    public void moverABomberman(Juego juego, Coordinate hacia) {
        this.item.bombermanSeMueve(juego, hacia);
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

    public void explotar() {
        this.item.explote(this);
    }
}