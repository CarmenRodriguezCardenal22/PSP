public class HiloAct2_1 extends Thread{
    String nombre;
    public HiloAct2_1(String nombre){
        this.nombre = nombre;
    }
    public void run(){
        try{
            while (true){
                System.out.println(nombre);
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
