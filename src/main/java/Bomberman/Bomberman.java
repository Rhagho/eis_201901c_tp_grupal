package Bomberman;

public class Bomberman {

    private Boolean estaVivo;

    public Bomberman () {
        this.estaVivo = true;
    }

    public boolean siEstaMuerto() {
        return !this.estaVivo;
    }

    public void morir() {
        this.estaVivo = false;
    }

    public void accionBomba(Juego juego) {
        if(this.estaVivo){
            juego.bombermanDejaUnaBomba();
        }
    }
}