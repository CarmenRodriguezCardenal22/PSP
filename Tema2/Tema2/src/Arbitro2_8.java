import java.util.Random;

public class Arbitro2_8 {
    private int numeroAdivinar;
    private int turno;
    private int totalJugadores;
    private boolean juegoFinalizado;

    public Arbitro2_8(int totalJugadores) {
        numeroAdivinar=1+(int)(Math.random()*10);
        this.totalJugadores = totalJugadores;
        this.turno = 1; // Comienza el turno del jugador 1
        this.juegoFinalizado = false;
        System.out.print("NUMERO A ADIVINAR: " + numeroAdivinar + "\n");
    }

    // Devuelve el turno actual
    public synchronized int getTurno() {
        return turno;
    }

    // Indica si el juego ha terminado
    public synchronized boolean isJuegoFinalizado() {
        return juegoFinalizado;
    }

    // Metodo para comprobar la jugada de un jugador
    public synchronized void comprobarJugada(int jugadorId, int numeroJugado) {
        if (!juegoFinalizado) { // Si el juego ya terminó, no hace nada

            System.out.println("Jugador " + jugadorId + " juega el número " + numeroJugado);

            // Verificar si el número jugado es el correcto
            if (numeroJugado == numeroAdivinar) {
                System.out.println("¡Jugador " + jugadorId + " ha acertado el número " + numeroAdivinar + "!");
                juegoFinalizado = true; // Marcar el juego como finalizado
            } else {
                System.out.println("Jugador " + jugadorId + " no ha acertado.");
                // Pasar el turno al siguiente jugador
                turno = (turno % totalJugadores) + 1;
            }
        }
    }
}


