package org.example.Act2;

public class Especialidad {
    int id;
    String nombreespe;
    //Contructor
    Especialidad(int id, String nombreespe){
        this.id = id;
        this.nombreespe = nombreespe;
    }
    //Getter y Setter

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreespe() {
        return nombreespe;
    }
    public void setNombreespe(String nombreespe) {
        this.nombreespe = nombreespe;
    }
    //Metodo toString()

    @Override
    public String toString() {
        return "Especialidad{" + "id=" + id + ", nombreespe='" + nombreespe + '}';
    }
}
