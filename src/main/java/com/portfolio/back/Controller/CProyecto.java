package com.portfolio.back.Controller;

import com.portfolio.back.Dto.dtoProyecto;
import com.portfolio.back.Entity.Proyecto;
import com.portfolio.back.Security.Controller.Mensaje;
import com.portfolio.back.Service.ServicioProyecto;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://arprofront.web.app","http://localhost:4200"})

public class CProyecto {

    @Autowired
    ServicioProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idProyecto) {
        if (!sProyecto.existsById(idProyecto)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(idProyecto);
        return new ResponseEntity(new Mensaje("id eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int idProyecto) {
        if (!sProyecto.existsById(idProyecto)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(idProyecto).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {
        if (StringUtils.isBlank(dtoproyecto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombreProyecto(dtoproyecto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoproyecto.getNombreProyecto(), dtoproyecto.getDescripcionProyecto(), dtoproyecto.getImg1Proyecto(), dtoproyecto.getImg2Proyecto(), dtoproyecto.getImg3Proyecto());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idProyecto, @RequestBody dtoProyecto dtoproyecto) {
        //Validamos si existe el ID
        if (!sProyecto.existsById(idProyecto)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (sProyecto.existsByNombreProyecto(dtoproyecto.getNombreProyecto()) && sProyecto.getByNombreProyecto(dtoproyecto.getNombreProyecto()).get().getIdProyecto() != idProyecto) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoproyecto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(idProyecto).get();
        proyecto.setNombreProyecto(dtoproyecto.getNombreProyecto());
        proyecto.setDescripcionProyecto(dtoproyecto.getDescripcionProyecto());
        proyecto.setImg1Proyecto(dtoproyecto.getImg1Proyecto());
        proyecto.setImg2Proyecto(dtoproyecto.getImg2Proyecto());
        proyecto.setImg3Proyecto(dtoproyecto.getImg3Proyecto());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }

}
