
package com.portfolio.back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;
    private String nombreProyecto;
    private String descripcionProyecto;
    private String img1Proyecto;
    private String img2Proyecto;
    private String img3Proyecto;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcionProyecto, String img1Proyecto, String img2Proyecto, String img3Proyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.img1Proyecto = img1Proyecto;
        this.img2Proyecto = img2Proyecto;
        this.img3Proyecto = img3Proyecto;
    }

    public Proyecto(int idProyecto, String nombreProyecto, String descripcionProyecto, String img1Proyecto, String img2Proyecto, String img3Proyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.img1Proyecto = img1Proyecto;
        this.img2Proyecto = img2Proyecto;
        this.img3Proyecto = img3Proyecto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
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
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto + ", descripcionProyecto=" + descripcionProyecto + ", img1Proyecto=" + img1Proyecto + ", img2Proyecto=" + img2Proyecto + ", img3Proyecto=" + img3Proyecto + '}';
    }

    
    
}
