
package com.portfolio.back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducacion;
    private String nombreEducacion;
    private String descripcionEducacion;

    public Educacion() {
    }

    public Educacion(String nombreEducacion, String descripcionEducacion) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
    }

    public Educacion(int idEducacion, String nombreEducacion, String descripcionEducacion) {
        this.idEducacion = idEducacion;
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
    }

    public int getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(int idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getDescripcionEducacion() {
        return descripcionEducacion;
    }

    public void setDescripcionEducacion(String descripcionEducacion) {
        this.descripcionEducacion = descripcionEducacion;
    }

    @Override
    public String toString() {
        return "Educacion{" + "idEducacion=" + idEducacion + ", nombreEducacion=" + nombreEducacion + ", descripcionEducacion=" + descripcionEducacion + '}';
    }

    

}

