package Act3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host = "localhost"; // Dirección del servidor.
        int puerto = 49153; // Puerto al que se conectará el cliente.

        try {
            // Crea el socket y se conecta al servidor en la dirección y puerto especificados.
            Socket cliente = new Socket(host, puerto);

            // Inicializa los flujos de salida y entrada para enviar/recibir objetos.
            ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

            int n = 1; // Variable que almacena el número ingresado por el usuario.

            // Bucle principal: el cliente solicita números hasta que se ingresa 0 o negativo.
            while (n > 0) {
                System.out.println("Dime un número:");
                n = sc.nextInt(); // Solicita un número al usuario.

                // Crea un objeto Numeros y establece el número ingresado.
                Numeros numero = new Numeros();
                numero.setN(n);

                // Envía el objeto "numero" al servidor.
                flujoSalida.writeObject(numero);

                if (n > 0) { // Si el número es positivo, espera la respuesta del servidor.
                    numero = (Numeros) flujoEntrada.readObject(); // Recibe el objeto modificado del servidor.
                    // Imprime los resultados (cuadrado y cubo).
                    System.out.println("Mensaje recibido: " + numero.getN());
                }
            }

            // Cierra los flujos y el socket.
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace(); // Captura y muestra cualquier error.
        }
    }
}
