public class Act2_7Sincronizado extends Thread implements Runnable {
    static public class Hilo extends Thread {
        private static int cont = 0; // Variable compartida entre hilos

        public synchronized static void incrementarContador() { // Mestodo sincronizado en la clase
            if (cont < 5000) {
                cont++;
                System.out.println("El contador vale: " + cont);
            }
        }

        public void run() {
            while (true) { // Cada hilo ejecuta su propio bucle
                if (cont >= 5000) {
                    break; // Detener si el contador alcanza el límite
                }
                incrementarContador(); // Incrementa el contador de forma sincronizada
            }
        }

        public static void main(String[] args) {
            Hilo hilo1 = new Hilo();
            Hilo hilo2 = new Hilo();
            Hilo hilo3 = new Hilo();
            Hilo hilo4 = new Hilo();
            Hilo hilo5 = new Hilo();

            // Inicia todos los hilos
            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
        }
    }
}
