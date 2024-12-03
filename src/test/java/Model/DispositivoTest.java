package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DispositivoTest {

    @BeforeEach
    void setUp() {
        // Reinicia o contador de IDs antes de cada teste
        Dispositivo.setContadorId(0);
    }

    @AfterEach
    void tearDown() {
        // Reinicia o contador de IDs após cada teste (para garantir que o estado não persista entre os testes)
        Dispositivo.setContadorId(0);
    }

    @Test
    void testCriacaoDispositivo() {
        // Cria um dispositivo com dados fictícios
        Dispositivo dispositivo = new Dispositivo("Monitor", "Samsung", "X123", "Ativo", "120-180");

        // Verifica se o ID gerado é 1 (primeiro dispositivo)
        assertEquals(1, dispositivo.getId());
    }

    @Test
    void testContadorIdIncrementado() {
        // Cria dois dispositivos para verificar o incremento do contador de ID
        Dispositivo dispositivo1 = new Dispositivo("Monitor", "Samsung", "X123", "Ativo", "120-180");
        Dispositivo dispositivo2 = new Dispositivo("Balança", "Philips", "Y456", "Inativo", "50-100");

        // Verifica se o ID do segundo dispositivo é 2 (incremento correto)
        assertEquals(2, dispositivo2.getId());
    }
}
