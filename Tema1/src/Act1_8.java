import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Act1_8 {

    public static void main (String [] args) throws IOException{
        File directorio = new File("/home/usuario/PSP/Tema1-/out/production/Tema1");
        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Act1_7");
        pb.directory(directorio);
        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        os.write("Buenas tardes\n".getBytes());
        os.flush();
        try {
            InputStream is = p.getInputStream();
            int e;
            while ((e = is.read()) != -1)
                System.out.print((char) e);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File fOut = new File("salidaAct8.txt");
        File fEnt = new File("entrada.txt");
        pb.redirectOutput(fOut);
        pb.redirectInput(fEnt);
        pb.start();



    }
}