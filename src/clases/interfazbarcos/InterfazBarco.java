package clases.interfazbarcos;

import clases.coordenada.Coordenada;

public interface InterfazBarco {

    public boolean verificarDisparo(Coordenada disparo);

    public boolean verificarHundimiento();
}
