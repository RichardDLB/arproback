
package com.portfolio.back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String profesion;
    private String imgBanner;
    private String imgPerfil;
    private String email;
    private String texPre;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String profesion, String imgBanner, String imgPerfil, String email, String texPre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.imgBanner = imgBanner;
        this.imgPerfil = imgPerfil;
        this.email = email;
        this.texPre = texPre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
