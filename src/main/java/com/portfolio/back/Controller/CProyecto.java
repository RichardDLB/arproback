package com.portfolio.back.Controller;

import com.portfolio.back.Dto.dtoProyecto;
import com.portfolio.back.Entity.Proyecto;
import com.portfolio.back.Security.Controller.Mensaje;
import com.portfolio.back.Service.SProyecto;
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
@CrossOrigin(origins = {"http://localhost:4200"})
public class CProyecto {

    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {
        if (StringUtils.isBlank(dtoproyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombre(dtoproyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoproyecto.getNombre(), dtoproyecto.getDescripcion(), dtoproyecto.getImg1(), dtoproyecto.getImg2(), dtoproyecto.getImg3());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto) {
        //Validamos si existe el ID
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (sProyecto.existsByNombre(dtoproyecto.getNombre()) && sProyecto.getByNombre(dtoproyecto.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoproyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombre(dtoproyecto.getNombre());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setImg1(dtoproyecto.getImg1());
        proyecto.setImg2(dtoproyecto.getImg2());
        proyecto.setImg3(dtoproyecto.getImg3());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

}
