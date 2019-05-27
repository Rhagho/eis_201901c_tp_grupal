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
    private ProtoMaxJr protoMaxJr = new ProtoMaxJr();


    @Given("^Un Juego con bomberman en una celda")
    public void crearJuegoMapaConBombermanEnUnaCeldaInicial() throws Throwable{
        juego = new Juego();
        bomberman = this.juego.getBomberman();
        mapa = this.juego.getMapa();
        oldCoordinate = this.cloneCoordinate(this.juego.getPosicionBomberman());
    }

    @When("^Bomberman se mueve hacia la celda vacia (Este|Oeste|Sur|Norte)")
    public void bombermanSeMueveHaciaLaCeldaVaciaNorte(String dirString) throws Throwable {
        Direction actualDirection = this.castDirection(dirString);
        this.juego.moverBomberman(actualDirection);
    }

    @Then("^Bomberman cambia su posicion")
    public void bombermanCambiaSuPosicion() throws Throwable{
        Coordinate positionNow = this.juego.getPosicionBomberman();

        assertNotEquals(oldCoordinate,positionNow);
    }

    @And("^Bomberman se mueve hacia el (Este|Oeste|Sur|Norte)$")
    public void bombermanSeMueveHaciaCelda(String dirStr) throws Throwable{

        Direction dir = this.castDirection(dirStr);
        this.oldCoordinate = this.juego.getPosicionBomberman();
        this.juego.moverBomberman(dir);
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

    @When("^Bomberman intenta moverse al Sur habiendo un enemigo$")
    public void bombermanIntentaMoverseAlSurHabiendoUnEnemigo() throws Throwable{
        this.colocarUnItemYMoverloAUnaDireccion(new South(), new Enemigo());

    }

    @When("^Bomberman intenta moverse al Este habiendo un enemigo$")
    public void bombermanIntentaMoverseAlEsteHabiendoUnEnemigo() throws Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new East(), new Enemigo());

    }

    @When("^Bomberman intenta moverse al Oeste habiendo un enemigo$")
    public void bombermanIntentaMoverseAlOesteHabiendoUnEnemigo() throws Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new West(), new Enemigo());
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
    @And("^Esta \"([^\"]*)\" en la celda de al lado de bomberman (Este|Oeste|Sur|Norte)")
    public void estaEnemigoEnLaCeldaDeAlLadoDeBomberman(String enemigoStr,String dirStr) throws Throwable{
        Enemigo enemigo = this.castEnemigo(enemigoStr);
        Direction dir = this.castDirection(dirStr);
        this.bombermanTieneEnemigoAlLadoEnDireccion(dir,enemigo);
    }
    @When("^Bomberman deja una bomba$")
    public void bombermanPoneUnaBombaConUnTipoDeEnemigoAlLado(){
        this.juego.bombermanAccionarBomba();
    }
    @Then("^La Bomba explota donde estaba \"([^\"]*)\" soltando poder \"([^\"]*)\" en la celda (Este|Oeste|Sur|Norte)$")
    public void seMuereEnemigoYDejaCeldaConPoder(String enemigoStr,String poderStr,String dirStr) throws Throwable{
        Direction dir = this.castDirection(dirStr);
        Coordinate coordenadaDondeEstabaEnemigo = dir.giveNextCoordinate(juego.getPosicionBomberman());
        Celda celdaDondeEstabaEnemigo = this.mapa.getCelda(coordenadaDondeEstabaEnemigo);


        assertTrue(celdaDondeEstabaEnemigo.hayPoder());
        assertFalse(celdaDondeEstabaEnemigo.hayEnemigo());
        this.castAssertHayPoderEspecificoEnCelda(celdaDondeEstabaEnemigo,poderStr);

    }
    @And("^La celda (Este|Oeste|Sur|Norte) donde esta bomberman hay poder \"([^\"]*)\"$")
    public void ponerPoderEnCeldaAContinuacionBomberman(String dirStr,String poderStr) throws Throwable{
        Poder poder = this.castPoder(poderStr);
        Direction dir = this.castDirection(dirStr);
        Coordinate coordCeldaContigua = dir.giveNextCoordinate(this.juego.getPosicionBomberman());
        this.mapa.getCelda(coordCeldaContigua).setItem(poder);
    }
    @When("^Bomberman se mueve sobre esa celda (Este|Oeste|Sur|Norte)$")
    public void moverBombermanACeldaContigua(String dirStr) throws Throwable{
        Direction dir = this.castDirection(dirStr);
        this.juego.moverBomberman(dir);
    }
    @Then("^Bomberman obtiene el poder \"([^\"]*)\"$")
    public void bombermanObtieneElPoderDeseado(String poderStr) throws Throwable{

        this.castAssertBombermanTieneEstadoPoder(bomberman,poderStr);

    }

    @And("^Bomberman con poder \"([^\"]*)\"$")
    public void ponerPoderEnBomberman(String poderStr) throws Throwable{
        Poder poder = this.castPoder(poderStr);
        this.juego.darPoderABomberman(poder);

    }

    @When("^Bomberman lanza bomba mirando al (Este|Oeste|Sur|Norte)$")
    public void bombermanLanzaBombaMirandoA(String dirStr) throws Throwable{
        Direction dir = this.castDirection(dirStr);
        this.juego.setDondeMiraBomberman(dir);
        this.juego.bombermanAccionarBomba();
    }

    @And("^Luego bomberman lanza bomba mirando al (Oeste|Este|Norte|Sur)$")
    public void yBombermanLanzaBombaMirandoA(String dirStr) throws Throwable{
        Direction dir = this.castDirection(dirStr);
        this.juego.setDondeMiraBomberman(dir);
        this.juego.bombermanAccionarBomba();
    }

    @Then("^La bomba se pone \"([^\"]*)\" celdas al (Este|Oeste|Sur|Norte) de la posicion de Bomberman$")
    public void checkearQueLaBombaSePoneNCeldasAUnaDireccionDeLaPosicionDeBomberman(String cant,String dirStr){
        int longitudCeldas = Integer.parseInt(cant);
        Direction dir = this.castDirection(dirStr);
        Coordinate coordDondeEstaLaBomba = juego.getPosicionBomberman().obtenerCoordenadas(dir,longitudCeldas);

        assertTrue(this.juego.hayBombaEnCoordenada(coordDondeEstaLaBomba));

    }

    @Then("^La bomba explota$")
    public void laBombaExplota(){
       assertTrue(this.juego.noHayBombasActivas());

    }
    private void bombermanTieneEnemigoAlLadoEnDireccion(Direction dir,Enemigo enemigo) throws Exception{
        Coordinate coordDelEnemigo = dir.giveNextCoordinate(this.juego.getPosicionBomberman());
        this.mapa.colocarItem(enemigo,coordDelEnemigo);
    }

    private void bombermanPoneBombaYEstaRodeadoDe(Item item) {
        Coordinate posicionActual = this.juego.getPosicionBomberman();
        this.mapa.colocarItemAlRededorDe(item, posicionActual);
        this.celdasAlRededorDeAlgo = this.mapa.getCeldasAlRededorDe(posicionActual);


        assertFalse(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());

        this.juego.bombermanAccionarBomba();

    }

    @Then("^La bomba se pone en la celda que esta bomberman$")
    public void assertBombaSePoneEnLaCeldaQueEstaBomberman(){
        assertFalse(this.juego.noHayBombasActivas());
        assertTrue(this.juego.hayBombaEnCoordenada(this.juego.getPosicionBomberman()));
    }

    @When("^Bomberman se mueve al (Oeste|Este|Sur|Norte) habiendo \"([^\"]*)\" en la celda$")
    public void ponerItemEnCeldaAlLadoDeBobermanYBombermanSeMueveAhi(String dirStr, String tipoPared) throws Exception{
        Pared pared = this.castTipoPared(tipoPared);
        Direction dir = this.castDirection(dirStr);

        this.colocarUnItemYMoverloAUnaDireccion(dir,pared);
    }

    @Then("^Hay dos bombas una en 4 celdas al (Oeste|Sur|Este|Norte) y otra 4 celdas al (Oeste|Sur|Este|Norte) de la posicion de bomberman$")
    public void assertHayUnaBombaEnNCeldaDireccionYOtraBombaEnNCeldaDireccion(String dir1Str,String dir2Str){
        Direction dir1 = this.castDirection(dir1Str);
        Direction dir2 = this.castDirection(dir2Str);

        Coordinate coordDondeEstaLaBomba1 = juego.getPosicionBomberman().obtenerCoordenadas(dir1,4);

        Coordinate coordDondeEstaLaBomba2 = juego.getPosicionBomberman().obtenerCoordenadas(dir2,4);

        assertTrue(this.juego.hayBombaEnCoordenada(coordDondeEstaLaBomba1));
        assertTrue(this.juego.hayBombaEnCoordenada(coordDondeEstaLaBomba2));
    }

    @And("^Bomberman deja bomba$")
    public void bombermanDejaBomba(){
        this.juego.bombermanAccionarBomba();
    }

    private boolean checkearSiLasCeldasAlRededorDeAlgoEstanVacias() {
        return this.celdasAlRededorDeAlgo.stream().allMatch( c -> c.estaVacio());
    }

    @Then("^Hay una bomba en la posicion anterior de bomberman y otra bomba en la posicion actual$")
    public void assertHayBombaEnLaPosicionAnteriorBombermanYOtraEnLaPosicionActual(){
        assertTrue(this.juego.hayBombaEnCoordenada(this.oldCoordinate));
        assertTrue(this.juego.hayBombaEnCoordenada(juego.getPosicionBomberman()));
    }

    @Then("^La bomba del (Este|Sur|Oeste|Norte) explota y una esta en 4 celdas al (Oeste|Este|Sur|Norte) de la posicion de bomberman$")
    public void assertUnaBombaExplotaYOtraEstaEn4CeldasAlEsteDeLaPosicionDeBomberman(String dir1Str,String dir2Str){
        Direction dir1 = this.castDirection(dir1Str);
        Direction dir2 = this.castDirection(dir2Str);

        Coordinate coordDondeEstaLaBomba1 = juego.getPosicionBomberman().obtenerCoordenadas(dir1,4);

        Coordinate coordDondeEstaLaBomba2 = juego.getPosicionBomberman().obtenerCoordenadas(dir2,4);

        assertFalse(this.juego.hayBombaEnCoordenada(coordDondeEstaLaBomba1));
        assertTrue(this.juego.hayBombaEnCoordenada(coordDondeEstaLaBomba2));
    }

    @Then("^En la posicion anterior de bomberman la bomba exploto y la otra bomba sigue en la posicion actual$")
    public void assertUnaBombaExplotoYOtraEstaEnLaPosicionActualDeBomberman(){
        assertFalse(this.juego.hayBombaEnCoordenada(this.oldCoordinate));
        assertTrue(this.juego.hayBombaEnCoordenada(juego.getPosicionBomberman()));
    }

    @And("^Bomberman esta muerto$")
    public void bombermanMuere(){
        this.juego.matarBomberman();
    }

    @When("^Bomberman se muere$")
    public void bombermanSeMuere(){
        this.bombermanMuere();
    }

    @Then("^Bomberman no tiene ningun estadoDePoder")
    public void bombermanNoTieneNingunEstadoDePoder(){
        assertFalse(bomberman.noTieneNingunPoder());
        assertFalse(bomberman.tienePoderSaltarYLanzarBombas());
        assertFalse(bomberman.tienePoderSaltarPared());
        assertFalse(bomberman.tienePoderLanzarBombas());
    }

    @Then("^No hay ninguna bomba activa$")
    public void noHayNingunaBombaActiva(){
        assertTrue(juego.noHayBombasActivas());
    }

    @And("^Bomberman mira al (Norte|Sur|Este|Oeste)$")
    public void bombermanCambiarDondeMira(String dirStr){
        Direction dir = this.castDirection(dirStr);
        juego.setDondeMiraBomberman(dir);
    }

    @Then("^La direccion donde mira bomberman es null$")
    public void assertNullDondeMiraBomberman(){
        assertNull(juego.getDondeMiraBomberman());
    }

    private void colocarUnItemYMoverloAUnaDireccion(Direction direccion, Item item) throws Exception{
        Coordinate posicionActual = this.juego.getPosicionBomberman();
        this.oldCoordinate = posicionActual;
        this.mapa.colocarItem(item, direccion.giveNextCoordinate(posicionActual));
        this.juego.moverBomberman(direccion);
    }

    private Coordinate cloneCoordinate(Coordinate actual) {
        return new Coordinate(actual.getX(),actual.getY());
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

    private Enemigo castEnemigo(String enemigo) {
        switch(enemigo) {
            case "Enemigo":
                return new Enemigo();
            case "Bagulaa":
                return new Bagulaa();
            case "ProtoMaxJr":
                return new ProtoMaxJr();
            case "ProtoMaxUnits":
                return new ProtoMaxUnits();
            default:
                throw new IllegalStateException("Unexpected value: " + enemigo);
        }
    }

    private Poder castPoder(String poder) {
        switch(poder) {
            case "lanzarBombas":
                return new PoderLanzarBombas();
            case "saltarPared":
                return new PoderSaltarPared();
            case "saltarYLanzar":
                return new PoderSaltarYLanzar();
            default:
                throw new IllegalStateException("Unexpected value: " + poder);
        }
    }

    private void castAssertHayPoderEspecificoEnCelda(Celda celda,String poderStr){

        switch(poderStr) {
            case "lanzarBombas":
                assertTrue(celda.hayPoderLanzarBombas());
                break;
            case "saltarPared":
                assertTrue(celda.hayPoderSaltarPared());
                break;
            case "saltarYLanzar":
                assertTrue(celda.hayPoderSaltarYLanzar());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + poderStr);
        }

    }


    private void castAssertBombermanTieneEstadoPoder(Bomberman bomberman, String poderStr) {

        switch(poderStr) {
            case "lanzarBombas":
                assertTrue(bomberman.tienePoderLanzarBombas());
                assertFalse(bomberman.noTieneNingunPoder());
                assertFalse(bomberman.tienePoderSaltarPared());
                assertFalse(bomberman.tienePoderSaltarYLanzarBombas());
                break;
            case "saltarPared":
                assertFalse(bomberman.tienePoderLanzarBombas());
                assertFalse(bomberman.noTieneNingunPoder());
                assertTrue(bomberman.tienePoderSaltarPared());
                assertFalse(bomberman.tienePoderSaltarYLanzarBombas());
                break;
            case "saltarYLanzar":
                assertTrue(bomberman.tienePoderLanzarBombas());
                assertFalse(bomberman.noTieneNingunPoder());
                assertTrue(bomberman.tienePoderSaltarPared());
                assertTrue(bomberman.tienePoderSaltarYLanzarBombas());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + poderStr);
        }
    }

    private Pared castTipoPared(String paredStr){
        switch(paredStr) {
            case "paredNormal":
                return new Pared();
            case "paredAcero":
                return new ParedAcero();
            default:
                throw new IllegalStateException("Unexpected value: " + paredStr);
        }
    }
}
