public class Act2_6Ejemplo1 {
    public static void main(String[] args) {
        //Creamos hilos
        HiloPrioridad2_6 h1=new HiloPrioridad2_6("Hilo 1");
        HiloPrioridad2_6 h2=new HiloPrioridad2_6("Hilo 2");
        HiloPrioridad2_6 h3=new HiloPrioridad2_6("Hilo 3");

        //Asignamos prioridad
        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);

        //Ejecutamos los hilos
        h1.start();
        h2.start();
        h3.start();

        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException e){}

        //Paramos los hilos
        h1.pararHilo();
        h2.pararHilo();
        h3.pararHilo();

        System.out.println("h2 (Prioridad Máxima): " + h2.getC());
        System.out.println("h1 (Prioridad Normal): " + h1.getC());
        System.out.println("h3 (Prioridad Mínima): " + h3.getC());
    }
}
