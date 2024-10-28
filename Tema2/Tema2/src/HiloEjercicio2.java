public class HiloEjercicio2 implements Runnable {
    String cad;
    int id;
    public HiloEjercicio2(String cad, int id){
        this.cad=cad;
        this.id=id;
    }
    public void run(){
        try{
            Thread.sleep(id*1000);
            System.out.println("Hola mundo " + cad + id);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
