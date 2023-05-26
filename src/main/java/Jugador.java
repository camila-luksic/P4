import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Jugador {
    private static Logger logger = LogManager.getRootLogger();
    private final Color color;
    private Piezas.Nodo raiz;
    private PropertyChangeSupport observed;
    private int tamano=20;
    private int vida=3;

    private int width=800;
    private int height=600;
    private int mita=width/2;

    public Jugador(Color c) {
        this.color = c;
        raiz = null;
        observed = new PropertyChangeSupport(this);
        notificar();
        crearPiezas();

    }

    private void crearPiezas() {
        Graphics g=null;
        Random random=new Random(1234);
        for (int i = 0; i <7 ; i++) {
            random=new Random(1234);
            int  x= random.nextInt(mita);
            int y = random.nextInt(600);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, tamano, tamano);

        }
        for (int j=0;j<7;j++) {
            int x2 = random.nextInt(mita) + mita;
            int y2 = random.nextInt(600);
        g.setColor(Color.RED);
        g.fillOval(x2, y2, tamano, tamano);


        }
    }




    public void addListener(Panel jugadorPanel) {
        observed.addPropertyChangeListener(jugadorPanel);
    }

    public void notificar() {
        observed.firePropertyChange("JUEGO", true, false);
        if (raiz == null){
            crearPiezas();
            paint();
        }else
        cambiarcolor();
    }

    public boolean matoPieza(int x, int y) {
        int vida = 3;
        for (int i = 0; i < 7; i++) {
            if (raiz.contiene(x, y)) {
                vida--;
                raiz.notify();
                if (vida == 0) {
                    raiz.matar();
                    return true;
                }
            }
        }
            return false;
        }


    private void cambiarcolor() {
        Graphics g=null;
        if (vida==3){
            g.setColor(color);
        }
            if (vida == 2) {
                g.setColor(Color.GRAY);
            }
            if (vida == 1) {
                g.setColor(Color.BLACK);
            }
            if (vida==0){
                g.setColor(Color.WHITE);
                raiz.matar();
            }
        }

    public void paint() {

    }
}




