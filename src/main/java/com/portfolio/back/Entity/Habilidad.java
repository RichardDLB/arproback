package com.portfolio.back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHabilidad;
    private String nombreHabilidad;
    private String porcentajeHabilidad;

    public Habilidad() {
    }

    public Habilidad(String nombreHabilidad, String porcentajeHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.porcentajeHabilidad = porcentajeHabilidad;
    }

    public Habilidad(int idHabilidad, String nombreHabilidad, String porcentajeHabilidad) {
        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
        this.porcentajeHabilidad = porcentajeHabilidad;
    }

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getPorcentajeHabilidad() {
        return porcentajeHabilidad;
    }

    public void setPorcentajeHabilidad(String porcentajeHabilidad) {
        this.porcentajeHabilidad = porcentajeHabilidad;
    }

    @Override
    public String toString() {
        return "Habilidad{" + "idHabilidad=" + idHabilidad + ", nombreHabilidad=" + nombreHabilidad + ", porcentajeHabilidad=" + porcentajeHabilidad + '}';
    }

       

}
