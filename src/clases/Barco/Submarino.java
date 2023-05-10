package clases.Barco;

import clases.Coordenada.Coordenada;
import clases.InterfazBarcos.interfazBarco;

import java.util.Random;

public class Submarino implements interfazBarco {
    private final Integer TAMANIO = 3;
    private boolean direccion;
    private Coordenada[] coordenadas;
    private Integer resistencia = TAMANIO;

    public Submarino(boolean direccion) {
        this.direccion = direccion;
        this.coordenadas = new Coordenada[this.TAMANIO];
        this.generarBarco(TAMANIO);
    }

    public void generarBarco(Integer dimension){
        Random r = new Random();
        Integer pos = r.nextInt(TAMANIO);
        while(!(pos + TAMANIO <= dimension)){
            pos= r.nextInt(dimension);
        }
        //Horizontal
        if (this.direccion){
            for (int i=pos, j=0;i< pos+TAMANIO;i++,j++){
                coordenadas[j] = new Coordenada(i,pos);
            }
        }else{
            for (int i=pos, j=0;i< pos+TAMANIO;i++,j++){
                coordenadas[j] = new Coordenada(pos,i);
            }
        }
    }
    public Integer getTAMANIO() {
        return TAMANIO;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public Coordenada[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public boolean verificarDisparo(Coordenada disparo) {
        return false;
    }

    @Override
    public boolean verificarHundimiento() {
        return false;
    }
}
