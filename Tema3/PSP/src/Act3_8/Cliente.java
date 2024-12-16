package Act3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost"; // Dirección del servidor.
        int puerto = 49153; // Puerto al que se enviará el datagrama.

        try {
            // Crea el socket UDP.
            DatagramSocket socket = new DatagramSocket();

            // Crea el objeto Persona.
            Persona persona = new Persona("Carmen", 20);
            System.out.println("Persona enviada: " + persona.getNombre() + ", " + persona.getEdad());

            // Serializa el objeto Persona a bytes.
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream flujoSalida = new ObjectOutputStream(bs);
            flujoSalida.writeObject(persona);
            flujoSalida.flush();
            byte[] datosEnviados = bs.toByteArray();

            // Crea y envía el datagrama al servidor.
            InetAddress direccionServidor = InetAddress.getByName(host);
            DatagramPacket paqueteEnviado = new DatagramPacket(datosEnviados, datosEnviados.length, direccionServidor, puerto);
            socket.send(paqueteEnviado);

            // Prepara el datagrama para recibir la respuesta del servidor.
            byte[] datosRecibidos = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            socket.receive(paqueteRecibido);

            // Deserializa el objeto Persona recibido.
            ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            ObjectInputStream flujoEntrada = new ObjectInputStream(bais);
            persona = (Persona) flujoEntrada.readObject();

            // Muestra la información recibida.
            System.out.println("Persona recibida: " + persona.getNombre() + ", " + persona.getEdad());

            // Cierra los recursos.
            socket.close();
            flujoSalida.close();
            flujoEntrada.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}