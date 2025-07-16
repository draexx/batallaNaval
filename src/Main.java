import clases.barco.Lancha;
import clases.barco.Patrulla;
import clases.barco.Portaaviones;
import clases.barco.Submarino;
import clases.campobatalla.CampoBatalla;
import clases.coordenada.Coordenada;

import java.util.Scanner;

/**
 * Clase principal para ejecutar el juego de Batalla Naval.
 */
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int corX;
        int corY;
        Coordenada coordenadaDisparo;

        // Crear campo de batalla con dimensión 10x10
        CampoBatalla campo = new CampoBatalla(10);
        System.out.println("Campo de batalla de " + campo.getDimension() + "x" + campo.getDimension() + " creado.");

        // Crear y agregar barcos al campo.
        // La generación de coordenadas se maneja ahora dentro de campo.agregarBarco()
        Portaaviones portaAviones = new Portaaviones(true); // true para horizontal
        Submarino submarino = new Submarino(false);       // false para vertical
        Patrulla patrulla = new Patrulla(true);
        Lancha lancha = new Lancha(false);

        campo.agregarBarco(portaAviones);
        campo.agregarBarco(submarino);
        campo.agregarBarco(patrulla);
        campo.agregarBarco(lancha);

        System.out.println("\nBarcos desplegados en el campo de batalla:");
        campo.mostrarBarcos();
        System.out.println("\n¡Comienza la batalla!");

        while (!campo.todosHundidos()) {
            System.out.println("\n--- Nuevo Turno ---");
            System.out.println(campo.dibujarTablero(true));
            System.out.print("Ingrese coordenada X para el disparo: ");
            corX = t.nextInt();
            System.out.print("Ingrese coordenada Y para el disparo: ");
            corY = t.nextInt();
            coordenadaDisparo = new Coordenada(corX, corY);

            campo.disparar(coordenadaDisparo); // El método disparar ahora maneja los mensajes
        }

        System.out.println("\n¡Felicidades! Todos los barcos han sido hundidos. Has ganado la batalla.");
        t.close();
    }
}
