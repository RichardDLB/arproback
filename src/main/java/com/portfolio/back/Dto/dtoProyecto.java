package com.portfolio.back.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String img1;

    @NotBlank
    private String img2;

    @NotBlank
    private String img3;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion, String img1, String img2, String img3) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

}
