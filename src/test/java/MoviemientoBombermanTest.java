import bombermanGame.*;
import bombermanGame.contenidoMapa.Mapa;
import bombermanGame.contenidoMapa.direccion.*;
import bombermanGame.contenidoMapa.enemigo.Enemigo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoviemientoBombermanTest extends TestCase {
    private Mapa mapa;
    private Juego juego;
    @Before
    public void setUp(){

        this.juego = new Juego();
        this.mapa = this.juego.getMapa();

    }


    @Test
    public void testBombermanSeMueveAlNorte() {
        Direction direction = new North();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlNorte = direction.giveNextCoordinate(posicionBomberman);

        this.juego.moverBomberman(direction);

        Assert.assertEquals(coordendaAlNorte,this.juego.getPosicionBomberman());
    }

    @Test
    public void testBombermanSeMueveAlSur(){
        Direction direction = new South();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlSur = direction.giveNextCoordinate(posicionBomberman);

        this.juego.moverBomberman(direction);

        Assert.assertEquals(coordendaAlSur,this.juego.getPosicionBomberman());
    }

    @Test
    public void testBombermanSeMueveAlEste() {
        Direction direction = new East();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlEste = direction.giveNextCoordinate(posicionBomberman);

        this.juego.moverBomberman(direction);

        Assert.assertEquals(coordendaAlEste,this.juego.getPosicionBomberman());
    }

    @Test
    public void testBombermanSeMueveAlOeste() {
        Direction direction = new West();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlOeste = direction.giveNextCoordinate(posicionBomberman);

        this.juego.moverBomberman(direction);

        Assert.assertEquals(coordendaAlOeste,this.juego.getPosicionBomberman());
    }

    @Test
    public void testBombermanMuereAlMoverseAlNorteHabiendoEnemigo() throws Exception{

        Direction direction = new North();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlNorte = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlNorte);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanMuereAlMoverseAlSurHabiendoEnemigo() throws Exception{

        Direction direction = new South();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlSur = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlSur);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanMuereAlMoverseAlEsteHabiendoEnemigo() throws Exception{

        Direction direction = new East();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlEste = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlEste);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanMuereAlMoverseAlOesteHabiendoEnemigo() throws Exception {

        Direction direction = new West();


        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlOeste = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlOeste);
        this.juego.moverBomberman(direction);

        assertTrue(this.juego.getBomberman().siEstaMuerto());
    }

    @Test
    public void testBombermanSeMueveAlOesteYCambiaSuPosicionPeroLuegoAlMoverseAlOesteOtraVezEsteNoCambiaSuPosicionAlQuererSalirDelMapa(){
        Direction direction = new West();
        Coordinate oldCoord = this.juego.getPosicionBomberman();
        this.juego.moverBomberman(direction);
        assertNotSame(oldCoord,this.juego.getPosicionBomberman());

        oldCoord = this.juego.getPosicionBomberman();
        this.juego.moverBomberman(direction);
        assertEquals(oldCoord,this.juego.getPosicionBomberman());
    }
}