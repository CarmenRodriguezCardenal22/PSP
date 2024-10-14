//Lee 2 números, los suma y los muestra por pantalla
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Act1_6 {
    public static void main(String[] args) throws IOException{
        int n1=0,n2=0;
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        try {
            System.out.println("Dime un numero");
            n1=Integer.parseInt(br.readLine());
            System.out.println("Numero introducido: " + n1);
            System.out.println("Dime otro");
            n2=Integer.parseInt(br.readLine());
            System.out.println("Numero introducido: " + n2);
            int suma=n1+n2;
            System.out.println("La suma de ambos numeros es: " + suma);
            in.close();
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}