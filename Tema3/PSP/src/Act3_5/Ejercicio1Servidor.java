package Act3_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio1Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        String cadena;

        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        cadena = flujoEntrada.readUTF();
        System.out.println("Recibiendo mensaje del cliente: " + cadena);

        while(cadena.equals("*")==false){
            int caracteres = cadena.length();
            flujoSalida.writeUTF(String.valueOf(caracteres));
            cadena = flujoEntrada.readUTF();
            System.out.println("Recibiendo mensaje del cliente: " + cadena);
        }

        entrada.close();
        salida.close();
        cliente.close();
        servidor.close();
    }
}
