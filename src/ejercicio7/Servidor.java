package ejercicio7;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;

public class Servidor {
    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.keyStore", "descom.seguridad");
        System.setProperty("javax.net.ssl.keyStorePassword", "descom123");
        SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(12345);
        System.out.println("Servidor montado y esperando conexiones");
        while (true) {
            new ServicioServidor(serverSocket.accept()).start();
            System.out.println("-Nueva conexión-");
        }
    }
}
