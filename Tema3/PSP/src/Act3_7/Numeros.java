package Act3_7;

public class Numeros {
    int n;
    long cuadrado, cubo;
    public Numeros(int n, long cuadrado, long cubo) {
        this.n = n;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }
    public Numeros() {}

    public void setN(int n) {
        this.n = n;
    }
    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }
    public void setCubo(long cubo) {
        this.cubo = cubo;
    }
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
