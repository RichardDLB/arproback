package com.portfolio.back.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String nombreExperiencia;

    @NotBlank
    private String descripcionExperiencia;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExperiencia, String descripcionExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    @Override
    public String toString() {
        return "dtoExperiencia{" + "nombreExperiencia=" + nombreExperiencia + ", descripcionExperiencia=" + descripcionExperiencia + '}';
    }

    

}
