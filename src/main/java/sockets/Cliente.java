package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    private final File directorioProyecto1;
    private final File directorioProyecto2;

    public Cliente(File directorioProyecto1, File directorioProyecto2) {
        this.directorioProyecto1 = directorioProyecto1;
        this.directorioProyecto2 = directorioProyecto2;
    }
    
    public void IniciarCliente() {
        final String HOST = "127.0.0.1";
        final int PUERTO_SERVER = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, PUERTO_SERVER);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            Envio envio = new Envio(directorioProyecto1, directorioProyecto2, out);
            envio.enviar();
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
