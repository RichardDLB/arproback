
package com.portfolio.back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String profesionPersona;
    private String imgBannerPersona;
    private String imgPerfilPersona;
    private String emailPersona;
    private String texPrePersona;

    public Persona() {
    }

    public Persona(String nombrePersona, String apellidoPersona, String profesionPersona, String imgBannerPersona, String imgPerfilPersona, String emailPersona, String texPrePersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.profesionPersona = profesionPersona;
        this.imgBannerPersona = imgBannerPersona;
        this.imgPerfilPersona = imgPerfilPersona;
        this.emailPersona = emailPersona;
        this.texPrePersona = texPrePersona;
    }

    public Persona(int idPersona, String nombrePersona, String apellidoPersona, String profesionPersona, String imgBannerPersona, String imgPerfilPersona, String emailPersona, String texPrePersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.profesionPersona = profesionPersona;
        this.imgBannerPersona = imgBannerPersona;
        this.imgPerfilPersona = imgPerfilPersona;
        this.emailPersona = emailPersona;
        this.texPrePersona = texPrePersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
        return "Persona{" + "idPersona=" + idPersona + ", nombrePersona=" + nombrePersona + ", apellidoPersona=" + apellidoPersona + ", profesionPersona=" + profesionPersona + ", imgBannerPersona=" + imgBannerPersona + ", imgPerfilPersona=" + imgPerfilPersona + ", emailPersona=" + emailPersona + ", texPrePersona=" + texPrePersona + '}';
    }

    
    
    

}
