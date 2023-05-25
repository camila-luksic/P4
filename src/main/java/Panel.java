import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Panel extends JPanel implements PropertyChangeListener,MouseListener {
    private static Logger logger = LogManager.getRootLogger();
    private Jugador modelo;


    public Panel(boolean esLocal) {
        modelo = null;
        if (!esLocal) {
            this.addMouseListener(this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null) {
            modelo.paint();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    public Jugador getModelo() {
        return modelo;
    }

    public void setModelo(Jugador modelo) {
        this.modelo = modelo;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Batalla main= Batalla.getOrCreate();
        String msg = e.getX() + "," + e.getY();
        main.getProtocolo()
                .enviarMensaje(Protocolo.DISPARO,
                        msg);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

