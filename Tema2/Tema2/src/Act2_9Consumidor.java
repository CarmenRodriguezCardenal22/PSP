public class Act2_9Consumidor extends Thread {
    private Act2_9Cola cola;
    private int n;
    // Constructor
    public Act2_9Consumidor(Act2_9Cola cola, int n) {
        this.cola = cola; // Asocia la cola compartida con el consumidor
        this.n = n; // Guarda el identificador del consumidor
    }

    // Metodo que se ejecuta cuando el hilo del consumidor es iniciado
    @Override
    public void run() {
        int valor = 0; // Variable para almacenar el valor consumido

        // Bucle que permite al consumidor consumir 5 elementos de la cola
        for (int i = 0; i < 5; i++) {
            // Llama al metodo `get()` de la cola para obtener un valor
            // Este metodo está sincronizado y bloquea si la cola está vacía
            valor = cola.get();

            try {
                // Hace que el hilo del consumidor duerma durante 100 ms
                // Simula un tiempo de procesamiento o espera después de consumir
                sleep(100);
            } catch (InterruptedException e) {
                // Captura y muestra un mensaje si ocurre una interrupción del hilo
                System.out.println(e.getMessage());
            }

            // Imprime información sobre el elemento consumido
            // Muestra el índice de iteración, el identificador del consumidor y el valor consumido
            System.out.println(i + " => Consumidor: " + n + ", consume: " + valor);
        }
    }
}
