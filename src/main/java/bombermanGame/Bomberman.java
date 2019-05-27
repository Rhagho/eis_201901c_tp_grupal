package bombermanGame;

import bombermanGame.contenidoMapa.Item;
import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.contenidoMapa.direccion.Direction;
import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoder;
import bombermanGame.contenidoMapa.poder.estadoPoder.EstadoPoderNoPuedeNada;
import bombermanGame.estadoSalud.EstadoSalud;
import bombermanGame.estadoSalud.Vivo;

public class Bomberman {

    private EstadoSalud estadoSalud;
    private EstadoPoder miPoder ;

    public Bomberman () {
        this.miPoder = new EstadoPoderNoPuedeNada();
        this.estadoSalud = new Vivo();

    }

    public boolean siEstaMuerto() {
        return this.estadoSalud.siEstaMuerto();
    }

    public void morir() {
        this.estadoSalud.morir(this);
    }

    public void accionBomba(Juego juego) {

        this.estadoSalud.accionBomba(juego,miPoder);

    }
    public void obtenerPoder(EstadoPoder estadoPoder){
        this.estadoSalud.obtenerPoder(this, estadoPoder);
    }

    public boolean noTieneNingunPoder(){
        return this.estadoSalud.noTieneNingunPoder(this.miPoder);
    }

    public boolean tienePoderLanzarBombas(){return this.estadoSalud.tienePoderLanzarBombas(miPoder);}

    public boolean tienePoderSaltarPared(){return this.estadoSalud.tienePoderSaltarPared(miPoder);}

    public boolean tienePoderSaltarYLanzarBombas(){return estadoSalud.tienePoderSaltarYLanzarBombas(miPoder);}


    public void moverse(Item item, Juego juego, Coordinate hacia) throws Exception{
            estadoSalud.moverse(miPoder,item,juego,hacia);
    }

    public Direction cambiarDondeMira(Direction dir){
       return estadoSalud.cambiarDondeMira(dir);
    }

    public void setEstadoSalud(EstadoSalud estadoNuevo){
        this.estadoSalud = estadoNuevo;
    }
    public void setEstadoPoder(EstadoPoder estadoPoderNuevo){
        this.miPoder = estadoPoderNuevo;
    }
}
