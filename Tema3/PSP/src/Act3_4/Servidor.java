package Act3_4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();

        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        int n= Integer.parseInt(flujoEntrada.readUTF());
        System.out.println("Recibiendo mensaje del cliente: " + n);

        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        int nCuadrado=n*n;
        flujoSalida.writeUTF(String.valueOf(nCuadrado));

        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();
    }
}
