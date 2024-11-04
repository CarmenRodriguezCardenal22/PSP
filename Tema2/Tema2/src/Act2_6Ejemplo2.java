public class Act2_6Ejemplo2 extends Thread{
    //constructor
    Act2_6Ejemplo2(String nombre){
        this.setName(nombre);
    }
    //metodo que arranca los hilos
    public void run(){
        System.out.println("Ejecutando [" + getName() + "]");
        for (int i=1;i<=5;i++){
            System.out.println("\t(" + getName() + ": " + i + ")");
        }
    }
    public static void main(String[] args) {
        //creamos los hilos
        Act2_6Ejemplo2 h1 = new Act2_6Ejemplo2("Uno");
        Act2_6Ejemplo2 h2 = new Act2_6Ejemplo2("Dos");
        Act2_6Ejemplo2 h3 = new Act2_6Ejemplo2("Tres");
        Act2_6Ejemplo2 h4 = new Act2_6Ejemplo2("Cuatro");
        Act2_6Ejemplo2 h5 = new Act2_6Ejemplo2("Cinco");

        //asignamos prioridad
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(3);
        h3.setPriority(Thread.NORM_PRIORITY);
        h4.setPriority(7);
        h5.setPriority(Thread.MAX_PRIORITY);

        //se ejecutan los hilos
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}
