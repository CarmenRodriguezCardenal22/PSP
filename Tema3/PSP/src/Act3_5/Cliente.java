package Act3_5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 49153;

        Socket cliente = new Socket(host, puerto);
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        System.out.println("Recibiendo mensaje del servidor: " + flujoEntrada.readUTF());

        flujoEntrada.close();
        cliente.close();
    }
}
