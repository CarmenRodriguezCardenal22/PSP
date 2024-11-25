import java.util.Scanner;
import java.net.*;

public class Act3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la dirección IP o el nombre de la máquina que quieres consultar: ");
        try{
            InetAddress dir = InetAddress.getByName(sc.next());
            System.out.println("Método getByName(): " + dir);
            System.out.println("Método getLocalHost(): " + InetAddress.getLocalHost());
            System.out.println("Método getHostName(): " + dir.getHostName());
            System.out.println("Método getHostAddress(): " + dir.getHostAddress());
            System.out.println("Método toString(): " + dir.toString());
            System.out.println("Método getCanonicalHostName(): " + dir.getCanonicalHostName());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
