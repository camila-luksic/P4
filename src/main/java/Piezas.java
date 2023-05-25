import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;

public class Piezas <E>implements Iterable<E> {
    
    private  int x1;
    private int y1;

    private int x2;
    private int y2;
   private int vida=3;

    public Piezas(int x,int y , int vida){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.vida=vida;
    }

    public int getX1() {

        return x1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2(){
         return y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    /*
    public void insertar(E o){
        Nodo<E> nuevo=new Nodo<> (o);
        nuevo.setSiguiente(raiz);
        raiz=nuevo;
        E contiene = nuevo.contiene;
        logger.info("Agrego las 7 piezas a cada lado");

    }
        public void agregar (E o){
            if (raiz == null) {
                insertar(o);
                return;
            }
            Nodo<E> actual = raiz;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            Nodo<E> nuevo = new Nodo<>(o);
            actual.setSiguiente(nuevo);
            logger.info("Agrego una sola pieza a cada lado");
            paint1();
        }
     *//*
        public String toString () {
            StringBuilder resultado = new StringBuilder();
            Nodo<E> actual = raiz;
            while (actual != null) {
                resultado.append(actual).append(" --> ");
                actual = actual.getSiguiente();
            }
            return resultado.toString();
        }

*/

    @Override
    public Iterator <E> iterator() {
        NodoPelotita raiz = null;
        return new PiezasIterator<>(raiz) {
        };
    }


    class NodoPelotita<E> {
        public Object contiene;

        private Piezas pelotita;
        private NodoPelotita siguiente;


        public NodoPelotita(Piezas pelotita) {
            this.pelotita=pelotita;
            siguiente = null;
        }
        protected void matar(){
            vida=0;
        }

        public Piezas getPelotita() {
            return pelotita;
        }

        public void setPelotita(Piezas pelotita) {
            this.pelotita = pelotita;
        }
        public NodoPelotita getSiguiente(){
            return siguiente;
        }

        public void setSiguiente(NodoPelotita siguiente) {
            this.siguiente=siguiente;
        }

        public boolean contiene(int x, int y) {
            return false;
        }
    }

    class PiezasIterator<E> implements Iterator<E> {
        private NodoPelotita actual;

        public PiezasIterator(NodoPelotita r) {
            actual = r;
        }

        public boolean hasNext() {
            return actual != null;
        }

        public E next() {
            E obj = (E) actual.contiene;
            actual = actual.getSiguiente();
            return obj;
        }

    }
}

