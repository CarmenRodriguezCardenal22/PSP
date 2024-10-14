public class Ejercicio1 {
    public static void main(String[] args) {
        HiloEjercicio1 h1 = new HiloEjercicio1(1);
        HiloEjercicio1 h2 = new HiloEjercicio1(2);
        HiloEjercicio1 h3 = new HiloEjercicio1(3);
        HiloEjercicio1 h4 = new HiloEjercicio1(4);
        HiloEjercicio1 h5 = new HiloEjercicio1(5);
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}
