package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente {

    private final File directorioProyecto1;
    private final File directorioProyecto2;
    private javax.swing.JFrame parent;

    public Cliente(File directorioProyecto1, File directorioProyecto2, javax.swing.JFrame parent) {
        this.directorioProyecto1 = directorioProyecto1;
        this.directorioProyecto2 = directorioProyecto2;
        this.parent = parent;
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

            //Esperando repuesta del server
            boolean seGeneroJson = in.readBoolean();
            if (seGeneroJson) {
                String contenidoJson = in.readUTF();
                Recibir recibir = new Recibir(in,this.parent);
                recibir.recibirArchivo(contenidoJson);
            } else {
                String mensaje = in.readUTF();
                JOptionPane.showMessageDialog(null, mensaje, "No se genero el archivo Json", JOptionPane.WARNING_MESSAGE);
            }

            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
