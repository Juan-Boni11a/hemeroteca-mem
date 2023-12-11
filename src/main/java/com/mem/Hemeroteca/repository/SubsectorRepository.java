package com.mem.Hemeroteca.repository;

import com.mem.Hemeroteca.model.Subsector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsectorRepository extends JpaRepository<Subsector, Long> {
    // Puedes añadir consultas personalizadas si es necesario
    List<Subsector> findBySector(boolean sector);
}

