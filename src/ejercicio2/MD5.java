package ejercicio2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5 {
    public byte[] crearSumatorioMD5(String nombreFichero) throws Exception{
        InputStream fis =  new FileInputStream(nombreFichero);
        MessageDigest conversor = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[2048];
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                conversor.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return conversor.digest();
    }

    public String sacarMD5DeSumatorio(String nombreFichero) throws Exception {
        byte[] bytes = crearSumatorioMD5(nombreFichero);
        String result = "";
        for (int i=0; i < bytes.length; i++) {
            result += Integer.toString( ( bytes[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    /**
     * bytes[i] & 0xff ---> convierte de byte a entero de 32 bits de longitud
     * 0x100 ---> es 256 decimal, establece el noveno bit en 1, lo que garantiza que la representación del número binario
     * tenga exactamente 9 bits.
     * Después de establecer el bit 8, el resultado de toString() será de 9 caracteres (de ceros y unos).
     * substring(1) ignora efectivamente el bit 8 y genera los 8 bits inferiores.
     * 16 es la raíz , es decir, la base 16, que es hexadecimal. El código básicamente genera el 1 como "01" en lugar de "1"
     */

}
