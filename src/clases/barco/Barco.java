package clases.barco;

import clases.coordenada.Coordenada;
import java.util.Random;

public class Barco  {
    
    private Integer tamanio;

    private Integer resistencia;

    private boolean direccion;
    
    private Coordenada[] coordenadas;

    public Barco(Integer tamanio, boolean direccion) {
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.coordenadas = new Coordenada[tamanio];

    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Coordenada[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void generarBarco(Integer dimension){
        Random r = new Random();
        Integer pos = r.nextInt(dimension);
        while(pos + tamanio > dimension){
            pos= r.nextInt(dimension);
        }
        //Horizontal
        if (this.direccion){
            for (int i=pos, j=0;i< pos+tamanio;i++,j++){
                coordenadas[j] = new Coordenada(i,pos);
            }
        }else{
            for (int i=pos, j=0;i< pos+tamanio;i++,j++){
                coordenadas[j] = new Coordenada(pos,i);
            }
        }
    }

    // verificar disparo
    public boolean verificarDisparo(Coordenada disparo){
        boolean acerto = false;
        for (int i = 0; i < this.getCoordenadas().length;i++){
            if (this.getCoordenadas()[i].equals((disparo))){
                System.out.println("Acerto");
                this.resistencia--;
                acerto = true;
                break;
            }else{
                System.out.println("fallaste");
            }
        }
        return acerto;
    }

    //verifica hundimiento
    public boolean verificaHundimiento(){
        return this.resistencia == 0;
    }
}
