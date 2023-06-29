
package com.portfolio.back.Service;

import com.portfolio.back.Entity.Habilidad;
import com.portfolio.back.Repository.RHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidad {

     @Autowired
     RHabilidad rHabilidad;
     
     public List<Habilidad> list(){
         return rHabilidad.findAll();
     }
     
     public Optional<Habilidad> getOne(int id){
         return rHabilidad.findById(id);
     }
     
     public Optional<Habilidad> getByNombre(String nombre){
         return rHabilidad.findByNombre(nombre);
     }
     
     public void save(Habilidad habilidad){
         rHabilidad.save(habilidad);
     }
     
     public void delete(int id){
         rHabilidad.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rHabilidad.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rHabilidad.existsByNombre(nombre);
     }
}