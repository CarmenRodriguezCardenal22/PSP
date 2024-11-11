public class Act2_9 {
    public static void main(String[] args) {
        Act2_9Cola cola = new Act2_9Cola();
        Act2_9Productor p= new Act2_9Productor(cola, 1);
        Act2_9Consumidor c= new Act2_9Consumidor(cola, 1);
        p.start();
        c.start();
    }
}
