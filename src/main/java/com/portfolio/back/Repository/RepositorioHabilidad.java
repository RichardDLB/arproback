package com.portfolio.back.Repository;

import com.portfolio.back.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioHabilidad extends JpaRepository<Habilidad, Integer> {

    public Optional<Habilidad> findByNombreHabilidad(String nombreHabilidad);

    public boolean existsByNombreHabilidad(String nombreHabilidad);
}
