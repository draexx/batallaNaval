package clases.barco;

import clases.coordenada.Coordenada;
import clases.interfazbarcos.InterfazBarco;
import java.util.Random;

public abstract class Barco implements InterfazBarco {

    protected Integer tamanio;
    protected Integer resistencia;
    protected boolean direccion; // true para horizontal, false para vertical
    protected Coordenada[] coordenadas;

    public Barco(Integer tamanio, boolean direccion) {
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.coordenadas = new Coordenada[tamanio];
        this.resistencia = tamanio; // La resistencia inicial es igual al tamaño
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

    // Este método debe ser llamado después de que el barco es creado por una subclase.
    // Opcionalmente, podría ser llamado desde el constructor de CampoBatalla al agregar el barco.
    public void generarCoordenadas(int dimensionMaximaCampo) {
        Random random = new Random();
        int startPos;
        // Asegura que el barco quepa completamente dentro del tablero
        if (direccion) { // Horizontal
            // La coordenada X puede ir de 0 a dimensionMaximaCampo - tamaño
            startPos = random.nextInt(dimensionMaximaCampo - tamanio + 1);
            int fixedY = random.nextInt(dimensionMaximaCampo);
            for (int i = 0; i < tamanio; i++) {
                coordenadas[i] = new Coordenada(startPos + i, fixedY);
            }
        } else { // Vertical
            // La coordenada Y puede ir de 0 a dimensionMaximaCampo - tamaño
            startPos = random.nextInt(dimensionMaximaCampo - tamanio + 1);
            int fixedX = random.nextInt(dimensionMaximaCampo);
            for (int i = 0; i < tamanio; i++) {
                coordenadas[i] = new Coordenada(fixedX, startPos + i);
            }
        }
    }

    @Override
    public boolean verificarDisparo(Coordenada disparo) {
        for (int i = 0; i < this.getCoordenadas().length; i++) {
            if (this.getCoordenadas()[i] != null && this.getCoordenadas()[i].equals(disparo)) {
                // Podríamos marcar la coordenada como 'tocada' si quisiéramos un estado más granular
                this.resistencia--;
                System.out.println("¡Tocado en " + disparo + "! Resistencia restante: " + this.resistencia);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verificarHundimiento() {
        boolean hundido = this.resistencia <= 0;
        if (hundido) {
            System.out.println("¡Barco de tamaño " + this.tamanio + " hundido!");
        }
        return hundido;
    }

    // Método para obtener el nombre del tipo de barco, útil para mensajes.
    // Las subclases pueden sobrescribirlo.
    public String getTipo() {
        return "Barco Genérico";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTipo()).append(" de tamaño ").append(tamanio);
        sb.append(" en [");
        for (int i = 0; i < coordenadas.length; i++) {
            if (coordenadas[i] != null) {
                sb.append(coordenadas[i].toString());
            } else {
                sb.append("N/A");
            }
            if (i < coordenadas.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("], Dirección: ").append(direccion ? "Horizontal" : "Vertical");
        sb.append(", Resistencia: ").append(resistencia);
        return sb.toString();
    }
}
