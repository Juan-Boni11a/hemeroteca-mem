package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.Medios;

import java.util.List;
import java.util.Optional;

public interface MediosServicio {

    List<Medios> obtenerTodos();

    Optional<Medios> obtenerPorId(Long id);

    Medios guardarMedios(Medios medios);

    void eliminarPorId(Long id);
}

