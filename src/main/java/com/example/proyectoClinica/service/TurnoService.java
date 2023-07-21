package com.example.proyectoClinica.service;

import com.example.proyectoClinica.entity.Turno;
import com.example.proyectoClinica.entity.TurnoDTO;
import com.example.proyectoClinica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    public void agregarTurno(Turno turno){
        turnoRepository.save(turno);
    }

    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno: turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

    public Optional<Turno> buscarTurnoPorId(Long id){
        return turnoRepository.findById(id);
    }

    public void borrarTurno(Long id){
        turnoRepository.deleteById(id);
    }

    public void modificarTurno(Turno turno){
        turnoRepository.save(turno);
    }
}