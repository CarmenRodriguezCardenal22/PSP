public class Act2_1 {
    public static void main(String[] args) {
        try{
            HiloAct2_1 h1=new HiloAct2_1("TIC");
            HiloAct2_1 h2=new HiloAct2_1("TAC");
            h1.start();
            h2.start();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //Se muestran de manera desordenada porque se ejecutan de manera simultanéa y además,
    //no tienen prioridad uno sobre el otro.
}
