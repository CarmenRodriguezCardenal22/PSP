package org.example.Act1;

public class Persona extends Thread {
    public String nombre;
    Cuenta cuenta = new Cuenta(40, 700);

    //Contructor
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    //Metodo que inicializa el hilo
    public void run() {
        try {
            System.out.println("La persona que opera es : " + nombre);
            for (int i = 0; i < 2; i++) {
                cuenta.saldoActual();
                int aleatorio = (int) (Math.random() * 500 + 1);
                cuenta.ingresar(aleatorio);
                cuenta.saldoActual();
                Thread.sleep(3000);
                aleatorio = (int) (Math.random() * 500 + 1);
                cuenta.reintegrar(aleatorio);
                Thread.sleep(3000);
            }
            cuenta.saldoActual();
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }
}
