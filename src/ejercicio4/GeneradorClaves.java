package ejercicio4;

import java.security.*;

public class GeneradorClaves {
    private KeyPairGenerator generador;
    private KeyPair parejaClaves;

    private PrivateKey clavePrivada;

    private PublicKey clavePublica;

    public GeneradorClaves(int tamanyoClave) {
        try {
            //Creamos e inicializamos un generador de claves
            this.generador = KeyPairGenerator.getInstance("RSA");
            this.generador.initialize(tamanyoClave);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public PrivateKey getClavePrivada() {
        return clavePrivada;
    }

    public PublicKey getClavePublica() {
        return clavePublica;
    }

    public void crearClaves() {
        //Creamos una pareja de claves a traves del generador.
        this.parejaClaves = this.generador.generateKeyPair();
        //Obtenemos la clave privada.
        this.clavePrivada = parejaClaves.getPrivate();
        //Obtenemos la clave publica.
        this.clavePublica = parejaClaves.getPublic();
    }
}
