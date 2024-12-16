package Act3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor3_7Modificada {
    public static void main(String[] args) {
        int puerto = 49153; // Puerto en el que escucha el servidor.

        try {
            // Crea el socket UDP.
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Esperando al cliente...");

            byte[] bufferEntrada = new byte[1024]; // Buffer para recibir datos.

            while (true) {
                // Recibe el paquete desde el cliente.
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                socket.receive(paqueteRecibido); // Bloqueante hasta que llega un paquete.

                // Deserializa el objeto Numeros recibido.
                ByteArrayInputStream byteInput = new ByteArrayInputStream(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                ObjectInputStream objectInput = new ObjectInputStream(byteInput);
                Numeros3_7Modificada numero = (Numeros3_7Modificada) objectInput.readObject();

                int n = numero.getN();
                if (n <= 0) {
                    System.out.println("Número <= 0 recibido. Cerrando servidor...");
                    break; // Termina si el número es <= 0.
                }

                // Calcula el cuadrado y el cubo.
                numero.setCuadrado(n * n);
                numero.setCubo((long) n * n * n);

                // Serializa el objeto Numeros modificado.
                ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
                ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
                objectOutput.writeObject(numero);
                byte[] bufferSalida = byteOutput.toByteArray();

                // Envía el objeto modificado de vuelta al cliente.
                InetAddress direccionCliente = paqueteRecibido.getAddress();
                int puertoCliente = paqueteRecibido.getPort();
                DatagramPacket paqueteEnviado = new DatagramPacket(bufferSalida, bufferSalida.length, direccionCliente, puertoCliente);
                socket.send(paqueteEnviado);

                // Muestra en consola los resultados.
                System.out.println("Número recibido: " + numero.getN());
                System.out.println("Cuadrado: " + numero.getCuadrado());
                System.out.println("Cubo: " + numero.getCubo());
            }

            // Cierra el socket.
            socket.close();
            System.out.println("Servidor finalizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
