//Ejecuta el programa 1.4
import java.io.*;

public class EjecutarAct1_4 {

    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/usuario/PSP/Tema1-/out/production/PSP");
        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Act1_4", "Mi nombre es Carmen");
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());
        Process p = pb.start();
        try {
            InputStream is = p.getInputStream();
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