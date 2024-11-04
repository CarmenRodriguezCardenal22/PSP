public class HiloPrioridad2_6 extends Thread {
    private int c = 0;
    private boolean stopHilo = false;
    public HiloPrioridad2_6(String nombre) {
        super(nombre);
    }
    public int getC() {
        return c;
    }
    public void pararHilo() {
        stopHilo = true;
    }
    public void run() {
        while (!stopHilo) {
            try {
                Thread.sleep(2);
            }
            catch (InterruptedException e) {}
            c++;
        }
        System.out.println("Fin hilo: " + this.getName());
    }
}
