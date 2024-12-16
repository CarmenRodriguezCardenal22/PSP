package Act3_8;

import java.io.Serializable;

public class Numeros3_7Modificada  implements Serializable {
    private static final long serialVersionUID = 1L;

    private int n;           // Número ingresado.
    private long cuadrado;   // Cuadrado del número.
    private long cubo;       // Cubo del número.

    // Constructor vacío.
    public Numeros3_7Modificada() {}

    // Constructor parametrizado.
    public Numeros3_7Modificada(int n, long cuadrado, long cubo) {
        this.n = n;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }

    // Métodos setters.
    public void setN(int n) {
        this.n = n;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }

    // Métodos getters.
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
