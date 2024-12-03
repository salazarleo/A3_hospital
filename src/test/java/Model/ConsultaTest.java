package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaTest {

    @BeforeEach
    void setUp() {
        // Reinicia o contador de IDs antes de cada teste
        Consulta.setContadorId(0);
    }

    @AfterEach
    void tearDown() {
        // Reinicia o contador de IDs após cada teste (para garantir que o estado não persista entre os testes)
        Consulta.setContadorId(0);
    }

    @Test
    void testCriacaoConsulta() {
        // Cria uma consulta com dados fictícios
        Consulta consulta = new Consulta("01/01/2024", "10:00", "Gripe", "Paracetamol");

        // Verifica se o ID gerado é 1 (primeira consulta)
        assertEquals(1, consulta.getId());
    }

    @Test
    void testContadorIdIncrementado() {
        // Cria duas consultas para verificar o incremento do contador de ID
        Consulta consulta1 = new Consulta("01/01/2024", "10:00", "Gripe", "Paracetamol");
        Consulta consulta2 = new Consulta("02/01/2024", "11:00", "Resfriado", "Ibuprofeno");

        // Verifica se o ID da segunda consulta é 2 (incremento correto)
        assertEquals(2, consulta2.getId());
    }
}
