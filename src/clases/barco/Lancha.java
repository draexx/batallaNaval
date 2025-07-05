package clases.barco;

// Ya no necesita importar Coordenada directamente si no la usa explícitamente aquí
// Ya no necesita importar InterfazBarco porque la hereda de Barco
// Ya no necesita importar Random

public class Lancha extends Barco {
    
    private static final Integer TAMANIO_LANCHA = 1;

    public Lancha(boolean direccion) {
        // Llama al constructor de la clase base (Barco)
        // pasando el tamaño específico de la Lancha y la dirección.
        super(TAMANIO_LANCHA, direccion);
        // La generación de coordenadas se hará desde CampoBatalla o Main,
        // pasando la dimensión del campo.
        // this.generarCoordenadas(dimensionDelCampo); // Esto se llamará externamente
    }

    // Los métodos generarBarco (ahora generarCoordenadas), verificarDisparo,
    // y verificarHundimiento son heredados de la clase Barco.
    // Ya no es necesario reimplementarlos aquí si la lógica es la misma.

    // Opcional: Sobrescribir getTipo() para dar un nombre específico.
    @Override
    public String getTipo() {
        return "Lancha";
    }

    // Los getters y setters para direccion, coordenadas, resistencia
    // son heredados de Barco (si se hicieron protected o public).
    // Si eran private en Barco y se necesitan aquí, Barco debe proveer getters/setters protected.
    // En nuestro caso, eran 'private' en el Barco original, y los hicimos 'protected' en el nuevo Barco.
    // El getter para TAMANIO_LANCHA (si es necesario externamente)
    public static Integer getTamanioLancha() {
        return TAMANIO_LANCHA;
    }
}
