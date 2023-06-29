package com.portfolio.back.Repository;

import com.portfolio.back.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHabilidad extends JpaRepository<Habilidad, Integer> {

    public Optional<Habilidad> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
