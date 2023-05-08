package com.portfolio.back.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank

    private String profesion;
    @NotBlank

    private String imgBanner;
    @NotBlank

    private String imgPerfil;
    @NotBlank

    private String email;
    @NotBlank

    private String texPre;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String profesion, String imgBanner, String imgPerfil, String email, String texPre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.imgBanner = imgBanner;
        this.imgPerfil = imgPerfil;
        this.email = email;
        this.texPre = texPre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTexPre() {
        return texPre;
    }

    public void setTexPre(String texPre) {
        this.texPre = texPre;
    }

}
