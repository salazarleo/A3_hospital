package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @BeforeEach
    void setUp() {
        // Reinicia o contador de IDs antes de cada teste para garantir IDs únicos
        Paciente.setContadorId(0);
    }

    @AfterEach
    void tearDown() {
        // Reinicia o contador de IDs após cada teste para garantir que o estado não persista entre os testes
        Paciente.setContadorId(0);
    }

    @Test
    void testCriacaoPaciente() {
        // Criação de um paciente com dados fictícios
        Paciente paciente = new Paciente("12345678901", "João", 30);

        // Verifica se o ID gerado é 1 (primeiro paciente)
        assertEquals(1, paciente.getId(), "O ID do primeiro paciente deve ser 1");
        assertEquals("12345678901", paciente.getCpf(), "O CPF deve ser '12345678901'");
        assertEquals("João", paciente.getNome(), "O nome do paciente deve ser 'João'");
        assertEquals(30, paciente.getIdade(), "A idade do paciente deve ser 30");
    }

    @Test
    void testContadorIdIncrementado() {
        // Criação de dois pacientes para verificar o incremento do contador de ID
        Paciente paciente1 = new Paciente("12345678901", "João", 30);
        Paciente paciente2 = new Paciente("98765432100", "Maria", 25);

        // Verifica se o contador de ID foi incrementado corretamente
        assertEquals(2, paciente2.getId(), "O ID do segundo paciente deve ser 2");
    }

    @Test
    void testAlterarDadosPaciente() {
        // Criação de um paciente e alteração de seus dados
        Paciente paciente = new Paciente("12345678901", "João", 30);

        paciente.setCpf("98765432100");
        paciente.setNome("Carlos");
        paciente.setIdade(35);

        // Verifica se os dados foram alterados corretamente
        assertEquals("98765432100", paciente.getCpf(), "O CPF deve ser '98765432100' após alteração");
        assertEquals("Carlos", paciente.getNome(), "O nome deve ser 'Carlos' após alteração");
        assertEquals(35, paciente.getIdade(), "A idade deve ser 35 após alteração");
    }

    @Test
    void testDadosPacienteInvalido() {
        // Tenta criar um paciente com dados inválidos (nulo)
        Paciente paciente = new Paciente(null, null, -1);

        // Verifica se o paciente foi criado corretamente (não aplicável diretamente, mas serve para validar controle de dados)
        assertNull(paciente.getCpf(), "O CPF deve ser nulo");
        assertNull(paciente.getNome(), "O nome deve ser nulo");
        assertEquals(-1, paciente.getIdade(), "A idade deve ser -1 (inválida)");
    }
}
