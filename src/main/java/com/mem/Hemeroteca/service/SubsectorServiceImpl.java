package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.Subsector;
import com.mem.Hemeroteca.repository.SubsectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubsectorServiceImpl implements SubsectorService {

    private final SubsectorRepository subsectorRepository;

    @Autowired
    public SubsectorServiceImpl(SubsectorRepository subsectorRepository) {
        this.subsectorRepository = subsectorRepository;
    }

    @Override
    public List<Subsector> obtenerTodos() {
        return subsectorRepository.findAll();
    }

    @Override
    public Optional<Subsector> obtenerPorId(Long id) {
        return subsectorRepository.findById(id);
    }

    @Override
    public Subsector guardarSubsector(Subsector subsector) {
        return subsectorRepository.save(subsector);
    }

    @Override
    public void eliminarPorId(Long id) {
        subsectorRepository.deleteById(id);
    }

    @Override
    public List<Subsector> obtenerPorSector(boolean sector) {
        return subsectorRepository.findBySector(sector);
    }
}
