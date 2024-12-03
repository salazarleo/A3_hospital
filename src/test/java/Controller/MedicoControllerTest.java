package Controller;

import Model.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        // Preparando a entrada simulada (Scanner)
        Scanner scanner = new Scanner("123456\nDr. João\nCardiologista\ndr.joao@email.com\n(11) 98765-4321\n");

        // Registrando o médico
        controller.registrarMedico(scanner);

        // Verificando se o médico foi registrado corretamente
        List<Medico> medicos = controller.getMedicos();
        assertEquals(1, medicos.size(), "Deveria haver 1 médico registrado.");
        Medico medico = medicos.get(0);

        // Testando as propriedades do médico
        assertAll("Verificar dados do médico",
                () -> assertEquals("Dr. João", medico.getNome(), "Nome do médico deve ser 'Dr. João'"),
                () -> assertEquals("Cardiologista", medico.getEspecialidade(), "Especialidade do médico deve ser 'Cardiologista'"),
                () -> assertEquals("dr.joao@email.com", medico.getEmail(), "Email do médico não corresponde."),
                () -> assertEquals("(11) 98765-4321", medico.getTelefone(), "Telefone do médico não corresponde.")
        );
    }
}
