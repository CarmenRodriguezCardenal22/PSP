package org.example.Tema2;

public class Banca {
    int n;
    double saldo;

    //Constructor
    public Banca() {
        this.n = 0;
        this.saldo = 50000;
    }

    //Metodos getters y setters
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //Metodo para generar el numero de la ruleta
    public synchronized void generarN(){
        n=(int)((Math.random()*36)+1);
    }

    //Con este metodo retiramos dinero de la banca si el jugador gana
    public  void jugadorGana() {
        setSaldo(getSaldo()-360);
    }
    //Con este metodo ingresamos dinero en la banca si el jugador pierde
    public  void jugadorPierde() {
        setSaldo(getSaldo()+10);
    }
}
