// Clase que extiende Thread para representar operaciones sobre un saldo compartido
public class Act2_8Saldo extends Thread {
    // Variable que almacena el saldo actual
    int saldo;

    // Constructor para inicializar el saldo inicial
    Act2_8Saldo(int saldo) {
        this.saldo = saldo;
    }

    // Metodo para establecer el saldo (simula un tiempo de espera aleatorio)
    public void setSaldo(int saldo) throws InterruptedException {
        try {
            // Genera un tiempo de espera aleatorio
            long n = (long) (Math.random());
            Thread.sleep(n); // Simula una operación que tarda tiempo
        } catch (InterruptedException e) {
            // Captura y muestra posibles excepciones de interrupción
            System.out.println(e.getMessage());
        }
        this.saldo = saldo; // Establece el nuevo saldo
    }

    // Metodo para obtener el saldo actual (simula un tiempo de espera aleatorio)
    public int getSaldo() throws InterruptedException {
        try {
            // Genera un tiempo de espera aleatorio
            long n = (long) (Math.random());
            Thread.sleep(n); // Simula una operación que tarda tiempo
        } catch (InterruptedException e) {
            // Captura y muestra posibles excepciones de interrupción
            System.out.println(e.getMessage());
        }
        return saldo; // Devuelve el saldo actual
    }

    // Metodo sincronizado para ingresar una cantidad al saldo
    public synchronized void ingresar(int cant) throws InterruptedException {
        // Muestra el estado inicial del saldo
        System.out.println("Estado inicial: " + saldo);
        // Muestra la cantidad que se va a añadir
        System.out.println("Cantidad añadida: " + cant);
        // Incrementa el saldo con la cantidad proporcionada
        this.saldo = this.saldo + cant;
        // Muestra el estado final del saldo
        System.out.println("Estado final: " + saldo);
    }
}

