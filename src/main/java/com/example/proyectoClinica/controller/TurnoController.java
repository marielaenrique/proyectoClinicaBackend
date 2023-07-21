package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entity.*;
import com.example.proyectoClinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> agregarTurno(@RequestBody Turno turno) {
        turnoService.agregarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Turno> buscarTurnoPorId(@PathVariable Long id) {
        return turnoService.buscarTurnoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody Turno turno) {
        turnoService.modificarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTurno(@PathVariable Long id) {
        turnoService.borrarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> buscarTodos() {
        return turnoService.buscarTodos();
    }
}