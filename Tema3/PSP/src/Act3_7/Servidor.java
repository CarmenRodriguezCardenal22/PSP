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
            // Crea un socket servidor en el puerto especificado.
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Esperando al cliente...");

            // Espera y acepta la conexión de un cliente.
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado.");

            // Inicializa los flujos de entrada y salida para recibir/enviar objetos.
            ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

            // Bucle principal: recibe números del cliente hasta que se envía un número <= 0.
            Numeros numero = (Numeros) flujoEntrada.readObject(); // Recibe el primer objeto Numeros.
            int n = numero.getN();

            while (n > 0) {
                // Calcula el cuadrado y el cubo del número recibido.
                numero.setCuadrado(n * n);
                numero.setCubo((long) n * n * n);

                // Envía el objeto modificado de vuelta al cliente.
                flujoSalida.writeObject(numero);

                // Imprime en el servidor los datos recibidos y calculados.
                System.out.println("Número recibido: " + numero.getN());
                System.out.println("Cuadrado: " + numero.getCuadrado());
                System.out.println("Cubo: " + numero.getCubo());

                // Espera el siguiente objeto enviado por el cliente.
                numero = (Numeros) flujoEntrada.readObject();
                n = numero.getN();
            }

            // Cierra los flujos y los sockets.
            flujoSalida.close();
            flujoEntrada.close();
            cliente.close();
            servidor.close();
            System.out.println("Servidor finalizado.");

        } catch (Exception e) {
            e.printStackTrace(); // Captura y muestra cualquier error.
        }
    }
}

