package Act3_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Escanea la entrada del usuario desde la consola.
        String host = "localhost"; // Dirección del servidor.
        int puerto = 49153; // Puerto al que se conectará el cliente.

        try {
            Socket cliente = new Socket(host, puerto); // Crea el socket y se conecta al servidor.

            // Flujos para enviar y recibir datos al/del servidor.
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            String cadena = ""; // Inicializa la cadena de entrada.
            while (!cadena.equals("*")) { // Mientras el usuario no escriba "*", continúa.
                System.out.println("Escribe una cadena");
                cadena = sc.nextLine(); // Lee la entrada del usuario.

                flujoSalida.writeUTF(cadena); // Envía la cadena al servidor.

                if (!cadena.equals("*")) { // Si no es "*", espera respuesta del servidor.
                    String mensaje = flujoEntrada.readUTF();
                    System.out.println("Mensaje recibido: " + mensaje); // Imprime la respuesta.
                }
            }

            // Cierra los flujos y el socket.
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
