package gradle.cucumber;

import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BombermanSueltaBombasTest extends TestCase {
    private Mapa mapa;
    private Juego juego;

    @Before
    public void setUp() {

        this.juego = new Juego();
        this.mapa = this.juego.getMapa();

    }


    @Test
    public void testBombermanTieneEnRadioDe3CeldasAlNorte() {
        Coordinate posicionBomberman = this.juego.getPosicionBomberman();

        Direction directionN = new North();
        Coordinate coordendaAlNorte = directionN.giveNextCoordinate(posicionBomberman);

        Assert.assertTrue(this.juego.getMapa().getCelda(coordendaAlNorte).estaEnElRadio(posicionBomberman, 3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionN.giveNextCoordinate(coordendaAlNorte)).estaEnElRadio(posicionBomberman, 3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionN.giveNextCoordinate(directionN.giveNextCoordinate(coordendaAlNorte))).estaEnElRadio(posicionBomberman, 3));
        Assert.assertFalse(this.juego.getMapa().getCelda(directionN.giveNextCoordinate(directionN.giveNextCoordinate(directionN.giveNextCoordinate(coordendaAlNorte)))).estaEnElRadio(posicionBomberman,3));
    }

    @Test
    public void testBombermanTieneEnRadioDe3CeldasAlSur() {
        this.juego.setPosicionBomberman(new Coordinate(1,5));
        Coordinate posicionBomberman = this.juego.getPosicionBomberman();


        Direction directionS = new South();
        Coordinate coordendaAlSur = directionS.giveNextCoordinate(posicionBomberman);

        Assert.assertTrue(this.juego.getMapa().getCelda(coordendaAlSur).estaEnElRadio(posicionBomberman, 3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionS.giveNextCoordinate(coordendaAlSur)).estaEnElRadio(posicionBomberman, 3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionS.giveNextCoordinate(directionS.giveNextCoordinate(coordendaAlSur))).estaEnElRadio(posicionBomberman, 3));
        Assert.assertFalse(this.juego.getMapa().getCelda(directionS.giveNextCoordinate(directionS.giveNextCoordinate(directionS.giveNextCoordinate(coordendaAlSur)))).estaEnElRadio(posicionBomberman,3));
    }

    @Test
    public void testBombermanTieneEnRadioDe3CeldasAlEste(){
        Coordinate posicionBomberman = this.juego.getPosicionBomberman();

        Direction directionE = new East();
        Coordinate coordendaAlEste = directionE.giveNextCoordinate(posicionBomberman);

        Assert.assertTrue(this.juego.getMapa().getCelda(coordendaAlEste).estaEnElRadio(posicionBomberman,3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionE.giveNextCoordinate(coordendaAlEste)).estaEnElRadio(posicionBomberman,3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionE.giveNextCoordinate(directionE.giveNextCoordinate(coordendaAlEste))).estaEnElRadio(posicionBomberman,3));
        Assert.assertFalse(this.juego.getMapa().getCelda(directionE.giveNextCoordinate(directionE.giveNextCoordinate(directionE.giveNextCoordinate(coordendaAlEste)))).estaEnElRadio(posicionBomberman,3));
    }

    @Test
    public void testBombermanTieneEnRadioDe3CeldasAlOeste(){
        this.juego.setPosicionBomberman(new Coordinate(5,1));
        Coordinate posicionBomberman = this.juego.getPosicionBomberman();

        Direction directionW = new West();
        Coordinate coordendaAlOeste = directionW.giveNextCoordinate(posicionBomberman);

        Assert.assertTrue(this.juego.getMapa().getCelda(coordendaAlOeste).estaEnElRadio(posicionBomberman,3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionW.giveNextCoordinate(coordendaAlOeste)).estaEnElRadio(posicionBomberman,3));
        Assert.assertTrue(this.juego.getMapa().getCelda(directionW.giveNextCoordinate(directionW.giveNextCoordinate(coordendaAlOeste))).estaEnElRadio(posicionBomberman,3));
        Assert.assertFalse(this.juego.getMapa().getCelda(directionW.giveNextCoordinate(directionW.giveNextCoordinate(directionW.giveNextCoordinate(coordendaAlOeste)))).estaEnElRadio(posicionBomberman,3));
    }

}
