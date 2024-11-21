public class Act2_8 extends Thread {
    public static void main(String[] args) {
        // Creacion de objeto saldo
        Act2_8Saldo s=new Act2_8Saldo(100);
        //Creacion de hilos
        HiloAct2_8 h1=new HiloAct2_8(s,200);
        HiloAct2_8 h2=new HiloAct2_8(s,300);
        HiloAct2_8 h3=new HiloAct2_8(s,400);
        h1.start();
        h2.start();
        h3.start();
    }
}

