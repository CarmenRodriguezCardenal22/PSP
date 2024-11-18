public class Act2_9Productor extends Thread {
    private Act2_9Cola cola;
    private int n;

    // Constructor
    public Act2_9Productor(Act2_9Cola cola, int n) {
        this.cola = cola; // Asocia la cola compartida con el productor
        this.n = n; // Guarda el identificador del productor
    }

    // Metodo que se ejecuta cuando el hilo del productor es iniciado
    @Override
    public void run() {
        // Bucle que permite al productor producir 5 elementos
        for (int i = 0; i < 5; i++) {
            // Llama al metodo `put()` de la cola para añadir un valor
            // Este metodo está sincronizado y bloqueará si la cola está llena
            cola.put(i);

            // Imprime información en la consola sobre el elemento producido
            // Muestra el índice de iteración, el identificador del productor y el valor producido
            System.out.println(i + " => Productor: " + n + ", produce: " + i);
        }
    }
}
