package org.example.Tema2;

public class Partida extends Thread {
    public static void main(String[] args) {
        //La actividad cuenta con 3 clases: Banca, Jugador y Partida.

        //En la clase Banca tenemos todos los métodos los metodos que actuan sobre la ruleta y el saldo de la banca
        //(Constructor, GenerarNumero, JugadorGana y JugadorPierde).

        //En la clase Jugador tenemos todos los métodos que actuan sobre las apuestas
        // (Contructor, Apueta y Run), además esta es la clase hilo.

        //En la clase Partida(Main) tenemos la implementación e inicialización de los 4 jugadores.

        //La app funciona correctamente. Solo realiza una tirada de ruleta.

        // Para ejecutar y comprobar que funciona bien se puede cambiar los Math.random de Jugador y Banca
        // para que solo generen numeros entre 1 y 2 y de esta manera poder comprobar que cuando acierta,
        // al igual que cuando falla, funciona
        Banca b = new Banca();
        b.generarN();
        Jugador jugador1 = new Jugador(1, b);
        Jugador jugador2 = new Jugador(2, b);
        Jugador jugador3 = new Jugador(3, b);
        Jugador jugador4 = new Jugador(4, b);
        jugador1.run();
        jugador2.run();
        jugador3.run();
        jugador4.run();
    }
}
