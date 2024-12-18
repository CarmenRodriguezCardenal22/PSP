package Act3_7;

import java.io.Serializable;

public class Numeros implements Serializable {
    private static final long serialVersionUID = 1L; // Identificador de versión para serialización.

    private int n;           // El número ingresado.
    private long cuadrado;   // El cuadrado del número.
    private long cubo;       // El cubo del número.

    // Constructor vacío.
    public Numeros() {
    }

    // Constructor parametrizado.
    public Numeros(int n, long cuadrado, long cubo) {
        this.n = n;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }

    // Métodos setters (modificadores).
    public void setN(int n) {
        this.n = n;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }

    // Métodos getters (accesores).
    public int getN() {
        return n;
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public long getCubo() {
        return cubo;
    }
}