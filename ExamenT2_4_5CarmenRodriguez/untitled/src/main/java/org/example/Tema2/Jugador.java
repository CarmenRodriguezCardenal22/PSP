package org.example.Tema2;

public class Jugador extends Thread {
    int id, n;
    double saldo;
    Banca banca;

    //Constructor
    public Jugador(int id, Banca banca) {
        this.id = id;
        this.n = 0;
        this.saldo = 1000;
        this.banca = banca;
    }

    //Metodos getters y setters
    public int getN() {
        return n;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void apostar(){
        n=(int)((Math.random()*36)+1);
        System.out.println("Jugador con id: " + id + " ha seleccionado el número: " + n);
        setSaldo(getSaldo()-10);
    }
    //Metodo run. En el generamos la apuesta del jugador y comprobamos si a acertado.
    public void run() {
        try {
            apostar();
            if (getN() == banca.getN()) {
                System.out.println("Número acertado, has ganado 360€");
                setSaldo(getSaldo()+360);
                banca.jugadorGana();
            }
            else{
                System.out.println("Número no acertado. Intentelo de nuevo");
                banca.jugadorPierde();
            }
            System.out.println("Jugador " + id + ", saldo actual=" + saldo);
            System.out.println("El número elegido por la ruleta era: " + banca.getN());
            System.out.println("El saldo actual de la banca es: " + banca.getSaldo() + "\n");
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", saldo actual=" + saldo + '}';
    }
}
