package org.example.Act2;

import java.util.Arrays;

public class Profesor {
    int idProfesor;
    String nombre;
    Asignatura[] asignaturas;
    Especialidad espe;
    //Contructor
    Profesor(int idProfesor, String nombre, Asignatura[] asignaturas, Especialidad espe) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.espe = espe;
    }
    //Getter y Setter
    public int getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }
    public Especialidad getEspe() {
        return espe;
    }
    public void setEspe(Especialidad espe) {
        this.espe = espe;
    }
    //Metodo toString()

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre='" + nombre + ", asignaturas=" + Arrays.toString(asignaturas) + ", espe=" + espe + '}';
    }
}
