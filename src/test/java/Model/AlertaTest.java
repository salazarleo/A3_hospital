package Model;

import Model.Alerta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertaTest {

    private Alerta alerta;

    @BeforeEach
    void setUp() {
        // Inicializar o objeto Alerta antes de cada teste
        alerta = new Alerta("Emergência", "Atenção, monitoramento crítico!", "2024-12-02");
    }

    @Test
    void testAlertaCreation() {
        // Testa se o alerta é criado corretamente com o tipo, mensagem e data.
        assertNotNull(alerta);
        assertEquals("Emergência", alerta.getTipo());
        assertEquals("Atenção, monitoramento crítico!", alerta.getMensagem());
        assertEquals("2024-12-02", alerta.getDataAlerta());
    }

    @Test
    void testIdGeneration() {
        // Testa se o ID gerado é único para cada novo alerta
        Alerta alerta2 = new Alerta("Anormalidade", "Temperatura fora dos parâmetros!", "2024-12-02");
        assertNotEquals(alerta.getId(), alerta2.getId());  // IDs devem ser diferentes
    }

    @Test
    void testSettersAndGetters() {
        // Testa se os setters e getters funcionam corretamente
        alerta.setIdPaciente(1);
        alerta.setIdMedico(101);

        assertEquals(1, alerta.getIdPaciente());
        assertEquals(101, alerta.getIdMedico());
    }

    @Test
    void testStaticIdCounter() {
        // Testa se o contador de IDs está funcionando corretamente
        Alerta.setContadorId(0);  // Reiniciar contador para o teste
        Alerta alerta3 = new Alerta("Emergência", "Falha nos monitores!", "2024-12-02");
        Alerta alerta4 = new Alerta("Anormalidade", "Problema de comunicação!", "2024-12-02");

        // Verifica se os IDs foram gerados de forma sequencial
        assertEquals(1, alerta3.getId());
        assertEquals(2, alerta4.getId());
    }
}
