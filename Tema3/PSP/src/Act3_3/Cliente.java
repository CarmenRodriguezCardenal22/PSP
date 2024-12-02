package Act3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 49153;

        Socket cliente = new Socket(host, puerto);

        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        String mensaje=flujoEntrada.readUTF();
        System.out.println("Recibiendo mensaje del servidor: " + mensaje);


        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoSalida.writeUTF(mensaje.toLowerCase());

        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
