package clases.CampoBatalla;

import clases.Barco.Barco;
import clases.Coordenada.Coordenada;

import java.util.ArrayList;

public class CampoBatalla {
    private Coordenada disparo;
    private ArrayList<Barco> barcoEnCampo;
    private Integer dimension;
    private Coordenada coordenadas;
    private ArrayList<Coordenada> disparosRealizados;

    /**
     * Constructor de la clase
     */
    public CampoBatalla() {
        barcoEnCampo = new ArrayList<Barco>();
        disparosRealizados = new ArrayList<Coordenada>();
    }

    /**
     * Metodo que devuelve los disparos realizados
     * @return Lista de disparos Realizados
     */
    public ArrayList<Coordenada> getDisparosRealizados() {
        return disparosRealizados;
    }

    public void setDisparosRealizados(ArrayList<Coordenada> disparosRealizados) {
        this.disparosRealizados = disparosRealizados;
    }

    public Coordenada getDisparo() {
        return disparo;
    }

    public void setDisparo(Coordenada disparo) {
        this.disparo = disparo;
    }

    public ArrayList<Barco> getBarcoEnCampo() {
        return barcoEnCampo;
    }

    public void setBarcoEnCampo(ArrayList<Barco> barcoEnCampo) {
        this.barcoEnCampo = barcoEnCampo;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
}
