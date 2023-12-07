package com.mem.Hemeroteca.repository;

import com.mem.Hemeroteca.model.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeInfoRepository extends JpaRepository<TypeInfo, Long> {
    // Puedes añadir consultas personalizadas si es necesario
}

