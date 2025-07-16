package clases.campobatalla;

import clases.barco.Barco; // Importar la clase base Barco
import clases.coordenada.Coordenada;
// import clases.interfazbarcos.InterfazBarco; // Ya no es necesario si usamos Barco directamente

import java.util.ArrayList;
import java.util.HashSet; // Importar HashSet
import java.util.Set;     // Importar Set

public class CampoBatalla {
    private Coordenada ultimoDisparo; // Renombrado para mayor claridad

    // private Coordenada coordenadas; // Atributo no utilizado, eliminado.

    private ArrayList<Barco> barcosEnCampo; // Cambiado a ArrayList<Barco> y renombrado

    private Integer dimension = 10; // Dimensión por defecto del campo de batalla, inicializada.

    private Set<Coordenada> disparosRealizados; // Cambiado a Set<Coordenada>

    /**
     * Constructores de la clase
     */
    public CampoBatalla() {
        barcosEnCampo = new ArrayList<Barco>();
        disparosRealizados = new HashSet<Coordenada>();
        // this.dimension ya está inicializada a 10
    }

    public CampoBatalla(Integer dimension){
        this.dimension = dimension; // Establecer la dimensión
        barcosEnCampo = new ArrayList<Barco>();
        disparosRealizados = new HashSet<Coordenada>();
    }

    /**
     * Metodo que devuelve los disparos realizados
     * @return Conjunto de disparos Realizados
     */
    public Set<Coordenada> getDisparosRealizados() {
        return disparosRealizados;
    }

    /**
     * Metodo para asignar el conjunto de disparos realizados (generalmente no necesario si se gestiona internamente)
     * @param disparosRealizados de tipo Set
     */
    public void setDisparosRealizados(Set<Coordenada> disparosRealizados) {
        this.disparosRealizados = disparosRealizados;
    }

    public Coordenada getUltimoDisparo() {
        return ultimoDisparo;
    }

    public void setUltimoDisparo(Coordenada ultimoDisparo) {
        this.ultimoDisparo = ultimoDisparo;
    }

    public ArrayList<Barco> getBarcosEnCampo() { // Actualizado el tipo de retorno y nombre
        return barcosEnCampo;
    }

    public void setBarcosEnCampo(ArrayList<Barco> barcosEnCampo) { // Actualizado el tipo de parámetro y nombre
        this.barcosEnCampo = barcosEnCampo;
    }

    public Integer getDimension() {
        if (this.dimension == null) { // Asegurar que dimensión tenga un valor
            this.dimension = 10; // Valor por defecto si no se estableció
        }
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    // Eliminado getCoordenadas y setCoordenadas (atributo 'coordenadas' fue eliminado)

    /**
     * Metodo para agregar barcos en campo.
     * El barco ya debe tener sus coordenadas generadas antes de ser agregado,
     * o se generan aquí.
     * @param barco parametro de tipo Barco para agregar al campo
     */
    public void agregarBarco(Barco barco){ // Tipo de parámetro cambiado a Barco
        // Es crucial que el barco tenga sus coordenadas generadas.
        // Lo haremos aquí para asegurar consistencia, usando la dimensión del campo.
        barco.generarCoordenadas(this.getDimension());
        this.barcosEnCampo.add(barco);
    }

    public void disparar(Coordenada coordenadaDisparo) {
        this.setUltimoDisparo(coordenadaDisparo); // Guardar el último disparo

        if (disparosRealizados.contains(coordenadaDisparo)) {
            System.out.println("Disparo repetido en " + coordenadaDisparo + ". Intenta de nuevo.");
            return; // No procesar más si el disparo es repetido
        }

        disparosRealizados.add(coordenadaDisparo);
        System.out.println("Disparando a: " + coordenadaDisparo);

        boolean impactoDetectado = false;
        for (Barco barco : barcosEnCampo) {
            if (barco.verificarDisparo(coordenadaDisparo)) {
                impactoDetectado = true;
                // El método verificarDisparo en Barco ya imprime "¡Tocado!"
                if (barco.verificarHundimiento()) {
                    // El método verificarHundimiento en Barco ya imprime "¡Barco hundido!"
                    System.out.println("El " + barco.getTipo() + " ha sido completamente hundido.");
                }
                break; // Asumimos que una coordenada solo puede impactar un barco (o una parte de un barco)
            }
        }

        if (!impactoDetectado) {
            System.out.println("Agua. Ningún barco impactado en " + coordenadaDisparo);
        }
    }

    public void mostrarBarcos(){ // Renombrado barcosEnCampo
        for (Barco barco : barcosEnCampo){ // Uso de for-each y tipo Barco
            System.out.println(barco.toString()); // Llamada explícita a toString() por claridad
        }
    }

    /**
     * Verifica si todos los barcos en el campo de batalla han sido hundidos.
     * @return true si todos los barcos están hundidos, false en caso contrario.
     */
    public boolean todosHundidos() {
        if (barcosEnCampo.isEmpty()) {
            return false; // No hay barcos, así que no pueden estar todos hundidos.
        }
        for (Barco barco : barcosEnCampo) {
            if (!barco.verificarHundimiento()) {
                return false; // Si al menos un barco no está hundido, entonces no todos están hundidos.
            }
        }
        return true; // Todos los barcos están hundidos.
    }

    public String dibujarTablero(boolean mostrarBarcos) {
        char[][] tablero = inicializarTablero();
        
        if (mostrarBarcos) {
            colocarBarcos(tablero);
        }
        
        marcarDisparos(tablero);
        
        return convertirTableroAString(tablero);
    }

    private char[][] inicializarTablero() {
        char[][] tablero = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tablero[i][j] = '~';
            }
        }
        return tablero;
    }

    private void colocarBarcos(char[][] tablero) {
        for (Barco barco : barcosEnCampo) {
            for (Coordenada c : barco.getCoordenadas()) {
                if (c != null) {
                    tablero[c.getPosY()][c.getPosX()] = 'B';
                }
            }
        }
    }

    private void marcarDisparos(char[][] tablero) {
        for (Coordenada disparo : disparosRealizados) {
            if (esImpacto(disparo)) {
                tablero[disparo.getPosY()][disparo.getPosX()] = 'X';
            } else {
                tablero[disparo.getPosY()][disparo.getPosX()] = 'O';
            }
        }
    }

    private boolean esImpacto(Coordenada disparo) {
        for (Barco barco : barcosEnCampo) {
            if (barco.fueImpactadoEn(disparo)) {
                return true;
            }
        }
        return false;
    }

    private String convertirTableroAString(char[][] tablero) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(tablero[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
