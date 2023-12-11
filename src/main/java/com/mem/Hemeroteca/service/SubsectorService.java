package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.Subsector;

import java.util.List;
import java.util.Optional;

public interface SubsectorService {

    List<Subsector> obtenerTodos();

    Optional<Subsector> obtenerPorId(Long id);

    Subsector guardarSubsector(Subsector subsector);

    void eliminarPorId(Long id);

    List<Subsector> obtenerPorSector(boolean sector);
}

