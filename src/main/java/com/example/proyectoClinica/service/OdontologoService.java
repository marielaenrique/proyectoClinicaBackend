package com.example.proyectoClinica.service;

import com.example.proyectoClinica.entity.Odontologo;
import com.example.proyectoClinica.entity.OdontologoDTO;
import com.example.proyectoClinica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public void agregarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    public Optional<Odontologo> buscarOdontologoPorId(Long id){
        return odontologoRepository.findById(id);
    }
    public void borrarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }
    public void modificarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
}