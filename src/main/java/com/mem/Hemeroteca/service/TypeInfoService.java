package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.TypeInfo;

import java.util.List;
import java.util.Optional;

public interface TypeInfoService {

    List<TypeInfo> obtenerTodos();

    Optional<TypeInfo> obtenerPorId(Long id);

    TypeInfo guardarTypeInfo(TypeInfo typeInfo);

    void eliminarPorId(Long id);
}

