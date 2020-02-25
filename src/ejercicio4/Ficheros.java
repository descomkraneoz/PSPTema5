package ejercicio4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ficheros {
    public static byte[] sacaBytesDeFichero(String ruta) {
        File f = new File(ruta);
        byte[] contenidoFichero;
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(ruta);
                contenidoFichero = new byte[(int) f.length()];
                fis.read(contenidoFichero);
                fis.close();
                return contenidoFichero;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}