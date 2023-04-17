package clases.Barco;

import clases.Coordenada.Coordenada;

public class Barco  {
    private Integer tamanio;
    private Boolean direccion;
    private Integer resistencia;
    private Coordenada[] coordenadas;

    public Barco(Integer tamanio, Boolean direccion) {
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.coordenadas = new Coordenada[tamanio];

    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Boolean getDireccion() {
        return direccion;
    }

    public void setDireccion(Boolean direccion) {
        this.direccion = direccion;
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
}
