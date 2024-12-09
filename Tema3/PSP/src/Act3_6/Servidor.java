package Act3_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 49153; // Puerto en el que escuchará el servidor.

        try {
            ServerSocket servidor = new ServerSocket(puerto); // Crea un socket para aceptar conexiones.
            System.out.println("Esperando al cliente...");
            Socket cliente = servidor.accept(); // Acepta la conexión entrante.

            // Establece un tiempo de espera de 5000 ms para la recepción de datos.
            cliente.setSoTimeout(5000);

            // Flujos para enviar y recibir datos al/del cliente.
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            String cadena = ""; // Variable para almacenar los mensajes recibidos.

            try {
                // Bucle para procesar mensajes hasta recibir "*".
                while (!(cadena = flujoEntrada.readUTF()).equals("*")) {
                    flujoSalida.writeUTF(cadena.toUpperCase()); // Responde con la cadena en mayúsculas.
                    System.out.println("Mensaje recibido: " + cadena); // Imprime el mensaje recibido.
                }
            } catch (SocketTimeoutException e) {
                System.out.println("No se recibieron datos: paquete perdido."); // Control del tiempo de espera.
            }

            // Cierra los flujos y el socket.
            flujoSalida.close();
            flujoEntrada.close();
            cliente.close();
            servidor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}