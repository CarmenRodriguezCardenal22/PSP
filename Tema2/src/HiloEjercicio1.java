public class HiloEjercicio1 extends Thread {
    int id;
    public HiloEjercicio1(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Hola mundo " + id);
    }
}
