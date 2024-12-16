package Act3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente3_7Modificada {
    public static void main(String[] args) {
        String host = "localhost"; // Dirección del servidor.
        int puerto = 49153; // Puerto del servidor.

        try {
            // Crea el socket UDP.
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);

            int n = 1; // Variable para almacenar el número ingresado por el usuario.

            while (n > 0) {
                System.out.println("Dime un número:");
                n = sc.nextInt(); // Solicita un número al usuario.

                // Crea el objeto Numeros y le asigna el número.
                Numeros3_7Modificada numero = new Numeros3_7Modificada();
                numero.setN(n);

                // Serializa el objeto Numeros a un array de bytes.
                ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
                ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
                objectOutput.writeObject(numero);
                byte[] bufferSalida = byteOutput.toByteArray();

                // Envía el paquete al servidor.
                InetAddress direccionServidor = InetAddress.getByName(host);
                DatagramPacket paqueteEnviado = new DatagramPacket(bufferSalida, bufferSalida.length, direccionServidor, puerto);
                socket.send(paqueteEnviado);

                if (n > 0) { // Si el número es positivo, espera respuesta del servidor.
                    byte[] bufferEntrada = new byte[1024];
                    DatagramPacket paqueteRecibido = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                    socket.receive(paqueteRecibido); // Recibe el paquete con la respuesta del servidor.

                    // Deserializa el objeto Numeros recibido.
                    ByteArrayInputStream byteInput = new ByteArrayInputStream(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                    ObjectInputStream objectInput = new ObjectInputStream(byteInput);
                    numero = (Numeros3_7Modificada) objectInput.readObject();

                    // Imprime los resultados.
                    System.out.println("Número recibido: " + numero.getN());
                    System.out.println("Cuadrado: " + numero.getCuadrado());
                    System.out.println("Cubo: " + numero.getCubo());
                }
            }

            // Cierra el socket.
            socket.close();
            System.out.println("Cliente finalizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
