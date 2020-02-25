package ejercicio7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServicioServidor extends Thread {
    Socket socket;

    public ServicioServidor(Socket cliente) {
        this.socket = cliente;
    }

    @Override
    public void run() {
        String mensaje;
        DataInputStream dis;
        DataOutputStream dos;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            while (true) {
                mensaje = dis.readUTF();
                System.out.println(mensaje.toUpperCase());
                dos.writeUTF(mensaje.toUpperCase());
                if (mensaje.equalsIgnoreCase("Bye")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
