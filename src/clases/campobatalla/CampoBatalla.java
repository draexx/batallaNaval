package clases.campobatalla;

import clases.coordenada.Coordenada;
import clases.interfazbarcos.InterfazBarco;

import java.util.ArrayList;

public class CampoBatalla {
    private Coordenada disparo;

    private Coordenada coordenadas;

    private ArrayList<InterfazBarco> barcoEnCampo;

    private Integer dimension;

    private ArrayList<Coordenada> disparosRealizados;

    /**
     * Constructores de la clase
     */
    public CampoBatalla() {
        barcoEnCampo = new ArrayList<InterfazBarco>();
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
     * @param disparoRealizado de tipo ArrayList
     */
    public void setDisparosRealizados(ArrayList<Coordenada> disparoRealizado) {
        this.disparosRealizados = disparoRealizado;
    }

    public Coordenada getDisparo() {
        return disparo;
    }

    public void setDisparo(Coordenada disparo) {
        this.disparo = disparo;
    }

    public ArrayList<InterfazBarco> getBarcoEnCampo() {
        return barcoEnCampo;
    }

    public void setBarcoEnCampo(ArrayList<InterfazBarco> barcoEnCampo) {
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

    /**
     * Metodo para agregar barcos en campo
     * @param barco parametro de tipo Barco para agregar al campo
     */
    public void agregarBarco(InterfazBarco barco){
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
                for (int i = 0; i<barcoEnCampo.size();i++){
                    if(barcoEnCampo.get(i).verificarDisparo(this.getDisparo())){
                        if (this.barcoEnCampo.get(i).verificarHundimiento()){
                            System.out.println("Se hundio");
                        }
                        System.out.println("acerto");
                        break;
                    }else{
                        System.out.println("fallaste");
                    }

                }
        }else{
            System.out.println("nose verifico porque ya existe");
        }
    }

    public void mostrarBarcos(){
        for (int i=0;i<barcoEnCampo.size();i++){
            System.out.println(barcoEnCampo.get(i));
        }
    }
}
