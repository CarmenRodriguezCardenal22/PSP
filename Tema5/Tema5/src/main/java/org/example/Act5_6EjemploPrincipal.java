package org.example;

import java.security.Principal;

public class Act5_6EjemploPrincipal implements Principal, java.io.Serializable {
    private String name; //nombre del principal

    //crea un EjemploPrincipal con el nombre suministrado
    public Act5_6EjemploPrincipal(String nombre) {
        if(nombre == null) {
            throw new NullPointerException("Entrada nula");
        }
        this.name = nombre;
    }
    //devuelve el nombre del principal
    public String getName() {
        return name;
    }

    //compara el objeto especificado con el principal para ver si son iguales
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Act5_6EjemploPrincipal)) {
            return false;
        }
        Act5_6EjemploPrincipal act = (Act5_6EjemploPrincipal) o;
        if (this.getName().equals(act.getName())) {
            return true;
        }
        return false;
    }
    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return name;
    }
}
