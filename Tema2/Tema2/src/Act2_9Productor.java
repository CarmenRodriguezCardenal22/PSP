public class Act2_9Productor extends Thread {
    private Act2_9Cola cola;
    private int n;

    public Act2_9Productor(Act2_9Cola cola, int n) {
        this.cola = cola;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i);
            System.out.println(i + "=> Productor: " + n + ", produce: " + i);
        }
    }
}
