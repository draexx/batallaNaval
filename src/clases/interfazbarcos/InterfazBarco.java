package clases.interfazbarcos;

import clases.coordenada.Coordenada;

public interface InterfazBarco {

    boolean verificarDisparo(Coordenada disparo);

    boolean verificarHundimiento();
}
