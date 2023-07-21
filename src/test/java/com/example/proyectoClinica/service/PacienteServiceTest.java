package com.example.proyectoClinica.service;

import com.example.proyectoClinica.entity.Domicilio;
import com.example.proyectoClinica.entity.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    public void testAgregarBuscarPaciente() {
        Paciente paciente = new Paciente("Juan", "Paz", 1111, new Domicilio());
        pacienteService.agregarPaciente(paciente);
        Optional<Paciente> paciente1 = pacienteService.buscarPacientePorId(1L);
        assertTrue(paciente1 != null);
    }
}