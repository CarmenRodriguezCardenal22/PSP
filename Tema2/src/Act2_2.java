public class Act2_2 {
    public static void main(String[] args) {
        HiloAct2_2 h1=new HiloAct2_2(1);
        HiloAct2_2 h2=new HiloAct2_2(2);
        HiloAct2_2 h3=new HiloAct2_2(3);
        HiloAct2_2 h4=new HiloAct2_2(4);
        HiloAct2_2 h5=new HiloAct2_2(5);
        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();
        new Thread(h4).start();
        new Thread(h5).start();
    }
}
