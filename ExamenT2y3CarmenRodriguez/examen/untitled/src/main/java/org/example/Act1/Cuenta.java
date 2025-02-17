package org.example.Act1;

public class Cuenta {
    int saldo;
    int valorMax;
    //Contructor
    public Cuenta(int saldo, int valorMax) {
        this.saldo = saldo;
        this.valorMax = valorMax;
    }
    //Con este metodo obtenemos el saldo actual de la cuenta
    public int saldoActual() {
        System.out.println("El saldo actual de la cuenta es: " + getSaldo());
        return getSaldo();
    }
    //Con este metodo ingresamos dinero en la cuenta
    public void ingresar(int valor) {
        if (getSaldo() + valor > valorMax) {
            System.out.println("No es posible hacer el ingreso ya que se superaría el valor máximo");
        }
        else{
            setSaldo(getSaldo() + valor);
            System.out.println("Ingreso de : " + valor + " euros");
        }
    }
    //Con este metodo sacamos dinero en la cuenta
    public void reintegrar(int valor) {
        if(getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Reintegro de : " + valor + " euros");
        }
        else{
            System.out.println("No es posible realizar el reintegro ya que no hay saldo suficiente");
        }
    }
    //Getter
    public int getSaldo() {
        return saldo;
    }
    //Setter
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
