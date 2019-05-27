package Bomberman;

public class Vivo extends EstadoSalud {

    @Override
    public boolean siEstaMuerto(){return false;}

    @Override
    public void morir(Bomberman b){b.setEstadoSalud(new Muerto());}

    @Override
    public void accionBomba(Juego juego,EstadoPoder miPoder) {
        miPoder.accionBomba(juego);
    }

    @Override
    public void obtenerPoder(Bomberman b,EstadoPoder estadoPoder){
        b.setEstadoPoder(estadoPoder);
    }

    @Override
    public boolean noTieneNingunPoder(EstadoPoder miPoder){return miPoder.noTieneNingunPoder();}

    @Override
    public boolean tienePoderLanzarBombas(EstadoPoder miPoder){return miPoder.tienePoderLanzarBombas();}

    @Override
    public boolean tienePoderSaltarPared(EstadoPoder miPoder){return miPoder.tienePoderSaltarPared();}

    @Override
    public boolean tienePoderSaltarYLanzarBombas(EstadoPoder miPoder){return miPoder.tienePoderSaltarYLanzarBombas();}

    @Override
    public void moverse(EstadoPoder miPoder,Item item, Juego juego, Coordinate hacia) throws Exception{
        miPoder.moverme(item,juego,hacia);
    }

    @Override
    public Direction cambiarDondeMira(Direction dir){return dir;}
}
