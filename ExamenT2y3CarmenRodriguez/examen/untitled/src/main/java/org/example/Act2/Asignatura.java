package org.example.Act2;

public class Asignatura {
    int id;
    String nombreasig;
    //Contructor
    Asignatura(int id, String nombreasig) {
        this.id = id;
        this.nombreasig = nombreasig;
    }
    //Getter y Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreasig() {
        return nombreasig;
    }
    public void setNombreasig(String nombreasig) {
        this.nombreasig = nombreasig;
    }
    //Metodo toString()

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id + ", nombreasig='" + nombreasig + '}';
    }
}
