package Controller;

import Model.Dispositivo;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class DispositivoControllerTest {

    @Test
    public void testRegistrarDispositivo() {
        // Simulando a entrada do usuário
        String input = "Tipo de Dispositivo\nMarca do Dispositivo\nModelo do Dispositivo\nativo\n100, 200, 300\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Instanciando o Scanner e a lógica de registro do dispositivo
        Scanner scanner = new Scanner(System.in);
        String tipo = scanner.nextLine();
        String marca = scanner.nextLine();
        String modelo = scanner.nextLine();
        String status = scanner.nextLine();
        String valoresReferencia = scanner.nextLine();

        // Criando o objeto Dispositivo
        Dispositivo dispositivo = new Dispositivo(tipo, marca, modelo, status, valoresReferencia);

        // Registrando o dispositivo (simulando o sucesso)
        boolean registrado = dispositivo.registrar();

        // Verificações
        assertEquals("Tipo de Dispositivo", tipo);
        assertEquals("Marca do Dispositivo", marca);
        assertEquals("Modelo do Dispositivo", modelo);
        assertEquals("ativo", status);
        assertEquals("100, 200, 300", valoresReferencia);

        // Verificando se o dispositivo foi registrado com sucesso
        assertTrue(registrado);

        // Verificando se o ID do dispositivo é único
        assertEquals(1, dispositivo.getId()); // Como é o primeiro dispositivo, o ID deve ser 1

        // Criando outro dispositivo para verificar o ID único
        Dispositivo dispositivo2 = new Dispositivo("Tipo 2", "Marca 2", "Modelo 2", "inativo", "400, 500, 600");

        // Verificando se o ID do segundo dispositivo é diferente
        assertEquals(2, dispositivo2.getId()); // O ID do segundo dispositivo deve ser 2

        // Verificando o vínculo com o paciente (inicialmente, sem vínculo)
        assertNull(dispositivo.getIdPaciente());

        // Teste de alteração do vínculo com paciente
        dispositivo.setIdPaciente(123);
        assertEquals(123, dispositivo.getIdPaciente());
    }
}
