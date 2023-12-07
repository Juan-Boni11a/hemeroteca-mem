package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.Medios;
import com.mem.Hemeroteca.repository.MediosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediosServicioImpl implements MediosServicio {

    private final MediosRepository mediosRepository;

    @Autowired
    public MediosServicioImpl(MediosRepository mediosRepository) {
        this.mediosRepository = mediosRepository;
    }

    @Override
    public List<Medios> obtenerTodos() {
        return mediosRepository.findAll();
    }

    @Override
    public Optional<Medios> obtenerPorId(Long id) {
        return mediosRepository.findById(id);
    }

    @Override
    public Medios guardarMedios(Medios medios) {
        return mediosRepository.save(medios);
    }

    @Override
    public void eliminarPorId(Long id) {
        mediosRepository.deleteById(id);
    }
}

