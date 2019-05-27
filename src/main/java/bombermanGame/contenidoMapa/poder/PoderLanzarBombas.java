package bombermanGame.contenidoMapa.poder;

import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoder;
import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoderLanzarBombas;

public class PoderLanzarBombas extends Poder {

    private int alcance;
    private int velocidadExplosion;

    public PoderLanzarBombas(){
        this.alcance = 4;
        this.velocidadExplosion = 4;
    }

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderLanzarBombas(this.alcance,this.velocidadExplosion);
    }

    @Override
    public boolean hayPoderLanzarBombas(){return true;}

}
