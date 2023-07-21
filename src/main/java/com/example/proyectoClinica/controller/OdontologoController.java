package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entity.Odontologo;
import com.example.proyectoClinica.entity.OdontologoDTO;
import com.example.proyectoClinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> agregarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.agregarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> buscarOdontologoPorId(@PathVariable Long id) {
        return odontologoService.buscarOdontologoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologo(@PathVariable Long id) {
        odontologoService.borrarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> buscarTodos() {
        return odontologoService.buscarTodos();
    }
}