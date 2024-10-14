//Muestra los errores al intentar ejecutar un programa que no existe
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Act1_5 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/usuario/PSP/Tema1-/out/production/Tema1");
        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "X");
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());
        Process p = pb.start();
        try {
            InputStream is = p.getErrorStream();
            int e;
            while ((e = is.read()) != -1)
                System.out.print((char) e);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}