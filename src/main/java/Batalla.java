import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;

public  class Batalla {

    
        private static Batalla instancia;
        private Jugador local;
        private Jugador remoto;
        private Protocolo protocolo;
        
        public static Batalla getOrCreate() {
            if (instancia == null) {
                instancia = new Batalla();
            }
            return instancia;
        }

        private Batalla() {
            local = new Jugador(Color.red);
            remoto = new Jugador(Color.green);
            protocolo = null;
        }

        public Jugador getLocal() {
            return local;
        }

        public Jugador getRemoto() {
            return remoto;
        }

        public Protocolo getProtocolo() {
            return protocolo;
        }

        public void setProtocolo(Protocolo protocolo) {
            this.protocolo = protocolo;
        }

        public void enviarPiezasInicial() {
            protocolo.enviarMensaje(Protocolo.PIEZAS,local.toString());
        }



    }



