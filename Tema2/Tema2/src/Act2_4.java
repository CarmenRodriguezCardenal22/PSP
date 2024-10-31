import java.util.Scanner;

public class Act2_4 {
    public static void main(String[] args) {
        HiloAct2_4 hilo = new HiloAct2_4();
        Scanner scanner = new Scanner(System.in);
        // Iniciar el hilo una vez
        boolean iniciar = false;

        while (true) {
            System.out.print("Pulsa una de las siguientes teclas:\nS: Parar\nR: Reanudar\n*: Salir\nOtra: Incrementar contador: ");
            String tecla = scanner.nextLine();

            if (tecla.equals("*")) {
                hilo.finalizar(); // Para el hilo
                break;
            } else if (tecla.equalsIgnoreCase("S")) {
                hilo.Suspende(); // Suspender el hilo
                System.out.println("Hilo parado.");
            } else if (tecla.equalsIgnoreCase("R")) {
                hilo.Reanuda(); // Reanudar el hilo
                System.out.println("Hilo reanudado.");
            } else {
                // Verificar si el hilo está o no parado
                if (!hilo.incrementarCont()) {
                    System.out.println("El hilo está parado. Introduzca otra opción.");
                }
            }

            // Iniciar el hilo la primera vez
            if (!iniciar) {
                hilo.start();
                iniciar = true;
            }
        }

        try {
            hilo.join(); // Espera a q acabe el hilo
        } catch (InterruptedException e) {
            System.out.println("El hilo ha sido parado.");
        }

        // Valor final del contador
        System.out.println("El valor final del contador: " + hilo.getContador());
        scanner.close();
    }
}
