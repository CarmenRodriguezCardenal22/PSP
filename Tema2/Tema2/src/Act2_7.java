public class Act2_7 extends Thread implements Runnable {
    public static class Contador {
        int cont = 0;

        public synchronized void incrementar() {
            if (cont < 5000) {
                cont++;
                System.out.println("El contador vale: " + cont + " - " + Thread.currentThread().getName());
            }
        }
    }

    public static class Hilo extends Thread {
        private final Contador contador;

        public Hilo(Contador contador) {
            this.contador = contador; // Referencia compartida al contador
        }

        public void run() {
            while (true) {
                if (contador.cont >= 5000) {
                    break; // Detener si el contador alcanza el límite
                }
                contador.incrementar();
            }
        }
    }

    public static void main(String[] args) {
        Contador contadorCompartido = new Contador(); // Instancia única de Contador

        Hilo hilo1 = new Hilo(contadorCompartido);
        Hilo hilo2 = new Hilo(contadorCompartido);
        Hilo hilo3 = new Hilo(contadorCompartido);
        Hilo hilo4 = new Hilo(contadorCompartido);
        Hilo hilo5 = new Hilo(contadorCompartido);

        // Inicia todos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}

