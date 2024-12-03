package Controller;

import Controller.AlertaController;
import Model.Alerta;
import Model.Medico;
import Model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlertaControllerTest {

    private AlertaController alertaController;
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    @BeforeEach
    public void setUp() {
        alertaController = new AlertaController();

        // Criar lista de pacientes
        pacientes = new ArrayList<>();
        pacientes.add(new Paciente("123.456.789-00", "Paciente 1", 30));
        pacientes.add(new Paciente("987.654.321-00", "Paciente 2", 25));

        // Criar lista de médicos
        medicos = new ArrayList<>();
        medicos.add(new Medico(1234, "Médico 1", "Cardiologista", "medico1@email.com", "1234-5678"));
        medicos.add(new Medico(5678, "Médico 2", "Dermatologista", "medico2@email.com", "2345-6789"));
    }

    @Test
    public void testGerarAlerta() {
        // Dados simulados para o alerta
        String tipo = "Urgente";
        String mensagem = "Alerta importante!";
        String dataAlerta = "2024-12-02";
        int idPaciente = 1;
        int idMedico = 2;

        // Gerar o alerta
        alertaController.gerarAlertaSimples(tipo, mensagem, dataAlerta, idPaciente, idMedico, pacientes, medicos);

        // Verificar se o alerta foi adicionado à lista
        List<Alerta> alertas = alertaController.getAlertas();
        assertEquals(1, alertas.size(), "Deve haver 1 alerta registrado");

        // Verificar os detalhes do alerta
        Alerta alerta = alertas.get(0);
        assertEquals(tipo, alerta.getTipo(), "O tipo do alerta deve ser 'Urgente'");
        assertEquals(mensagem, alerta.getMensagem(), "A mensagem do alerta deve ser 'Alerta importante!'");
        assertEquals(dataAlerta, alerta.getDataAlerta(), "A data do alerta deve ser '2024-12-02'");
        assertEquals(idPaciente, alerta.getIdPaciente(), "O ID do paciente deve ser 1");
        assertEquals(idMedico, alerta.getIdMedico(), "O ID do médico deve ser 2");
    }
}
