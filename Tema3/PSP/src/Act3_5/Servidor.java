package Act3_5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
        int clientesConectados = 1;
        while(clientesConectados<4){
            System.out.println("Esperando cliente...");
            Socket cliente = servidor.accept();

            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Eres el cliente número " + clientesConectados);

            clientesConectados++;
            salida.close();
            flujoSalida.close();
            cliente.close();
        }

        servidor.close();
    }
}
