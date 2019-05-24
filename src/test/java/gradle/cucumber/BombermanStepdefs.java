package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Bomberman.*;

import java.util.List;

import static org.junit.Assert.*;


public class BombermanStepdefs {

    private Bomberman bomberman;
    private Coordinate oldCoordinate;
    private Juego juego;
    private Mapa mapa;
    private List<Celda> celdasAlRededorDeAlgo;

    @Given("^Un Juego con bomberman en una celda")
    public void crearJuegoMapaConBombermanEnUnaCeldaInicial(){
        juego = new Juego();
        bomberman = this.juego.getBomberman();
        mapa = this.juego.getMapa();
        oldCoordinate = this.cloneCoordinate(this.juego.getPosicionBomberman());
    }

    @When("^Bomberman se mueve hacia la celda vacia (Este|Oeste|Sur|Norte)")
    public void bombermanSeMueveHaciaLaCeldaVaciaNorte(String dirString) {
        Direction actualDirection = this.castDirection(dirString);
        this.juego.moverBomberman(actualDirection);
    }

    @Then("^Bomberman cambia su posicion")
    public void bombermanCambiaSuPosicion() {
        Coordinate positionNow = this.juego.getPosicionBomberman();

        assertNotEquals(oldCoordinate,positionNow);
    }

    @When("^Bomberman intenta moverse al (Este|Oeste|Sur|Norte) habiendo una pared$")
    public void bombermanIntentaMoverseAlNorteHabiendoUnaPared(String dirString) throws Throwable {
        Direction dir = this.castDirection(dirString);
        this.colocarUnItemYMoverloAUnaDireccion(dir, new Pared());
    }

    @Then("^Bomberman se queda en el lugar$")
    public void bombermarEstaEnLaPosicionPasada() throws Throwable {
        assertEquals(this.oldCoordinate, this.juego.getPosicionBomberman());
    }

    @When("^Bomberman intenta moverse al Norte habiendo un enemigo$")
    public  void bombermanIntentaMoverseAlNorteHabiendoEnemigo() throws  Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new North(), new Enemigo());
    }

    @Then("^Bomberman muere$")
    public void bombermanEstaMuerto() throws  Throwable {
        assertTrue(this.bomberman.siEstaMuerto());
    }

    @When("^Bomberman pone una bomba rodeado de paredes de melamina$")
    public void bombermanPoneUnaBombaYEstaRodeadoDeParadesDeMelamina() throws  Throwable {
        this.bombermanPoneBombaYEstaRodeadoDe(new Pared());
    }

    @And("^Pasa \"([^\"]*)\" ticks$")
    public void pasan3Ticks(String integerValue) throws Throwable {
        this.juego.correnNTicks(Integer.parseInt(integerValue));
    }

    @Then("^La Bomba explota dejando vacio las celdas en un radio de 3 casilleros$")
    public void lasParedesDeLaminaNoExistenMas() throws Throwable {
        assertTrue(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());
    }

    @When("^Bomberman pone una bomba rodeado de enemigos$")
    public void bombermanPoneUnaBombaYEstaRodeadoDeEnemigos() throws Throwable {
        this.bombermanPoneBombaYEstaRodeadoDe(new Enemigo());
    }

    @When("^Bomberman pone una bomba rodeada de paredes de acero$")
    public void bomberPoneUnaBombaYEstaRodeadoDeParedesDeAcero() throws  Throwable {
        this.bombermanPoneBombaYEstaRodeadoDe(new ParedAcero());
    }

    @Then("^La Bomba explota sin romper esas paredes de acero$")
    public void noSeRompeNingunaParedDeAcero() throws  Throwable {
        assertFalse(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());

    }

    private void bombermanPoneBombaYEstaRodeadoDe(Item item) {
        Coordinate posicionActual = this.juego.getPosicionBomberman();
        this.mapa.colocarItemAlRededorDe(item, posicionActual);
        this.celdasAlRededorDeAlgo = this.mapa.getCeldasAlRededorDe(posicionActual);

        assertFalse(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());

        this.juego.bombermanPonerBomba();
    }

    private boolean checkearSiLasCeldasAlRededorDeAlgoEstanVacias() {
        return this.celdasAlRededorDeAlgo.stream().allMatch( c -> c.estaVacio());
    }
    private void colocarUnItemYMoverloAUnaDireccion(Direction direccion, Item item) {
        Coordinate posicionActual = this.juego.getPosicionBomberman();
        this.oldCoordinate = posicionActual;
        this.mapa.colocarItem(item, direccion.giveNextCoordinate(posicionActual));
        this.juego.moverBomberman(direccion);
    }

    private Coordinate cloneCoordinate(Coordinate actual) {
        return new Coordinate(actual.getX(),actual.getY());
    }

    private Coordinate getExpectedCoordinate(String direction,Coordinate actual) {
        switch(direction) {
            case "Norte":
                Coordinate res = this.cloneCoordinate(actual);
                res.incrementY();
                return res;
            case "Sur":
                Coordinate res2 = this.cloneCoordinate(actual);
                res2.decrementY();
                return res2;
            case "Este":
                Coordinate res3 = this.cloneCoordinate(actual);
                res3.incrementX();
                return res3;
            case "Oeste":
                Coordinate res4 = this.cloneCoordinate(actual);
                res4.decrementX();
                return res4;
            default:
                throw new IllegalArgumentException("Solo Norte,Sur,Este,y Oeste son direcciones validas");
        }
    }

    private Direction castDirection(String direccion) {
        switch(direccion) {
            case "Norte":
                return new North();
            case "Sur":
                return new South();
            case "Este":
                return new East();
            case "Oeste":
                return new West();
            default:
                throw new IllegalStateException("Unexpected value: " + direccion);
        }
    }


    @When("^Bomberman intenta moverse al Sur habiendo un enemigo$")
    public void bombermanIntentaMoverseAlSurHabiendoUnEnemigo() throws  Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new South(), new Enemigo());
    }

    @When("^Bomberman intenta moverse al Este habiendo un enemigo$")
    public void bombermanIntentaMoverseAlEsteHabiendoUnEnemigo() throws  Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new East(), new Enemigo());
    }

    @When("^Bomberman intenta moverse al Oeste habiendo un enemigo$")
    public void bombermanIntentaMoverseAlOesteHabiendoUnEnemigo() throws  Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new West(), new Enemigo());
    }
}