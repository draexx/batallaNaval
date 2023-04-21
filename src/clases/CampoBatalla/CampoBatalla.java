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
     * Constructores de la clase
     */
    public CampoBatalla() {
        barcoEnCampo = new ArrayList<Barco>();
        disparosRealizados = new ArrayList<Coordenada>();
    }

    public CampoBatalla(Integer dimension){
        this.setDimension(dimension);
    }
    /**
     * Metodo que devuelve los disparos realizados
     * @return Lista de disparos Realizados
     */
    public ArrayList<Coordenada> getDisparosRealizados() {
        return disparosRealizados;
    }

    /**
     * Metodo para asignar el disparo realizado
     * @param disparosRealizados de tipo ArrayList
     */
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

    public void agregarBarco(Barco barco){
        this.barcoEnCampo.add(barco);
    }
    public void disparar(Coordenada disparo){
        this.disparo = disparo;
        boolean acierto = false;
        boolean nuevoDisparo = true;
        if (this.getDisparosRealizados().size() == 0){
            this.getDisparosRealizados().add(disparo);
            acierto = true;
        }else{
            for(int i =0; i< this.getDisparosRealizados().size();i++){
                if(getDisparo().equals(this.getDisparosRealizados().get(i))){
                    System.out.println("Ya existe el disparo");
                    nuevoDisparo = false;
                    break;
                }
            }
            if(nuevoDisparo){
                System.out.println("Nuevo disparo");
                this.getDisparosRealizados().add(disparo);
                acierto = true;
            }
        }
        // verificacion disparo
        if (acierto){

        }
    }
}
