package Bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapa {

    //MAPA TIENE QUE POSEER POR LO MENOS 1 CELDA
    private List<Celda> mapa; //Lista de Celdas

    //Crea un mapa por default de 5x5 con todas las celdas vacias
    public Mapa(){
        this.mapa = this.crearUnMapa(5,5);
    }

    private List<Celda> crearUnMapa(int largo,int alto){

        List<Celda> celdas = new ArrayList<Celda>();
        for(int x=0; x < largo;x++) {
            this.crearCeldasDeColumna(celdas, x, alto);
        }

        return celdas;
    }

    private void crearCeldasDeColumna(List<Celda> columna,int x,int alto){
        for(int y=0; y < alto; y++) {
            columna.add(new Celda(new Coordinate(x, y)));
        }
    }

    public Celda getCelda(Coordinate c){
        return this.mapa.stream().filter(celda -> celda.esLaCoordenadaCorrecta(c)).findFirst().get();
    }

    public void colocarItem(Item item, Coordinate coordenada) {
        this.getCelda(coordenada).setItem(item);
    }

    public void colocarItemAlRededorDe(Item item, Coordinate coordinate) {
        this.getCeldasAlRededorDe(coordinate).forEach(c -> c.setItem(item));
    }

    public List<Celda> getCeldasAlRededorDe(Coordinate coordenada) {
        return this.mapa.stream().filter(c -> c.estaEnElRadio(coordenada, 3)).collect(Collectors.toList());
    }
}