package Act3_8;

public class ServidorEjercicio3 {
    public static void main(String[] args) {
        Alumno alumnos[] = new Alumno[5];
        Curso curso1 =new Curso("1", "matematicas");
        Curso curso2 =new Curso("2", "lengua");
        Curso curso3 =new Curso("3", "ingles");
        alumnos[0] = new Alumno("1", "Carmen", curso3, 7);
        alumnos[1] = new Alumno("2", "Sofía", curso1, 4);
        alumnos[2] = new Alumno("3", "Sergio", curso2, 5);
        alumnos[3] = new Alumno("4", "Javier", curso1, 8);
        alumnos[4] = new Alumno("5", "Jose Antonio", curso3, 10);

        try {
            while(true) {

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
