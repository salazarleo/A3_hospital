package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonitoramentoTest {

    @BeforeEach
    void setUp() {
        // Reseta o contador de IDs antes de cada teste para garantir IDs únicos e independentes
        Monitoramento.setContadorId(0);
    }

    @AfterEach
    void tearDown() {
        // Reseta o contador de IDs após cada teste para evitar persistência de estado
        Monitoramento.setContadorId(0);
    }

    @Test
    void testCriacaoMonitoramento() {
        // Cria um monitoramento com dados fictícios
        Monitoramento monitoramento = new Monitoramento("Pressão arterial estável");

        // Verifica se o ID gerado é 1 (primeiro monitoramento)
        assertEquals(1, monitoramento.getId(), "O ID do primeiro monitoramento deve ser 1");
        assertEquals("Pressão arterial estável", monitoramento.getDadosMonitoracao(), "Os dados de monitoramento devem ser 'Pressão arterial estável'");
        assertEquals(-1, monitoramento.getIdPaciente(), "O ID do paciente deve ser -1 quando não vinculado");
        assertEquals(-1, monitoramento.getIdDispositivo(), "O ID do dispositivo deve ser -1 quando não vinculado");
    }

    @Test
    void testContadorIdIncrementado() {
        // Cria dois monitoramentos para verificar o incremento do contador de ID
        Monitoramento monitoramento1 = new Monitoramento("Glicose normal");
        Monitoramento monitoramento2 = new Monitoramento("Temperatura corporal estável");

        // Verifica se o ID do segundo monitoramento é 2 (incremento correto)
        assertEquals(2, monitoramento2.getId(), "O ID do segundo monitoramento deve ser 2");
    }

    @Test
    void testVincularPacienteEDispositivo() {
        // Cria um monitoramento
        Monitoramento monitoramento = new Monitoramento("Oxigenação ok");

        // Vincula paciente e dispositivo ao monitoramento
        monitoramento.setIdPaciente(123);
        monitoramento.setIdDispositivo(456);

        // Verifica se os valores dos IDs foram atualizados corretamente
        assertEquals(123, monitoramento.getIdPaciente(), "O ID do paciente deve ser 123");
        assertEquals(456, monitoramento.getIdDispositivo(), "O ID do dispositivo deve ser 456");
    }

    @Test
    void testMonitoramentoSemPacienteOuDispositivo() {
        // Cria um monitoramento sem vincular paciente ou dispositivo
        Monitoramento monitoramento = new Monitoramento("Frequência cardíaca normal");

        // Verifica que os valores de paciente e dispositivo permanecem -1 (não vinculados)
        assertEquals(-1, monitoramento.getIdPaciente(), "O ID do paciente deve ser -1 quando não vinculado");
        assertEquals(-1, monitoramento.getIdDispositivo(), "O ID do dispositivo deve ser -1 quando não vinculado");
    }

    @Test
    void testAlterarDadosMonitoracao() {
        // Cria um monitoramento e altera os dados
        Monitoramento monitoramento = new Monitoramento("Temperatura elevada");
        monitoramento.setDadosMonitoracao("Temperatura normalizada");

        // Verifica se os dados de monitoramento foram alterados corretamente
        assertEquals("Temperatura normalizada", monitoramento.getDadosMonitoracao(), "Os dados de monitoramento devem ser atualizados corretamente");
    }

    @Test
    void testAlterarDadosMonitoramentoVazio() {
        // Cria um monitoramento com dados vazios e tenta alterar
        Monitoramento monitoramento = new Monitoramento("");
        monitoramento.setDadosMonitoracao("Monitoramento vazio alterado");

        // Verifica se os dados foram atualizados corretamente, mesmo com valor inicial vazio
        assertEquals("Monitoramento vazio alterado", monitoramento.getDadosMonitoracao(), "Os dados de monitoramento devem ser alterados corretamente, mesmo a partir de um valor vazio");
    }
}
