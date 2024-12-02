package Act3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();

        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        flujoSalida.writeUTF("HOLA, BUENOS DIAS");


        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        System.out.println("Recibiendo mensaje del cliente: " + flujoEntrada.readUTF());

        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();
    }
}
