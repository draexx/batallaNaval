package clases.InterfazBarcos;

import clases.coordenada.Coordenada;

public interface InterfazBarco {

    public boolean verificarDisparo(Coordenada disparo);
    public boolean verificarHundimiento();
}
