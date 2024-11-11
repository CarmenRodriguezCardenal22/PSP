public class Act2_9Consumidor extends Thread {
    private Act2_9Cola cola;
    private int n;
    public Act2_9Consumidor(Act2_9Cola cola, int n) {
        this.cola = cola;
        this.n = n;
    }
    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get();
            try{
                sleep(100);
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(i + "=> Consumidor: " + n + ", consume: " + valor);
        }
    }
}
