package com.mem.Hemeroteca.repository;

import com.mem.Hemeroteca.model.Medios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediosRepository extends JpaRepository<Medios, Long> {
    // Puedes añadir consultas personalizadas si es necesario
}

