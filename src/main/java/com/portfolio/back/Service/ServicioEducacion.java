
package com.portfolio.back.Service;

import com.portfolio.back.Entity.Educacion;
import com.portfolio.back.Repository.RepositorioEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioEducacion {
    @Autowired
     RepositorioEducacion rEducacion;
     
     public List<Educacion> list(){
         return rEducacion.findAll();
     }
     
     public Optional<Educacion> getOne(int idEducacion){
         return rEducacion.findById(idEducacion);
     }
     
     public Optional<Educacion> getByNombreEducacion(String nombreEducacion){
         return rEducacion.findByNombreEducacion(nombreEducacion);
     }
     
     public void save(Educacion edu){
         rEducacion.save(edu);
     }
     
     public void delete(int idEducacion){
         rEducacion.deleteById(idEducacion);
     }
     
     public boolean existsById(int idEducacion){
         return rEducacion.existsById(idEducacion);
     }
     
     public boolean existsByNombreEducacion(String nombreEducacion){
         return rEducacion.existsByNombreEducacion(nombreEducacion);
     }
}