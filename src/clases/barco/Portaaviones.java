package clases.barco;

public class Portaaviones extends Barco {

    private static final Integer TAMANIO_PORTAAVIONES = 4;

    public Portaaviones(boolean direccion) {
        super(TAMANIO_PORTAAVIONES, direccion);
    }

    @Override
    public String getTipo() {
        return "Portaaviones";
    }

    public static Integer getTamanioPortaaviones() {
        return TAMANIO_PORTAAVIONES;
    }
}
