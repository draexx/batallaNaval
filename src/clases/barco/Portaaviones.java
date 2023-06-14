package clases.barco;

import clases.coordenada.Coordenada;
import clases.InterfazBarcos.InterfazBarco;
import java.util.Random;

public class Portaaviones implements InterfazBarco {

    private final Integer TAMANIO = 4;
    private boolean direccion;
    private Coordenada[] coordenadas;
    private Integer resistencia = TAMANIO;

    public Portaaviones(boolean direccion) {
        this.direccion = direccion;
        this.coordenadas = new Coordenada[this.TAMANIO];
        this.generarBarco();
    }

    public void generarBarco(){
        Random r = new Random();
        Integer pos = r.nextInt(TAMANIO);
        while(pos + TAMANIO > 10){
            pos= r.nextInt(10);
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
    @Override
    public boolean verificarDisparo(Coordenada disparo) {
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

    @Override
    public boolean verificarHundimiento() {
        return this.resistencia == 0;
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
}
