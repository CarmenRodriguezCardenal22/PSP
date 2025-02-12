import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("bash","-c","ls").start();
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
        int exitVal;
        try{
            exitVal=p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}