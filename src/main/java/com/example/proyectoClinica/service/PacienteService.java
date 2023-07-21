package com.example.proyectoClinica.service;

import com.example.proyectoClinica.entity.Paciente;
import com.example.proyectoClinica.entity.PacienteDTO;
import com.example.proyectoClinica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    public void agregarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public Set<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    public Optional<Paciente> buscarPacientePorId(Long id){
        return pacienteRepository.findById(id);
    }

    public void borrarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public void modificarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }
}