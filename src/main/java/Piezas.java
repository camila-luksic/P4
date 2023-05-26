import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Iterator;

public class Piezas <E>implements Iterable<E> {
    private static Logger logger = LogManager.getRootLogger();
    private Nodo<E> raiz;
    private int tamano = 20;
    private int width = 800;
    private int height = 600;
    private int mita = width / 2;


    public Piezas(Nodo<E> raiz ) {
        raiz = null;
    }


    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(raiz.getX(), raiz.getY(),o);
        Nodo raiz = null;
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
        nuevo.obtenerCoordenadas();
        logger.info("Agrego las 7 piezas a cada lado");
        raiz.notify();

    }


    public void agregar(E o) {
        if (raiz == null) {
            insertar(o);
            return;
        }
        Nodo<E> actual = raiz;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Nodo<E> nuevo = new Nodo<>(actual.getX(), actual.getY(),o);
        actual.setSiguiente(nuevo);
        logger.info("Agrego una sola pieza a cada lado");

    }

    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = raiz;
        while (actual != null) {
            resultado.append(actual).append(" --> ");
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new PiezasIterators(raiz);
    }


    class Nodo<E> {
        private int x;
        private int y;
        private int vida = 3;
        private E contenido;

        private Nodo<E> siguiente;


        public Nodo(int x, int y,E o) {
            contenido=o;
            this.x = x;
            this.y = y;
            siguiente = null;
        }

        public int[] obtenerCoordenadas() {
            int[] coordenadas = {x, y};
            return coordenadas;
        }

        public int getVida() {
            return vida;
        }

        public void setVida(int vida) {
            this.vida = vida;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        protected void matar() {
            vida = 0;
        }


        public Piezas<E>.Nodo<E> getSiguiente() {
            return (Piezas<E>.Nodo<E>) siguiente;
        }


        public void setSiguiente(Nodo raiz) {
        }

        public boolean contiene(int x, int y) {
            if (x == getX() &&
                    y == getY()) {
                return true;
            } else {
                return false;
            }
        }



    }

    private class PiezasIterators implements Iterator<E> {
        private Nodo<E> actual;
        public PiezasIterators(Nodo<E> r) {
            actual = r;
        }

            public boolean hasNext() {
                return actual != null;
            }

            public E next() {
                E obj = (E) actual.obtenerCoordenadas();
                actual = actual.getSiguiente();
                return obj;
            }

        }


    }




