package com.portfolio.back.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {

    @NotBlank
    private String nombrePersona;
    @NotBlank
    private String apellidoPersona;
    @NotBlank

    private String profesionPersona;
    @NotBlank

    private String imgBannerPersona;
    @NotBlank

    private String imgPerfilPersona;
    @NotBlank

    private String emailPersona;
    @NotBlank

    private String texPrePersona;

    public dtoPersona() {
    }

    public dtoPersona(String nombrePersona, String apellidoPersona, String profesionPersona, String imgBannerPersona, String imgPerfilPersona, String emailPersona, String texPrePersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.profesionPersona = profesionPersona;
        this.imgBannerPersona = imgBannerPersona;
        this.imgPerfilPersona = imgPerfilPersona;
        this.emailPersona = emailPersona;
        this.texPrePersona = texPrePersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getProfesionPersona() {
        return profesionPersona;
    }

    public void setProfesionPersona(String profesionPersona) {
        this.profesionPersona = profesionPersona;
    }

    public String getImgBannerPersona() {
        return imgBannerPersona;
    }

    public void setImgBannerPersona(String imgBannerPersona) {
        this.imgBannerPersona = imgBannerPersona;
    }

    public String getImgPerfilPersona() {
        return imgPerfilPersona;
    }

    public void setImgPerfilPersona(String imgPerfilPersona) {
        this.imgPerfilPersona = imgPerfilPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getTexPrePersona() {
        return texPrePersona;
    }

    public void setTexPrePersona(String texPrePersona) {
        this.texPrePersona = texPrePersona;
    }

    @Override
    public String toString() {
        return "dtoPersona{" + "nombrePersona=" + nombrePersona + ", apellidoPersona=" + apellidoPersona + ", profesionPersona=" + profesionPersona + ", imgBannerPersona=" + imgBannerPersona + ", imgPerfilPersona=" + imgPerfilPersona + ", emailPersona=" + emailPersona + ", texPrePersona=" + texPrePersona + '}';
    }

    
}
