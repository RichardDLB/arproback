package com.portfolio.back.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidad {

    @NotBlank
    private String nombreHabilidad;

    @NotBlank
    private String porcentajeHabilidad;

    public dtoHabilidad() {
    }

    public dtoHabilidad(String nombreHabilidad, String porcentajeHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.porcentajeHabilidad = porcentajeHabilidad;
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
        return "dtoHabilidad{" + "nombreHabilidad=" + nombreHabilidad + ", porcentajeHabilidad=" + porcentajeHabilidad + '}';
    }    

}
