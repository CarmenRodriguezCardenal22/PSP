public class Act2_9Cola {
    private int numero;
    private boolean disponible = false;

    // Metodo sincronizado para obtener un número del buffer
    public synchronized int get() {
        // Mientras no haya un número disponible, el consumidor espera
        while (!disponible) {
            try {
                // El hilo consumidor espera a que el productor ponga un número en el buffer
                wait();
            } catch (InterruptedException e) {
                // Si ocurre una interrupción, se muestra un mensaje
                System.out.println(e.getMessage());
            }
        }
        // Una vez consumido el número, se marca el buffer como no disponible
        disponible = false;

        // Notifica al productor que el consumidor ha consumido el número
        // y que puede poner otro número en el buffer
        notify();

        // Devuelve el número consumido
        return numero;
    }

    // Metodo sincronizado para poner un número en el buffer
    public synchronized void put(int valor) {
        // Mientras haya un número disponible en el buffer, el productor espera
        while (disponible) {
            try {
                // El hilo productor espera a que el consumidor consuma el número actual
                wait();
            } catch (InterruptedException e) {
                // Si ocurre una interrupción, se muestra un mensaje
                System.out.println(e.getMessage());
            }
        }
        // El productor coloca el número en el buffer
        numero = valor;

        // Marca el buffer como disponible, indicando que el consumidor puede consumir
        disponible = true;

        // Notifica al consumidor que hay un nuevo número disponible
        notify();
    }
}
