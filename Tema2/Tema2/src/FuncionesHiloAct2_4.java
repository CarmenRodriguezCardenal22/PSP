public class FuncionesHiloAct2_4 {
    private boolean suspender;
    // Suspender el hilo
    public synchronized void set(boolean b) {
        suspender = b;
        notifyAll();
    }
    // Verificar si el hilo esta o no iniciado
    public synchronized boolean estaSuspendido() {
        return suspender;
    }
    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (suspender) {
            wait(); // Para el hilo
        }
    }
}
