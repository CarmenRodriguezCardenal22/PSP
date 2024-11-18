public class Act2_8 {
    int saldo; // Variable que almacena el saldo actual de la cuenta

    // Constructor
    Act2_8(int saldo) {
        this.saldo = saldo; // Asigna el saldo inicial
    }

    // Metodo para establecer un nuevo saldo en la cuenta
    // Simula un retraso aleatorio usando `Thread.sleep()`
    public void setSaldo(int saldo) throws InterruptedException {
        this.saldo = saldo; // Actualiza el saldo con el valor proporcionado
        long n = (long) (Math.random()); // Genera un número aleatorio
        Thread.sleep(n); // Simula un retraso en la operación
    }

    // Metodo para obtener el saldo actual de la cuenta
    // Simula un retraso aleatorio antes de devolver el saldo
    public int getSaldo() throws InterruptedException {
        long n = (long) (Math.random()); // Genera un número aleatorio
        Thread.sleep(n); // Simula un retraso en la operación
        return saldo; // Devuelve el saldo actual
    }

    // Metodo para cambiar el saldo añadiendo una cantidad específica
    // Imprime el estado inicial, la cantidad añadida y el estado final del saldo
    public void cambiarSaldo(int cant) throws InterruptedException {
        // Imprime el saldo antes de realizar el cambio
        System.out.println("Estado inicial: " + saldo);

        // Imprime la cantidad que será añadida al saldo
        System.out.println("Cantidad añadida: " + cant);

        // Actualiza el saldo sumando la cantidad proporcionada
        this.saldo = saldo + cant;

        // Imprime el saldo después de realizar el cambio
        System.out.println("Estado final: " + saldo);
    }

}
