package bombermanGame.contenidoMapa.poder;

import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoder;
import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoderSaltarPared;

public class PoderSaltarPared extends Poder{

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSaltarPared();
    }

    @Override
    public boolean hayPoderSaltarPared(){return true;}
}
