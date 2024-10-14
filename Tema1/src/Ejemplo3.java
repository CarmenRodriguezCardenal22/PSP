import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejemplo3 {
    public static void main(String[] args) throws IOException {
        File directorio= new File("/home/usuario/PSP/target/classes/com/example/psp/");
        ProcessBuilder pb=new ProcessBuilder("java","Ejemplo2");
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());
        Process p= pb.start();
        try{
            InputStream is= p.getInputStream();
            int c;
            while((c=is.read()) != -1)
                System.out.println((char) c);
            is.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}