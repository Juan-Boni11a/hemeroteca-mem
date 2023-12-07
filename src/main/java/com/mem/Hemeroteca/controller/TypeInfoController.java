package com.mem.Hemeroteca.controller;

import com.mem.Hemeroteca.model.TypeInfo;
import com.mem.Hemeroteca.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeinfo")
public class TypeInfoController {

    private final TypeInfoService typeInfoService;

    @Autowired
    public TypeInfoController(TypeInfoService typeInfoService) {
        this.typeInfoService = typeInfoService;
    }

    @GetMapping
    public ResponseEntity<List<TypeInfo>> obtenerTodos() {
        List<TypeInfo> typeInfoList = typeInfoService.obtenerTodos();
        return new ResponseEntity<>(typeInfoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeInfo> obtenerPorId(@PathVariable Long id) {
        return typeInfoService.obtenerPorId(id)
                .map(typeInfo -> new ResponseEntity<>(typeInfo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TypeInfo> guardarTypeInfo(@RequestBody TypeInfo typeInfo) {
        TypeInfo nuevoTypeInfo = typeInfoService.guardarTypeInfo(typeInfo);
        return new ResponseEntity<>(nuevoTypeInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeInfo> actualizarTypeInfo(@PathVariable Long id, @RequestBody TypeInfo typeInfo) {
        if (typeInfoService.obtenerPorId(id).isPresent()) {
            typeInfo.setId(id);
            TypeInfo actualizadoTypeInfo = typeInfoService.guardarTypeInfo(typeInfo);
            return new ResponseEntity<>(actualizadoTypeInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        if (typeInfoService.obtenerPorId(id).isPresent()) {
            typeInfoService.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

