import java.util.Scanner;
import java.net.*;

public class Act3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe la dirección IP o el nombre de la máquina que quieres consultar: ");
        try {
            // Obtener la dirección ingresada por el usuario
            InetAddress dir = InetAddress.getByName(sc.next());

            // Muestra la información básica del objeto InetAddress obtenido (nombre o IP)
            System.out.println("Método getByName(): " + dir);

            // Obtiene y muestra la dirección IP del host local (máquina que ejecuta este código)
            System.out.println("Método getLocalHost(): " + InetAddress.getLocalHost());

            // Obtiene y muestra el nombre del host asociado con la dirección IP
            System.out.println("Método getHostName(): " + dir.getHostName());

            // Obtiene y muestra la dirección IP en formato String
            System.out.println("Método getHostAddress(): " + dir.getHostAddress());

            // Convierte el objeto InetAddress a un String en formato "nombre/IP"
            System.out.println("Método toString(): " + dir.toString());

            // Obtiene el nombre canónico completo del host
            System.out.println("Método getCanonicalHostName(): " + dir.getCanonicalHostName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
