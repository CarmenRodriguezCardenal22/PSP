public class Ejercicio2 {
    public static void main(String[] args) {
        HiloEjercicio2 h1=new HiloEjercicio2("Hilo1 ", 1);
        HiloEjercicio2 h2=new HiloEjercicio2("Hilo2 ", 2);
        HiloEjercicio2 h3=new HiloEjercicio2("Hilo3 ", 3);
        HiloEjercicio2 h4=new HiloEjercicio2("Hilo4 ", 4);
        HiloEjercicio2 h5=new HiloEjercicio2("Hilo5 ", 5);
        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();
        new Thread(h4).start();
        new Thread(h5).start();
    }
    //Al usar el metodo sleep(), observamos que entre las ejecuciones de los hilos,
    //siempre espera el tiempo introducido en el metodo, de manera contraria cuando ejecutas el
    //programa, aparecen todos los mensajes a la vez
}
