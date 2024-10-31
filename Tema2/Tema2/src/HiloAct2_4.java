public class HiloAct2_4 extends Thread {
    private FuncionesHiloAct2_4 parar = new FuncionesHiloAct2_4();
    private int cont = 0;
    private boolean enEjecucion = true;
    // Suspender el hilo
    public void Suspende() {
        parar.set(true);
    }
    // Reanudar el hilo
    public void Reanuda() {
        parar.set(false);
    }
    // Finalizar el hilo
    public void finalizar() {
        enEjecucion = false;
    }
    // Valor del cont
    public int getContador() {
        return cont;
    }
    // Incrementar contador
    public boolean incrementarCont() {
        if (!parar.estaSuspendido() && enEjecucion) {
            cont++;
            System.out.println("Contador: " + cont);
            return true;
        }
        return false;
    }
    public void run() {
        while (enEjecucion) {
            try {
                parar.esperandoParaReanudar();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido.");
            }
        }
        System.out.println("Hilo finalizado.");
    }
}
