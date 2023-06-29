package com.portfolio.back.Controller;

import com.portfolio.back.Dto.dtoExperiencia;
import com.portfolio.back.Entity.Experiencia;
import com.portfolio.back.Security.Controller.Mensaje;
import com.portfolio.back.Service.ServicioExperiencia;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://arprofront.web.app", "http://localhost:4200"})

public class CExperiencia {

    @Autowired
    ServicioExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idExperiencia) {
        if (!sExperiencia.existsById(idExperiencia)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(idExperiencia);
        return new ResponseEntity(new Mensaje("id eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int idExperiencia) {
        if (!sExperiencia.existsById(idExperiencia)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(idExperiencia).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreExperiencia())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByNombreExperiencia(dtoexp.getNombreExperiencia())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getNombreExperiencia(), dtoexp.getDescripcionExperiencia());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia guardada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idExperiencia, @RequestBody dtoExperiencia dtoexp) {
        //Validamos si existe el ID
        if (!sExperiencia.existsById(idExperiencia)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (sExperiencia.existsByNombreExperiencia(dtoexp.getNombreExperiencia()) && sExperiencia.getByNombreExperiencia(dtoexp.getNombreExperiencia()).get().getIdExperiencia() != idExperiencia) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreExperiencia())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(idExperiencia).get();
        experiencia.setNombreExperiencia(dtoexp.getNombreExperiencia());
        experiencia.setDescripcionExperiencia((dtoexp.getDescripcionExperiencia()));

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
