package com.mem.Hemeroteca.controller;

import com.mem.Hemeroteca.model.Medios;
import com.mem.Hemeroteca.service.MediosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medios")
@CrossOrigin
public class MediosController {

    private final MediosServicio mediosServicio;

    @Autowired
    public MediosController(MediosServicio mediosServicio) {
        this.mediosServicio = mediosServicio;
    }

    @GetMapping
    public ResponseEntity<List<Medios>> obtenerTodos() {
        List<Medios> mediosList = mediosServicio.obtenerTodos();
        return new ResponseEntity<>(mediosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medios> obtenerPorId(@PathVariable Long id) {
        return mediosServicio.obtenerPorId(id)
                .map(medios -> new ResponseEntity<>(medios, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Medios> guardarMedios(@RequestBody Medios medios) {
        Medios nuevoMedios = mediosServicio.guardarMedios(medios);
        return new ResponseEntity<>(nuevoMedios, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medios> actualizarMedios(@PathVariable Long id, @RequestBody Medios medios) {
        if (mediosServicio.obtenerPorId(id).isPresent()) {
            medios.setId(id);
            Medios actualizadoMedios = mediosServicio.guardarMedios(medios);
            return new ResponseEntity<>(actualizadoMedios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        if (mediosServicio.obtenerPorId(id).isPresent()) {
            mediosServicio.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

