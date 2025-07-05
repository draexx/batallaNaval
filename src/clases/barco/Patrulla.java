package clases.barco;

public class Patrulla extends Barco {
    
    private static final Integer TAMANIO_PATRULLA = 2;

    public Patrulla(boolean direccion) {
        super(TAMANIO_PATRULLA, direccion);
    }

    @Override
    public String getTipo() {
        return "Patrulla";
    }

    public static Integer getTamanioPatrulla() {
        return TAMANIO_PATRULLA;
    }
}
