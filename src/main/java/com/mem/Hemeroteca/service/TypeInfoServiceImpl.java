package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.TypeInfo;
import com.mem.Hemeroteca.repository.TypeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeInfoServiceImpl implements TypeInfoService {

    private final TypeInfoRepository typeInfoRepository;

    @Autowired
    public TypeInfoServiceImpl(TypeInfoRepository typeInfoRepository) {
        this.typeInfoRepository = typeInfoRepository;
    }

    @Override
    public List<TypeInfo> obtenerTodos() {
        return typeInfoRepository.findAll();
    }

    @Override
    public Optional<TypeInfo> obtenerPorId(Long id) {
        return typeInfoRepository.findById(id);
    }

    @Override
    public TypeInfo guardarTypeInfo(TypeInfo typeInfo) {
        return typeInfoRepository.save(typeInfo);
    }

    @Override
    public void eliminarPorId(Long id) {
        typeInfoRepository.deleteById(id);
    }
}

