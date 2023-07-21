package com.example.proyectoClinica.service;

import com.example.proyectoClinica.entity.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void testAgregarBuscarOdontologo() {
        Odontologo odontologo = new Odontologo("Juan", "Paz", 1111);
        odontologoService.agregarOdontologo(odontologo);
        Optional<Odontologo> odontologo1 = odontologoService.buscarOdontologoPorId(1L);
        assertTrue(odontologo1 != null);
    }
}