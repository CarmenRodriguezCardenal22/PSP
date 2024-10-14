public class HiloAct2_2 implements Runnable{
    int id;
    public HiloAct2_2(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Hola mundo " + id);
    }
}
