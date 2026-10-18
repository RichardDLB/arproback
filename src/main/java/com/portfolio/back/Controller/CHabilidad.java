package com.portfolio.back.Controller;

import com.portfolio.back.Dto.dtoHabilidad;
import com.portfolio.back.Entity.Habilidad;
import com.portfolio.back.Security.Controller.Mensaje;
import com.portfolio.back.Service.ServicioHabilidad;
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
@RequestMapping("/habilidad")
@CrossOrigin(origins = {"https://arprofront.web.app", "http://localhost:4200"})

public class CHabilidad {

    @Autowired
    ServicioHabilidad sHabilidad;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idHabilidad) {
        if (!sHabilidad.existsById(idHabilidad)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        sHabilidad.delete(idHabilidad);
        return new ResponseEntity(new Mensaje("id eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int idHabilidad) {
        if (!sHabilidad.existsById(idHabilidad)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        Habilidad habilidad = sHabilidad.getOne(idHabilidad).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidad dtohabilidad) {
        if (StringUtils.isBlank(dtohabilidad.getNombreHabilidad())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sHabilidad.existsByNombreHabilidad(dtohabilidad.getNombreHabilidad())) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = new Habilidad(dtohabilidad.getNombreHabilidad(), dtohabilidad.getPorcentajeHabilidad());
        sHabilidad.save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idHabilidad, @RequestBody dtoHabilidad dtohabilidad) {
        //Validamos si existe el ID
        if (!sHabilidad.existsById(idHabilidad)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (sHabilidad.existsByNombreHabilidad(dtohabilidad.getNombreHabilidad()) && sHabilidad.getByNombreHabilidad(dtohabilidad.getNombreHabilidad()).get().getIdHabilidad() != idHabilidad) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohabilidad.getNombreHabilidad())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = sHabilidad.getOne(idHabilidad).get();
        habilidad.setNombreHabilidad(dtohabilidad.getNombreHabilidad());
        habilidad.setPorcentajeHabilidad((dtohabilidad.getPorcentajeHabilidad()));

        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
