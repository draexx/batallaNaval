# Batalla Naval

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/30c54f580c47462aafdc2cf41469adea)](https://app.codacy.com/gh/draexx/batallaNaval/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
<a href="https://codeclimate.com/github/draexx/batallaNaval/maintainability"><img src="https://api.codeclimate.com/v1/badges/da78d80d0ad72896b86f/maintainability" /></a>

Este es un sencillo juego de Batalla Naval implementado en Java, ejecutado en la consola. El objetivo es hundir todos los barcos del oponente (en este caso, barcos colocados aleatoriamente en un tablero).

## Descripción del Juego

El juego se desarrolla en un tablero de 10x10. Se despliegan varios tipos de barcos:
* Portaaviones (tamaño 4)
* Submarino (tamaño 3)
* Patrulla (tamaño 2)
* Lancha (tamaño 1)

Los jugadores introducen coordenadas (X, Y) para disparar a los barcos. El juego informa si el disparo fue "Agua", "Tocado" o si un barco ha sido "Hundido". El juego termina cuando todos los barcos han sido hundidos.

## Cómo Compilar

El proyecto utiliza una estructura de directorios estándar de Java. Para compilar el juego:

1. Asegúrate de tener un JDK (Java Development Kit) instalado.
2. Navega a la raíz del repositorio en tu terminal.
3. Crea un directorio para los archivos compilados (por ejemplo, `out`):
    ```bash
    mkdir -p out/production/batallaNaval
    ```

4. Compila los archivos Java:
    ```bash
    find src -name "*.java" > sources.txt
    javac -d out/production/batallaNaval @sources.txt
    ```
    O, si prefieres compilar manualmente cada paquete (aunque `find` es más robusto):
    ```bash
    # Ejemplo (ajusta según sea necesario si la estructura de paquetes cambia)
    # javac -d out/production/batallaNaval src/clases/coordenada/*.java src/clases/interfazbarcos/*.java src/clases/barco/*.java src/clases/campobatalla/*.java src/Main.java
    ```

## Cómo Ejecutar

Una vez compilado, puedes ejecutar el juego desde la raíz del proyecto:

```bash
java -cp out/production/batallaNaval Main
```

El juego te pedirá que introduzcas las coordenadas X e Y para cada disparo.

## Nota Importante

* **Superposición de Barcos:** Actualmente, existe la posibilidad de que los barcos se superpongan al ser generados aleatoriamente en el tablero. Esta es una limitación conocida del estado actual del juego y no fue abordada en la refactorización reciente, ya que requeriría implementar una lógica de validación de posiciones más compleja.

## Contribuir

¡Las contribuciones son bienvenidas! Si deseas mejorar el juego, por favor considera hacer un fork del repositorio y enviar un Pull Request. Algunas áreas de mejora podrían ser:
* Implementar una interfaz gráfica.
* Añadir un modo de dos jugadores.
* Solucionar el problema de superposición de barcos.
* Añadir tests unitarios.
