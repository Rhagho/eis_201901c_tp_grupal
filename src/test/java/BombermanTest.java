import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class BombermanTest extends TestCase {

    private Juego juego;
    @Before
    public void setUp(){

        this.juego = new Juego();

    }

    @Test
    public void testWhenBombermanInCoordinate1x1yMovesToTheNorthenCellHisNewCoordinateIs1x2y(){

        this.juego.moverBomberman(new North());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(1,2));
    }


    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheSouthernCellHisNewCoordinateIs1x0y(){
        this.juego.moverBomberman(new South());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(1,0));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheEasternCellHisNewCoordinateIs2x1y(){
        this.juego.moverBomberman(new East());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(2,1));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheWesternCellHisNewCoordinateIs0x1y(){

        this.juego.moverBomberman(new West());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(0,1));
    }

}