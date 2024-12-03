package Controller;

import Model.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MedicoControllerTest {

    private MedicoController controller;

    @BeforeEach
    void setUp() {
        controller = new MedicoController();
    }

    @Test
    void testRegistrarMedico() {
        Scanner scanner = new Scanner("123456\nDr. João\nCardiologista\ndr.joao@email.com\n(11) 98765-4321\n");
        controller.registrarMedico(scanner);

        assertEquals(1, controller.getMedicos().size(), "Deveria haver 1 médico registrado.");
        Medico medico = controller.getMedicos().get(0);
        assertEquals("Dr. João", medico.getNome());
        assertEquals("Cardiologista", medico.getEspecialidade());
    }
}
