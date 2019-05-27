package bombermanGame.contenidoMapa;

import bombermanGame.contenidoMapa.ExcepcionTeFuisteDelMapa;
import bombermanGame.contenidoMapa.Item;
import bombermanGame.contenidoMapa.direccion.Coordinate;
import bombermanGame.contenidoMapa.direccion.Direction;
import bombermanGame.contenidoMapa.escenario.Celda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapa {

    //MAPA TIENE QUE POSEER POR LO MENOS 1 CELDA
    private List<Celda> mapa; //Lista de Celdas

    //Crea un mapa por default de 10x10 con todas las celdas vacias
    public Mapa(){
        this.mapa = this.crearUnMapa(10,10);
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

    public Celda getCelda(Coordinate c) throws ExcepcionTeFuisteDelMapa {
        try{
            return this.mapa.stream().filter(celda -> celda.esLaCoordenadaCorrecta(c)).findFirst().get();
        }catch (Exception e){
            throw new ExcepcionTeFuisteDelMapa();
        }
    }

    public void colocarItem(Item item, Coordinate coordenada) throws Exception{
        this.getCelda(coordenada).setItem(item);
    }

    public void colocarItemAlRededorDe(Item item, Coordinate coordinate) {
        this.getCeldasAlRededorDe(coordinate).forEach(c -> c.setItem(item));
    }

    public List<Celda> getCeldasAlRededorDe(Coordinate coordenada) {
        return this.mapa.stream().filter(c -> c.estaEnElRadio(coordenada, 3)).collect(Collectors.toList());
    }

    public List<Celda> getSegmentoDeCeldas(Direction dir, Coordinate inicio, int longitud){

        List<Coordinate> segmento = this.getSegmento(dir,inicio,longitud);

        return this.mapa.stream().filter(c -> c.estaEnElSegmento(segmento)).collect(Collectors.toList());
    }

    public List<Coordinate> getSegmento(Direction dir,Coordinate inicio,int longitud){
        List<Coordinate> coordinates = new ArrayList<Coordinate>();

        Coordinate nextCoord = inicio;

        //REFACTOR CUANDO SE PUEDA
        for(int i=0;i <= longitud;i++){

            coordinates.add(nextCoord);

            nextCoord = dir.giveNextCoordinate(nextCoord);
        }

        return coordinates;
    }

    public Celda obtenerCeldaMasLejanaDelSegmento(Coordinate inicio,List<Celda> celdas){
        //REFACTOR SI SE PUEDE

        Celda celdaMasLejana = celdas.get(0);
        int longitudMasLarga = celdaMasLejana.getCoordenada().longitudCon(inicio);

        int longTmp;

        for(Celda c : celdas){
            longTmp = c.getCoordenada().longitudCon(inicio);
            if(longTmp > longitudMasLarga){
                longitudMasLarga = longTmp ;
                celdaMasLejana = c;
            }

        }

        return celdaMasLejana;
    }
}
