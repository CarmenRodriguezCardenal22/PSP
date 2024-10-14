import java.io.File;
import java.io.IOException;

public class EjecutarAct1_7 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/usuario/PSP/Tema1-/out/production/PSP");
        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Act1_7");
        pb.directory(directorio);
        File fOut = new File("salidaAct7.txt");
        File fErr = new File("errorAct7.txt");
        File fEnt = new File("entrada.txt");

        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        pb.redirectInput(fEnt);
        pb.start();
    }
}