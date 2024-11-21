public class Main2_8 {
    public static void main(String[] args) {
        int numeroJugadores = 3; // Número de jugadores que participarán en el juego

        // Crear una instancia del árbitro y pasar el número de jugadores
        Arbitro2_8 arbitro = new Arbitro2_8(numeroJugadores);

        // Inicializar y arrancar los hilos de los jugadores
        for (int i = 0; i <= numeroJugadores; i++) {
            Jugador2_8 jugador = new Jugador2_8(i, arbitro); // Crear jugador con su ID
            jugador.start(); // Iniciar el hilo
        }
    }
}

