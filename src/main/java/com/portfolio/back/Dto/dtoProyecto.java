package com.portfolio.back.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {

    @NotBlank
    private String nombreProyecto;

    @NotBlank
    private String descripcionProyecto;

    @NotBlank
    private String img1Proyecto;

    @NotBlank
    private String img2Proyecto;

    @NotBlank
    private String img3Proyecto;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreProyecto, String descripcionProyecto, String img1Proyecto, String img2Proyecto, String img3Proyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.img1Proyecto = img1Proyecto;
        this.img2Proyecto = img2Proyecto;
        this.img3Proyecto = img3Proyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getImg1Proyecto() {
        return img1Proyecto;
    }

    public void setImg1Proyecto(String img1Proyecto) {
        this.img1Proyecto = img1Proyecto;
    }

    public String getImg2Proyecto() {
        return img2Proyecto;
    }

    public void setImg2Proyecto(String img2Proyecto) {
        this.img2Proyecto = img2Proyecto;
    }

    public String getImg3Proyecto() {
        return img3Proyecto;
    }

    public void setImg3Proyecto(String img3Proyecto) {
        this.img3Proyecto = img3Proyecto;
    }

    @Override
    public String toString() {
        return "dtoProyecto{" + "nombreProyecto=" + nombreProyecto + ", descripcionProyecto=" + descripcionProyecto + ", img1Proyecto=" + img1Proyecto + ", img2Proyecto=" + img2Proyecto + ", img3Proyecto=" + img3Proyecto + '}';
    }

    

}
