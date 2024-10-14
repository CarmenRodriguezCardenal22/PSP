//Lee un nombre desde los argumentos del main
import java.io.IOException;
import java.util.Arrays;

public class Act1_4 {

    public static void main(String[] args) throws IOException{
        if (args.length <= 0) {
            System.err.println("El array está vacío");
            System.exit(-1);
        }
        System.out.println(Arrays.toString(args));
        System.exit(1);
    }
}