package ejercicio7;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.trustStore", "descom.seguridad");
        System.setProperty("javax.net.ssl.trustStorePassword", "descom123");
        System.out.println("Iniciando cliente, esperando conexion");
        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 12345);
        System.out.println("Conexion establecida");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                String mensaje = sc.nextLine();
                dos.writeUTF(mensaje);
                System.out.println(dis.readUTF());
                if (mensaje.equalsIgnoreCase("bye")) break;
            }
        } catch (Exception e) {
            System.out.println("Conexion finalizada");
        }
        System.out.println("Conexion finalizada");


    }
}
