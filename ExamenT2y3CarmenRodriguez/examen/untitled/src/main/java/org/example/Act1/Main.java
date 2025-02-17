package org.example.Act1;

public class Main {
    public static void main(String[] args) {
        //La actividad cuenta con 3 clases: Cuenta, Persona y Main.
        //En la clase Cuenta tenemos todos los métodos sobre saldo (Contructosr, saldoActual, ingresar y reintegrar)
        //En la clase Persona tenemos todos los métodos sobre personas ( Contructor y run), además esta es la clase hilo.
        //En la clase Main tenemos la implementación e inicialización de 2 personas.
        //La actividad funciona, aunque tiene un fallo y es que cada persona opera en una cuenta separada.
        Persona persona = new Persona("Carmen");
        Persona persona2 = new Persona("Javier");
        persona.run();
        persona2.run();
    }
}