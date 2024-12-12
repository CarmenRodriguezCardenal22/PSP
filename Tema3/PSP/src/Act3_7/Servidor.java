package Act3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

            // Flujos para enviar y recibir datos al/del cliente.
            ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());

            Numeros numero = (Numeros) flujoEntrada.readObject(); // Variable para almacenar los mensajes recibidos.

            // Bucle para procesar mensajes hasta recibir "*".
            while (numero.getN()>=0) {
                numero.setCuadrado(numero.getN()*numero.getN());
                numero.setCubo(numero.getN()*numero.getN()*numero.getN());
                flujoSalida.writeUTF(numero.toString()); // Responde con la cadena en mayúsculas.
                System.out.println("Número recibido: " + numero.getN()); // Imprime el mensaje recibido.
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
