public class Act2_8 {
    int saldo;
    Act2_8(int saldo) {
        this.saldo = saldo;
    }
    public void setSaldo(int saldo) throws InterruptedException {
        this.saldo = saldo;
        long n=(long)(Math.random());
        Thread.sleep(n);
    }
    public int getSaldo() throws InterruptedException {
        long n=(long)(Math.random());
        Thread.sleep(n);
        return saldo;
    }
    public void cambiarSaldo(int cant) throws InterruptedException {
        System.out.println("Estado inicial: " + saldo);
        System.out.println("Cantidad añadida: " + cant);
        this.saldo = saldo+cant;
        System.out.println("Estado final: " + saldo);
    }
}
