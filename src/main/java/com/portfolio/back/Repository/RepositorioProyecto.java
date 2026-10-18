
package com.portfolio.back.Repository;

import com.portfolio.back.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioProyecto extends JpaRepository<Proyecto, Integer>{
    
    public Optional<Proyecto> findByNombreProyecto(String nombreProyecto);

    public boolean existsByNombreProyecto(String nombreProyecto);   
    
}
