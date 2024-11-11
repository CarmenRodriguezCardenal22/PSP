public class Act2_9Cola {
    private int numero;
    private boolean disponible = false;

    public synchronized int get(){
        while(!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        disponible = false;
        notify();
        return numero;
    }
    public synchronized void put(int valor){
        while(disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        numero = valor;
        disponible = true;
        notify();
    }
}
