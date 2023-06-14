package clases.coordenada;

//import java.util.Objects;

public class Coordenada {
    
    private Integer posX;
    private Integer posY;

    /**
     * Metodo que recibe 2 parametros, estos recibiran como argumentos "x" y "y" de una
     * coordenada
     * @param posX
     * @param posY
     */
    public Coordenada(Integer posX, Integer posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Metodo que devuelve la posicion X
     * @return Entero que equivale a la posicion X
     */
    public Integer getPosX() {
        return posX;
    }

    /**
     * Metodo que recibe un valor entero para asignar valor a la coordenada X
     * @param posX valor entero que se asignara a la posicion X
     */
    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Coordenada{" + "posX=" + posX + ", posY=" + posY + '}';
    }

    @Override
    public boolean equals(Object coordenada) {
        /*if (coordenada instanceof Coordenada){
            Coordenada objeto = new Coordenada();
            objeto = (Coordenada) coordenada;
            if(objeto.getPosX()== this.posX && objeto.getPosY() == this.posY){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }*/
        if ((coordenada instanceof Coordenada) && ( ((Coordenada) coordenada).getPosX() == this.posX  &&  ((Coordenada) coordenada).getPosY() == this.posY)){
            return true;
        }else{
            return false;
        }
    }
}
