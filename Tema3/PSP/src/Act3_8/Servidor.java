package Act3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 49153; // Puerto en el que escuchará el servidor.

        try {
            // Crea el socket UDP.
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Esperando al cliente...");

            // Prepara el datagrama para recibir los datos.
            byte[] datosRecibidos = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            socket.receive(paqueteRecibido); // Espera a recibir un datagrama del cliente.

            // Deserializa el objeto Persona recibido.
            ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            ObjectInputStream flujoEntrada = new ObjectInputStream(bais);
            Persona persona = (Persona) flujoEntrada.readObject();

            // Muestra la información recibida.
            System.out.println("Persona recibida: " + persona.getNombre() + ", " + persona.getEdad());

            // Modifica el objeto Persona.
            persona.setNombre("Sergio");
            persona.setEdad(15);
            System.out.println("Persona enviada: " + persona.getNombre() + ", " + persona.getEdad());

            // Serializa el objeto modificado.
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream flujoSalida = new ObjectOutputStream(bs);
            flujoSalida.writeObject(persona);
            flujoSalida.flush();
            byte[] datosEnviados = bs.toByteArray();

            // Envía el objeto modificado de vuelta al cliente.
            InetAddress direccionCliente = paqueteRecibido.getAddress();
            int puertoCliente = paqueteRecibido.getPort();
            DatagramPacket paqueteEnviado = new DatagramPacket(datosEnviados, datosEnviados.length, direccionCliente, puertoCliente);
            socket.send(paqueteEnviado);

            // Cierra los recursos.
            socket.close();
            flujoSalida.close();
            flujoEntrada.close();
            System.out.println("Servidor finalizado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
