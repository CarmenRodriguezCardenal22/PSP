public class Act2_8Saldo extends Thread{
    int saldo;

    Act2_8Saldo(int saldo) {
        this.saldo = saldo;
    }

    public void setSaldo(int saldo) throws InterruptedException {
        Thread.sleep(n);
    }

    public int getSaldo() throws InterruptedException {
        return saldo;
    }

    public synchronized void ingresar(int cant) throws InterruptedException {
        System.out.println("Estado inicial: " + saldo);
        System.out.println("Cantidad añadida: " + cant);
        this.saldo = saldo + cant;
        System.out.println("Estado final: " + saldo);
    }

    @Override
    public void run() {
        long n = (long) (Math.random());
        Thread.sleep(n);
        ingresar(100);
    }
}
