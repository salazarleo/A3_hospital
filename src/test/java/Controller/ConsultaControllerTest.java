package Controller;

import Model.Consulta;
import Model.Paciente;
import Model.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ConsultaControllerTest {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    @BeforeEach
    void setUp() {
        // Criando instâncias de pacientes para testar
        pacientes = new ArrayList<>();
        pacientes.add(new Paciente("12345678901", "João da Silva", 30));  // Corrigido para passar CPF, Nome e Idade
        pacientes.add(new Paciente("98765432100", "Maria Oliveira", 28));  // Corrigido para passar CPF, Nome e Idade

        // Criando instâncias de médicos para testar
        medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. Alberto", "Cardiologia"));
        medicos.add(new Medico("Dra. Sofia", "Pediatria"));

        // Criando instâncias de consultas para testar
        consultas = new ArrayList<>();
        consultas.add(new Consulta("01/12/2024", "14:00", "Infecção viral", "Paracetamol"));
        consultas.add(new Consulta("02/12/2024", "15:00", "Exame de rotina", "Nenhum"));
    }

    @Test
    void testRegistrarConsulta() {
        // Definindo os médicos e pacientes nas consultas
        consultas.get(0).setIdPaciente(pacientes.get(0).getId());
        consultas.get(0).setIdMedico(medicos.get(0).getId());
        consultas.get(1).setIdPaciente(pacientes.get(1).getId());
        consultas.get(1).setIdMedico(medicos.get(1).getId());

        // Testando o método de listar consultas
        for (Consulta consulta : consultas) {
            System.out.println("Consulta ID: " + consulta.getId() + ", Data: " + consulta.getData() + ", Hora: " + consulta.getHora());
            System.out.println("Diagnóstico: " + consulta.getDiagnostico() + ", Prescrição médica: " + consulta.getPrescricaomed());
            System.out.println("Paciente ID: " + consulta.getIdPaciente() + ", Médico ID: " + consulta.getIdMedico());
            System.out.println("----------------------");

            // Testes de validação
            assertNotNull(consulta.getId(), "A consulta deve ter um ID.");
            assertNotNull(consulta.getIdPaciente(), "A consulta deve estar associada a um paciente.");
            assertNotNull(consulta.getIdMedico(), "A consulta deve estar associada a um médico.");
        }
    }
}
