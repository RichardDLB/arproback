
package com.portfolio.back.Service;

import com.portfolio.back.Entity.Proyecto;
import com.portfolio.back.Repository.RepositorioProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioProyecto {
    
    @Autowired
     RepositorioProyecto rProyecto;
    
    public List<Proyecto> list(){
         return rProyecto.findAll();
     }
     
     public Optional<Proyecto> getOne(int id){
         return rProyecto.findById(id);
     }
     
     public Optional<Proyecto> getByNombreProyecto(String nombreProyecto){
         return rProyecto.findByNombreProyecto(nombreProyecto);
     }
     
     public void save(Proyecto proyecto){
         rProyecto.save(proyecto);
     }
     
     public void delete(int idProyecto){
         rProyecto.deleteById(idProyecto);
     }
     
     public boolean existsById(int idProyecto){
         return rProyecto.existsById(idProyecto);
     }
     
     public boolean existsByNombreProyecto(String nombreProyecto){
         return rProyecto.existsByNombreProyecto(nombreProyecto);
     }

     
    
}
