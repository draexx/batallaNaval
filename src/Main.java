import clases.Barco.Lancha;
import clases.Barco.Patrulla;
import clases.Barco.Portaaviones;
import clases.Barco.Submarino;
import clases.CampoBatalla.CampoBatalla;
import clases.Coordenada.Coordenada;

import java.util.Scanner;

// no necesita paquete
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int corX;
        int corY;
        Coordenada disparo;
        CampoBatalla campo = new CampoBatalla();

        //barco 1
        Portaaviones portaAviones = new Portaaviones(true);
        //barco 2
        Submarino submarino = new Submarino(false);
        //barco 3 patrulla
        Patrulla patrulla = new Patrulla(true);
        //barco 4 lancha
        Lancha lancha = new Lancha(false);
        //agregamos los barcos
        campo.agregarBarco(portaAviones);
        campo.agregarBarco(submarino);
        campo.agregarBarco(patrulla);
        campo.agregarBarco(lancha);

        campo.mostrarBarcos();
        while(!(patrulla.verificarHundimiento() && lancha.verificarHundimiento() && portaAviones.verificarHundimiento() && submarino.verificarHundimiento())){
            System.out.println("Genera posX");
            corX = t.nextInt();
            System.out.println("Genera posY");
            corY = t.nextInt();
            disparo = new Coordenada(corX,corY);
            System.out.println("Disparo fue en"+ disparo);
            campo.disparar(disparo);
        }
    }
}
