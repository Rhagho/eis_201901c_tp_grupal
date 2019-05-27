package bombermanGame.contenidoMapa.poder.estadoPoder;

import bombermanGame.Juego;

public class EstadoPoderNoPuedeNada extends EstadoPoder {

    @Override
    public void accionBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }

    @Override
    public boolean noTieneNingunPoder(){return true;}
}
