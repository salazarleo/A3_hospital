package Controller;

import Model.Consulta;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaController {

    // Lista que armazena todas as consultas agendadas
    private final List<Consulta> consultas = new ArrayList<>();

    // Método que retorna a lista de todas as consultas
    public List<Consulta> getConsultas() {
        return consultas;
    }

    // Método para agendar uma nova consulta
    public void agendarConsulta(Scanner scanner, List<Paciente> pacientes, List<Medico> medicos) {
        // Solicita os dados da consulta do usuário
        scanner.nextLine();
        System.out.print("Digite a data da consulta: ");
        String data = scanner.nextLine();

        System.out.print("Digite a hora da consulta: ");
        String hora = scanner.nextLine();

        System.out.print("Digite o diagnóstico da consulta: ");
        String diagnostico = scanner.nextLine();

        System.out.print("Digite a prescrição médica do paciente: ");
        String prescricaomedica = scanner.nextLine();

        // Exibe a lista de pacientes e permite escolher um paciente
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + " | Nome: " + paciente.getNome());
        }

        // Solicita o ID do paciente a ser vinculado à consulta
        System.out.print("Digite o ID do paciente para vincular à consulta: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Verifica se o paciente existe na lista
        Paciente pacienteSelecionado = buscarPacientePorId(idPaciente, pacientes);
        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado. A consulta não será agendada.");
            return;
        }

        // Exibe a lista de médicos e permite escolher um médico
        System.out.println("Lista de Médicos:");
        for (Medico medico : medicos) {
            System.out.println("ID: " + medico.getId() + " | Nome: " + medico.getNome());
        }

        // Solicita o ID do médico a ser vinculado à consulta
        System.out.print("Digite o ID do médico para vincular à consulta: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Verifica se o médico existe na lista
        Medico medicoSelecionado = buscarMedicoPorId(idMedico, medicos);
        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado. A consulta não será agendada.");
            return;
        }

        // Cria a consulta e a adiciona à lista de consultas
        Consulta consulta = new Consulta(data, hora, diagnostico, prescricaomedica);
        consulta.setIdPaciente(idPaciente); // Vincula o paciente à consulta
        consulta.setIdMedico(idMedico); // Vincula o médico à consulta
        consultas.add(consulta);

        System.out.println("Consulta registrada com sucesso! ID: " + consulta.getId() +
                " | Paciente Vinculado: " + pacienteSelecionado.getNome() +
                " | Médico Vinculado: " + medicoSelecionado.getNome());
    }

    // Método para remover uma consulta existente
    public void removerConsulta(Scanner scanner) {
        System.out.print("Digite o ID da Consulta a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Consulta consultaARemover = null;

        // Busca a consulta pelo ID
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                consultaARemover = consulta;
                break;
            }
        }

        if (consultaARemover != null) {
            consultas.remove(consultaARemover); // Remove a consulta
            System.out.println("Consulta removida com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    // Método para listar todas as consultas com seus respectivos pacientes e médicos
    public void listarConsultasComPacientesEMedicos(List<Paciente> pacientes, List<Medico> medicos, List<Consulta> consultas) {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas cadastradas.");
        } else {
            System.out.println("Lista de consultas com Pacientes e Médicos:");
            // Itera sobre as consultas e exibe as informações
            for (Consulta consulta : consultas) {
                Paciente pacienteVinculado = buscarPacientePorId(consulta.getIdPaciente(), pacientes);
                Medico medicoVinculado = buscarMedicoPorId(consulta.getIdMedico(), medicos);

                // Exibe informações sobre a consulta, paciente, médico, diagnóstico e prescrição
                System.out.println("ID: " + consulta.getId() +
                        " | Data: " + consulta.getData() +
                        " | Hora: " + consulta.getHora() +
                        " | Paciente: " + (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum") +
                        " | Médico: " + (medicoVinculado != null ? medicoVinculado.getNome() : "Nenhum") +
                        " | Diagnóstico: " + consulta.getDiagnostico() +
                        " | Prescrição: " + consulta.getPrescricaomed());
            }
        }
    }

    // Método para buscar um paciente por ID
    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }

    // Método para buscar um médico por ID
    public Medico buscarMedicoPorId(int idMedico, List<Medico> medicos) {
        for (Medico medico : medicos) {
            if (medico.getId() == idMedico) {
                return medico;
            }
        }
        return null;
    }

    // Método para alterar uma consulta existente
    public void alterarConsulta(Scanner scanner, List<Paciente> pacientes, List<Medico> medicos) {
        System.out.print("Digite o ID da consulta que deseja alterar: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Busca a consulta pelo ID
        Consulta consulta = null;
        for (Consulta c : consultas) {
            if (c.getId() == idConsulta) {
                consulta = c;
                break;
            }
        }

        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
            return;
        }

        // Busca paciente e médico vinculados à consulta
        Paciente pacienteVinculado = buscarPacientePorId(consulta.getIdPaciente(), pacientes);
        Medico medicoVinculado = buscarMedicoPorId(consulta.getIdMedico(), medicos);

        if (pacienteVinculado == null || medicoVinculado == null) {
            System.out.println("Consulta inválida: paciente ou médico não encontrados.");
            return;
        }

        // Exibe informações atuais da consulta
        System.out.println("Consulta encontrada:");
        System.out.println("Paciente: " + pacienteVinculado.getNome());
        System.out.println("Médico: " + medicoVinculado.getNome());
        System.out.println("Diagnóstico atual: " + consulta.getDiagnostico());
        System.out.println("Prescrição atual: " + consulta.getPrescricaomed());

        // Solicita novos valores para diagnóstico e prescrição
        System.out.print("Digite o novo diagnóstico (deixe em branco para manter): ");
        String novoDiagnostico = scanner.nextLine();
        if (!novoDiagnostico.isBlank()) {
            consulta.setDiagnostico(novoDiagnostico);
        }

        System.out.print("Digite a nova prescrição (deixe em branco para manter): ");
        String novaPrescricao = scanner.nextLine();
        if (!novaPrescricao.isBlank()) {
            consulta.setPrescricaomed(novaPrescricao);
        }

        System.out.println("Consulta atualizada com sucesso!");
    }
}
