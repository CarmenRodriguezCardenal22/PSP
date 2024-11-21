// Clase que extiende Thread y representa un hilo que realiza operaciones sobre un saldo
public class HiloAct2_8 extends Thread {
    // Objeto compartido que representa el saldo
    private Act2_8Saldo saldo;
    // Cantidad a ingresar en el saldo
    private int cant;

    // Constructor que inicializa el saldo compartido y la cantidad a ingresar
    public HiloAct2_8(Act2_8Saldo saldo, int cant) {
        this.saldo = saldo; // Referencia al objeto Act2_8Saldo
        this.cant = cant;   // Cantidad a modificar en el saldo
    }

    // Metodo principal que define el comportamiento del hilo
    @Override
    public void run() {
        try {
            // Llama al metodo sincronizado ingresar del objeto saldo
            saldo.ingresar(cant);
        } catch (InterruptedException e) {
            // Manejo de excepción si el hilo es interrumpido
            throw new RuntimeException(e);
        }
    }
}

