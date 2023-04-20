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

    /**
     *
     * @param disparosRealizados
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
        /*if (this.barcoEnCampo.add(barco)){
            return "Se agrego barco";
        }else{
            return "no Se agrego barco";
        }*/
        this.barcoEnCampo.add(barco);
    }
    public void disparar(Coordenada disparo){
        this.disparo = disparo;
        Boolean disp = false;
        if (this.getDisparosRealizados().size() == 0){
            this.getDisparosRealizados().add(disparo);
            disp = true;
        }else{
            for (int i =0; i< this.getDisparosRealizados().size();i++){
                if(getDisparo().equals(this.getDisparosRealizados().get(i))){
                    System.out.println("Ya existe el disparo");
                    disp = false;
                    break;
                }else{
                    System.out.println("Nuevo disparo");
                    this.getDisparosRealizados().add(disparo);
                    disp = true;
                    break;
                }
            }
            // nuestra verificacion

        }
    }
}
