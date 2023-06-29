package com.portfolio.back.Service;

import com.portfolio.back.Entity.Persona;
import com.portfolio.back.Repository.RepositorioPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioPersona {

    @Autowired
    RepositorioPersona rPersona;

    public List<Persona> list() {
        return rPersona.findAll();
    }

    public Optional<Persona> getOne(int idPersona) {
        return rPersona.findById(idPersona);
    }

    public Optional<Persona> getByNombrePersona(String nombrePersona) {
        return rPersona.findByNombrePersona(nombrePersona);
    }

    public void save(Persona persona) {
        rPersona.save(persona);
    }

    public void delete(int idPersona) {
        rPersona.deleteById(idPersona);
    }

    public boolean existsById(int idPersona) {
        return rPersona.existsById(idPersona);
    }

    public boolean existsByNombrePersona(String nombrePersona) {
        return rPersona.existsByNombrePersona(nombrePersona);
    }
}
