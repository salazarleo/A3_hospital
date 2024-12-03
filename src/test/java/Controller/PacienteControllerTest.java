package Controller;

import Model.Paciente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacienteControllerTest {

    @BeforeEach
    void setUp() {
        // Reinicia o contador de IDs antes de cada teste
        Paciente.setContadorId(0);
    }

    @AfterEach
    void tearDown() {
        // Reinicia o contador de IDs após cada teste (para garantir que o estado não persista entre testes)
        Paciente.setContadorId(0);
    }

    @Test
    void testCriacaoPaciente() {
        Paciente paciente = new Paciente("12345678901", "João", 30);

        // Verifica se o ID gerado é 1 (primeiro paciente)
        assertEquals(1, paciente.getId());
        assertEquals("12345678901", paciente.getCpf());
        assertEquals("João", paciente.getNome());
        assertEquals(30, paciente.getIdade());
    }

    @Test
    void testContadorIdIncrementado() {
        Paciente paciente1 = new Paciente("12345678901", "João", 30);
        Paciente paciente2 = new Paciente("98765432100", "Maria", 25);

        // Verifica se o contador de ID foi incrementado corretamente
        assertEquals(2, paciente2.getId()); // O segundo paciente deve ter ID 2
    }
}
