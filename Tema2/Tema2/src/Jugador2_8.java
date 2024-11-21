import java.util.Random;

public class Jugador2_8 extends Thread {
    private int jugadorId;
    private Arbitro2_8 arbitro;

    public Jugador2_8(int jugadorId, Arbitro2_8 arbitro) {
        this.jugadorId = jugadorId;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        // Repetir mientras el juego no haya terminado
        while (!arbitro.isJuegoFinalizado()) {
            synchronized (arbitro) {
                // Comprobar si es el turno del jugador actual
                if (arbitro.getTurno() == jugadorId && !arbitro.isJuegoFinalizado()) {
                    // Generar un número aleatorio entre 1 y 10
                    int numeroJugado = (int) (Math.random() * 10 + 1);

                    // Realizar la jugada llamando al metodo del árbitro
                    arbitro.comprobarJugada(jugadorId, numeroJugado);
                }
            }
            // Pausa para evitar conflictos entre hilos
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            }
        }
    }
}
