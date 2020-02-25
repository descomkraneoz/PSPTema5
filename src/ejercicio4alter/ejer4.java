package ejercicio4alter;

import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejer4 {
    public static void main(String[] args) throws InvalidKeyException, SignatureException {
        try {
            //objeto generador, con el tipo de algoritmo
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");

            //Inicialización del generador, semilla
            //tipo de algorimo para generar dicha semilla
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            //le decimos el tamaño y la semilla
            keyGen.initialize(1024, numero);

            //Creación de las claves, tenemos la pareja en par
            KeyPair parClaves = keyGen.generateKeyPair();
            // obtenermos la privada
            PrivateKey privateKey = parClaves.getPrivate();
            // obtenermos la publica
            PublicKey publicKey = parClaves.getPublic();

            //Firma con clave privada,necesitamos la signature, decimos el algoritmo
            Signature signaturePrivada = Signature.getInstance("SHA1withDSA");
            //cargamos la privada
            signaturePrivada.initSign(privateKey);
            String mensaje = "Este es un mensaje firmado";
            //actualizamos, podemos pasar cualquier cosa
            signaturePrivada.update(mensaje.getBytes());

            //una vez actualizado aplicamos sing, nos devuelve la firma
            byte[] firma = signaturePrivada.sign();

            System.out.println("Firma: " + firma.toString());
            System.out.println("Firma hexadecimal: " + Hexadecimal(firma));
            //

            //comprobar necesito otro objeto signature y comprobar
            Signature signaturePublica = Signature.getInstance("SHA1withDSA");
            // cargamos la publica
            signaturePublica.initVerify(publicKey);
            // actualizamos los datos a firmar
            signaturePublica.update(mensaje.getBytes());

            // Comprobamos si es correcto
            System.out.println("Es correcto: " + signaturePublica.verify(firma));

            System.out.println("---------------------");
            System.out.println("---------------------");

            //Inicialización del generador, semilla
            numero = SecureRandom.getInstance("SHA1PRNG");
            //le decimos el tamaño y la semilla
            keyGen.initialize(1024, numero);

            //Creación de las claves, tenemos la pareja en par
            KeyPair parClaves2 = keyGen.generateKeyPair();
            // obtenermos la privada
            PrivateKey privateKey2 = parClaves2.getPrivate();
            // obtenermos la publica
            PublicKey publicKey2 = parClaves2.getPublic();
            //Firma con clave privada,necesitamos la signature, decimos el algoritmo
            Signature signaPubli2 = Signature.getInstance("SHA1withDSA");

            //cargamos la publica
            signaPubli2.initVerify(publicKey2);
            //actualizamos, podemos pasar cualquier cosa
            signaPubli2.update(mensaje.getBytes());

            //privada
            Signature signaPri2 = Signature.getInstance("SHA1withDSA");
            signaPri2.initSign(privateKey2);
            signaPri2.update(mensaje.getBytes());
            byte[] firma2 = signaPri2.sign();

            System.out.println("Firma: " + firma2.toString());
            System.out.println("Firma hexadecimal: " + Hexadecimal(firma2));

            System.out.println("Correcto: " + signaPubli2.verify(firma2));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ejer4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static String Hexadecimal(byte[] resumen) {
        String hex = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1) {
                hex += "0";
            }
            hex += h;
        }
        return hex.toUpperCase();
    }
}
