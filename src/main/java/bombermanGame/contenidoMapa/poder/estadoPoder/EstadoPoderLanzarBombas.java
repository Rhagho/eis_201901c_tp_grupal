package bombermanGame.contenidoMapa.poder.estadoPoder;

import bombermanGame.Juego;

public class EstadoPoderLanzarBombas extends EstadoPoder{

    private int alcance;
    private int velocidadExplosion;

    public EstadoPoderLanzarBombas(int alcance,int velocidadExplosion){
        this.alcance = alcance;
        this.velocidadExplosion = velocidadExplosion;
    }

    @Override
    public void accionBomba(Juego juego){
        juego.bombermanLanzaUnaBomba(alcance,velocidadExplosion);
    }

    @Override
    public boolean tienePoderLanzarBombas(){return true;}
}
