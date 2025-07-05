package clases.barco;

public class Submarino extends Barco {
    
    private static final Integer TAMANIO_SUBMARINO = 3;

    public Submarino(boolean direccion) {
        super(TAMANIO_SUBMARINO, direccion);
    }
    
    @Override
    public String getTipo() {
        return "Submarino";
    }

    public static Integer getTamanioSubmarino() {
        return TAMANIO_SUBMARINO;
    }
}
