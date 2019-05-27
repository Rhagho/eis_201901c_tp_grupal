package bombermanGame.contenidoMapa.poder;

import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoder;
import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoderSaltarYLanzarBombas;

public class PoderSaltarYLanzar extends Poder {

    private int alcance;
    private int velocidadExplosion;

    public PoderSaltarYLanzar(){

        alcance = 4;
        velocidadExplosion = 4;
    }

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSaltarYLanzarBombas(alcance,velocidadExplosion);
    }

    @Override
    public boolean hayPoderSaltarYLanzar(){return true;}

}
