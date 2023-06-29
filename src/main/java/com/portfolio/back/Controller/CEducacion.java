//En resumen, este controlador proporciona una API para realizar operaciones CRUD 
//(crear, leer, actualizar y eliminar) en objetos "Educacion" dentro de un sistema
//de gestión de portafolio.

package com.portfolio.back.Controller;

import com.portfolio.back.Dto.dtoEducacion;
import com.portfolio.back.Entity.Educacion;
import com.portfolio.back.Security.Controller.Mensaje;
import com.portfolio.back.Service.ServicioEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://arprofront.web.app", "http://localhost:4200"})
public class CEducacion {

    @Autowired
    ServicioEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idEducacion) {
        if (!sEducacion.existsById(idEducacion)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(idEducacion);
        return new ResponseEntity(new Mensaje("id eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int idEducacion) {
        if (!sEducacion.existsById(idEducacion)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(idEducacion).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getNombreEducacion())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreEducacion(dtoedu.getNombreEducacion())) {
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getNombreEducacion(), dtoedu.getDescripcionEducacion());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idEducacion, @RequestBody dtoEducacion dtoedu) {
        //Validamos si existe el ID
        if (!sEducacion.existsById(idEducacion)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de educacion
        if (sEducacion.existsByNombreEducacion(dtoedu.getNombreEducacion()) && sEducacion.getByNombreEducacion(dtoedu.getNombreEducacion()).get().getIdEducacion() != idEducacion) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getNombreEducacion())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(idEducacion).get();
        educacion.setNombreEducacion(dtoedu.getNombreEducacion());
        educacion.setDescripcionEducacion((dtoedu.getDescripcionEducacion()));

        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
