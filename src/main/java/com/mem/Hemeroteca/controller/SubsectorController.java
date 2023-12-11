package com.mem.Hemeroteca.controller;

import com.mem.Hemeroteca.model.Subsector;
import com.mem.Hemeroteca.service.SubsectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subsector")
@CrossOrigin
public class SubsectorController {

    private final SubsectorService subsectorService;

    @Autowired
    public SubsectorController(SubsectorService subsectorService) {
        this.subsectorService = subsectorService;
    }

    @GetMapping
    public ResponseEntity<List<Subsector>> obtenerTodos() {
        List<Subsector> subsectorList = subsectorService.obtenerTodos();
        return new ResponseEntity<>(subsectorList, HttpStatus.OK);
    }

    @GetMapping("/by-sector/{sector}")
    public ResponseEntity<List<Subsector>> obtenerPorSector(@PathVariable boolean sector) {
        List<Subsector> subsectorList = subsectorService.obtenerPorSector(sector);
        return new ResponseEntity<>(subsectorList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Subsector> obtenerPorId(@PathVariable Long id) {
        return subsectorService.obtenerPorId(id)
                .map(subsector -> new ResponseEntity<>(subsector, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Subsector> guardarSubsector(@RequestBody Subsector subsector) {
        Subsector nuevoSubsector = subsectorService.guardarSubsector(subsector);
        return new ResponseEntity<>(nuevoSubsector, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subsector> actualizarSubsector(@PathVariable Long id, @RequestBody Subsector subsector) {
        if (subsectorService.obtenerPorId(id).isPresent()) {
            subsector.setId(id);
            Subsector actualizadoSubsector = subsectorService.guardarSubsector(subsector);
            return new ResponseEntity<>(actualizadoSubsector, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        if (subsectorService.obtenerPorId(id).isPresent()) {
            subsectorService.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

