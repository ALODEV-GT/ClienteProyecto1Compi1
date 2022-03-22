package sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Envio {

    private final File directorioProyecto1;
    private final File directorioProyecto2;
    private final DataOutputStream out;

    public Envio(File directorioProyecto1, File directorioProyecto2, DataOutputStream out) {
        this.directorioProyecto1 = directorioProyecto1;
        this.directorioProyecto2 = directorioProyecto2;
        this.out = out;
    }

    public void enviar() throws IOException {
        File[] archivosP1 = this.directorioProyecto1.listFiles();
        int cantidadArchivoP1 = archivosP1.length;
        out.writeInt(cantidadArchivoP1);

        File[] archivosP2 = this.directorioProyecto2.listFiles();
        int cantidadArchivoP2 = archivosP2.length;
        out.writeInt(cantidadArchivoP2);

        //Envio de archivo del Proyecto 1
        for (int i = 0; i < cantidadArchivoP1; i++) {
            enviarArchivo(archivosP1[i]);
        }

        //Envio de archivos del Proyecto 2
        for (int i = 0; i < cantidadArchivoP2; i++) {
            enviarArchivo(archivosP2[i]);
        }
    }

    private void enviarArchivo(File f) throws IOException {
        String nombreArchivo = f.getName();
        out.writeUTF(nombreArchivo);
        byte[] contenidoArchivo = getBytesArchivo(f);
        out.writeInt(contenidoArchivo.length);
        for (int j = 0; j < contenidoArchivo.length; j++) {
            out.write(contenidoArchivo[j]);
        }
    }

    private byte[] getBytesArchivo(File f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));

        String linea = "";
        String contenido = "";

        while ((linea = br.readLine()) != null) {
            contenido += linea + "\r\n";
        }
        br.close();
        return contenido.getBytes();
    }

}
