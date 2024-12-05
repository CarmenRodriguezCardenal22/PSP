package Act3_2;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost"; // Dirección del servidor
        int puerto = 49153; // Puerto en el que el servidor escucha

        // Crea un socket para conectarse al servidor en el host y puerto especificados
        Socket cliente = new Socket(host, puerto);

        // Imprime el puerto local que está utilizando el cliente para esta conexión
        System.out.println("Puerto local: " + cliente.getLocalPort());

        // Imprime el puerto remoto del servidor con el que está conectado el cliente
        System.out.println("Puerto remoto: " + cliente.getPort());

        // Muestra la dirección IP del servidor al que se conecta el cliente
        System.out.println("Dirección IP: " + cliente.getInetAddress());

        // Cierra el socket después de haber obtenido la información
        cliente.close();
    }
}
