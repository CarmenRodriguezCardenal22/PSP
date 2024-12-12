package Act3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host = "localhost"; // Dirección del servidor.
        int puerto = 49153; // Puerto al que se conectará el cliente.

        try {
            Socket cliente = new Socket(host, puerto); // Crea el socket y se conecta al servidor.

            // Flujos para enviar y recibir datos al/del servidor.
            ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            int n = 0; // Inicializa la cadena de entrada.
            while (n>=0) { // Mientras el usuario no escriba "*", continúa.
                System.out.println("Dime un número:");
                n = sc.nextInt();
                Numeros numero=new Numeros();
                numero.setN(n);

                flujoSalida.writeUTF(numero.toString()); // Envía la cadena al servidor.

                if (n>0) { // Si no es "*", espera respuesta del servidor.
                    numero = (Numeros) flujoEntrada.readObject();
                    System.out.println("Mensaje recibido: " + numero); // Imprime la respuesta.
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
