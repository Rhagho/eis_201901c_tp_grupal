package gradle.cucumber;

import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class MovimientoBombermanTest extends TestCase {
    private Mapa mapa;
    private Juego juego;
    @Before
    public void setUp(){

        this.juego = new Juego();
        this.mapa = this.juego.getMapa();

    }

    @Test
    public void testBombermanMuereAlMoverseAlNorteHabiendoEnemigo(){

        Direction direction = new North();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlNorte = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlNorte);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanMuereAlMoverseAlSurHabiendoEnemigo(){

        Direction direction = new South();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlSur = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlSur);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanMuereAlMoverseAlEsteHabiendoEnemigo(){

        Direction direction = new East();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlEste = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlEste);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanMuereAlMoverseAlOesteHabiendoEnemigo(){

        Direction direction = new West();


        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlOeste = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlOeste);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }
}