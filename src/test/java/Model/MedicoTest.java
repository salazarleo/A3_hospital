package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicoTest {

    @BeforeEach
    void setUp() {
        // Reseta o contador de IDs para garantir que cada teste tenha IDs únicos e reinicializados
        Medico.setContadorId(0);
    }

    @AfterEach
    void tearDown() {
        // Reseta o contador de IDs após cada teste para evitar que um ID de teste afete o outro
        Medico.setContadorId(0);
    }

    @Test
    void testCriacaoMedico() {
        // Cria um médico com todos os dados fornecidos
        Medico medico = new Medico(12345, "Dr. João", "Cardiologia", "joao@gmail.com", "987654321");

        // Verifica se o ID gerado é 1 (primeiro médico)
        assertEquals(1, medico.getId(), "O ID do primeiro médico deve ser 1");
        // Verifica os atributos do médico
        assertEquals(12345, medico.getCrm(), "O CRM do médico deve ser 12345");
        assertEquals("Dr. João", medico.getNome(), "O nome do médico deve ser 'Dr. João'");
        assertEquals("Cardiologia", medico.getEspecialidade(), "A especialidade do médico deve ser 'Cardiologia'");
        assertEquals("joao@gmail.com", medico.getEmail(), "O e-mail do médico deve ser 'joao@gmail.com'");
        assertEquals("987654321", medico.getTelefone(), "O telefone do médico deve ser '987654321'");
    }

    @Test
    void testContadorIdIncrementado() {
        // Cria dois médicos para verificar o incremento do contador de ID
        Medico medico1 = new Medico(12345, "Dr. João", "Cardiologia", "joao@gmail.com", "987654321");
        Medico medico2 = new Medico(67890, "Dr. Maria", "Pediatria", "maria@gmail.com", "912345678");

        // Verifica se o ID do segundo médico é 2 (incremento correto)
        assertEquals(2, medico2.getId(), "O ID do segundo médico deve ser 2, após o incremento do contador");
    }

    @Test
    void testMedicoSemCrm() {
        // Cria um médico sem CRM fornecido
        Medico medico = new Medico("Dr. Pedro", "Neurologia");

        // Verifica se o médico sem CRM tem o valor padrão de CRM (0) e outros valores padrão
        assertEquals(1, medico.getId(), "O ID do médico deve ser 1");
        assertEquals(0, medico.getCrm(), "O CRM do médico deve ser 0 quando não fornecido");
        assertEquals("não informado", medico.getEmail(), "O e-mail do médico deve ser 'não informado' quando não fornecido");
        assertEquals("não informado", medico.getTelefone(), "O telefone do médico deve ser 'não informado' quando não fornecido");
    }

    @Test
    void testMedicoComEmailETelefoneNaoInformados() {
        // Cria um médico sem CRM, email e telefone fornecidos
        Medico medico = new Medico("Dr. Pedro", "Neurologia");

        // Verifica os valores padrão para o e-mail e telefone
        assertEquals("não informado", medico.getEmail(), "O e-mail do médico deve ser 'não informado' quando não fornecido");
        assertEquals("não informado", medico.getTelefone(), "O telefone do médico deve ser 'não informado' quando não fornecido");
    }

    @Test
    void testAlterarDadosMedico() {
        // Cria um médico com dados iniciais
        Medico medico = new Medico(12345, "Dr. João", "Cardiologia", "joao@gmail.com", "987654321");

        // Modifica os dados do médico
        medico.setNome("Dr. João Silva");
        medico.setEspecialidade("Ortopedia");
        medico.setEmail("joao.silva@gmail.com");
        medico.setTelefone("987654322");

        // Verifica se os dados foram alterados corretamente
        assertEquals("Dr. João Silva", medico.getNome(), "O nome do médico deve ser alterado corretamente");
        assertEquals("Ortopedia", medico.getEspecialidade(), "A especialidade do médico deve ser alterada corretamente");
        assertEquals("joao.silva@gmail.com", medico.getEmail(), "O e-mail do médico deve ser alterado corretamente");
        assertEquals("987654322", medico.getTelefone(), "O telefone do médico deve ser alterado corretamente");
    }
}
