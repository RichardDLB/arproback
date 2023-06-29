package com.portfolio.back.Controller;

import com.portfolio.back.Dto.dtoPersona;
import com.portfolio.back.Entity.Persona;
import com.portfolio.back.Security.Controller.Mensaje;
import com.portfolio.back.Service.ServicioPersona;
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
@RequestMapping("/persona")
@CrossOrigin(origins = {"https://arprofront.web.app","http://localhost:4200"})

public class CPersona {

    @Autowired
    ServicioPersona sPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPersona) {
        if (!sPersona.existsById(idPersona)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(idPersona);
        return new ResponseEntity(new Mensaje("id eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int idPersona) {
        if (!sPersona.existsById(idPersona)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = sPersona.getOne(idPersona).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombrePersona())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sPersona.existsByNombrePersona(dtopersona.getNombrePersona())) {
            return new ResponseEntity(new Mensaje("La persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtopersona.getNombrePersona(), dtopersona.getApellidoPersona(), dtopersona.getProfesionPersona(),
                dtopersona.getImgBannerPersona(), dtopersona.getImgPerfilPersona(), dtopersona.getEmailPersona(),
                dtopersona.getTexPrePersona());
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idPersona, @RequestBody dtoPersona dtopersona) {
        //Validamos si existe el ID
        if (!sPersona.existsById(idPersona)) {
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (sPersona.existsByNombrePersona(dtopersona.getNombrePersona()) && sPersona.getByNombrePersona(dtopersona.getNombrePersona()).get().getIdPersona() != idPersona) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtopersona.getNombrePersona())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = sPersona.getOne(idPersona).get();
        persona.setNombrePersona(dtopersona.getNombrePersona());
        persona.setApellidoPersona((dtopersona.getApellidoPersona()));
        persona.setProfesionPersona((dtopersona.getProfesionPersona()));
        persona.setImgBannerPersona((dtopersona.getImgBannerPersona()));
        persona.setImgPerfilPersona((dtopersona.getImgPerfilPersona()));
        persona.setEmailPersona((dtopersona.getEmailPersona()));
        persona.setTexPrePersona((dtopersona.getTexPrePersona()));

        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
