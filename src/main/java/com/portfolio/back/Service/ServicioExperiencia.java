//este servicio proporciona métodos para realizar operaciones CRUD (crear, leer, 
//actualizar y eliminar) en la entidad "Experiencia" utilizando el repositorio 
//correspondiente. Estos métodos permiten interactuar con la base de datos y 
//realizar operaciones relacionadas con las instancias de "Experiencia" en el 
//sistema.
package com.portfolio.back.Service;

import com.portfolio.back.Entity.Experiencia;
import com.portfolio.back.Repository.RepositorioExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioExperiencia {

    @Autowired
    RepositorioExperiencia rExperiencia;

    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(int idExperiencia) {
        return rExperiencia.findById(idExperiencia);
    }

    public Optional<Experiencia> getByNombreExperiencia(String nombreExperiencia) {
        return rExperiencia.findByNombreExperiencia(nombreExperiencia);
    }

    public void save(Experiencia expe) {
        rExperiencia.save(expe);
    }

    public void delete(int idExperiencia) {
        rExperiencia.deleteById(idExperiencia);
    }

    public boolean existsById(int idExperiencia) {
        return rExperiencia.existsById(idExperiencia);
    }

    public boolean existsByNombreExperiencia(String nombreExperiencia) {
        return rExperiencia.existsByNombreExperiencia(nombreExperiencia);
    }
}
