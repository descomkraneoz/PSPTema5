package ejercicio4;

import sun.misc.BASE64Encoder;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

public class FirmaFichero {
    public static void main(String[] args) {
        GeneradorClaves generadorClaves = new GeneradorClaves(512);
        generadorClaves.crearClaves();
        try {
            byte[] datosFichero = Ficheros.sacaBytesDeFichero("pruebaImagenMD5.jpg");
            //Creando el objeto firma
            Signature firma = Signature.getInstance("SHA1WithRSA");
            //Inicializar la firma con la clave privada de la pareja de clave publica-privada
            firma.initSign(generadorClaves.getClavePrivada());
            //Actualizar los datos firmados
            firma.update(datosFichero);
            //Resultado de la firma
            byte[] bytesDeFirma = firma.sign();
            //Pasando el resultado de la firma a String.
            System.out.println("Firma: " + new BASE64Encoder().encode(bytesDeFirma));
            //Inicializar la verificación del fichero con la clave publica de la privada
            firma.initVerify(generadorClaves.getClavePublica());
            //Actualizar los datos firmados
            firma.update(datosFichero);
            //Verificación del fichero
            System.out.println(firma.verify(bytesDeFirma) ? "Coinicide la firma" : "No coincide la firma");
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        } catch (NullPointerException npe) {
            System.out.println("Fichero no encontrado");
        }
    }
}
