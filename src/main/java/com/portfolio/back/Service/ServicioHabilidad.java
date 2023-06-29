package com.portfolio.back.Service;

import com.portfolio.back.Entity.Habilidad;
import com.portfolio.back.Repository.RepositorioHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioHabilidad {

    @Autowired
    RepositorioHabilidad rHabilidad;

    public List<Habilidad> list() {
        return rHabilidad.findAll();
    }

    public Optional<Habilidad> getOne(int idHabilidad) {
        return rHabilidad.findById(idHabilidad);
    }

    public Optional<Habilidad> getByNombreHabilidad(String nombreHabilidad) {
        return rHabilidad.findByNombreHabilidad(nombreHabilidad);
    }

    public void save(Habilidad habilidad) {
        rHabilidad.save(habilidad);
    }

    public void delete(int idHabilidad) {
        rHabilidad.deleteById(idHabilidad);
    }

    public boolean existsById(int idHabilidad) {
        return rHabilidad.existsById(idHabilidad);
    }

    public boolean existsByNombreHabilidad(String nombreHabilidad) {
        return rHabilidad.existsByNombreHabilidad(nombreHabilidad);
    }
}
