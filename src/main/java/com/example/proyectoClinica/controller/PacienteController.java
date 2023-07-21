package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entity.Paciente;
import com.example.proyectoClinica.entity.PacienteDTO;
import com.example.proyectoClinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> agregarPaciente(@RequestBody Paciente paciente) {
        pacienteService.agregarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Paciente> buscarPacientePorId(@PathVariable Long id) {
        return pacienteService.buscarPacientePorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody Paciente paciente) {
        pacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Long id) {
        pacienteService.borrarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> buscarTodos() {
        return pacienteService.buscarTodos();
    }
}