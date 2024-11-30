package Controller;

import Model.Consulta;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaController {

    private final List<Consulta> consultas = new ArrayList<>();

    public void agendarConsulta(Scanner scanner, List<Paciente> pacientes, List<Medico> medicos) {
        // Solicitar dados da consulta
        System.out.print("Digite a data da consulta: ");
        String data = scanner.nextLine();
        scanner.nextLine(); //
        System.out.print("Digite a hora da consulta: ");
        String hora = scanner.nextLine();

        System.out.print("Digite o diagnóstico da consulta: ");
        String diagnostico = scanner.nextLine();

        System.out.print("Digite a prescrição médica do paciente: ");
        String prescricaomedica = scanner.nextLine();

        // Mostrar a lista de pacientes
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + " | Nome: " + paciente.getNome());
        }

        // Solicitar que o usuário escolha um paciente
        System.out.print("Digite o ID do paciente para vincular à consulta: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o paciente existe
        Paciente pacienteSelecionado = buscarPacientePorId(idPaciente, pacientes);
        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado. A consulta não será agendada.");
            return;
        }

        // Mostrar a lista de médicos
        System.out.println("Lista de Médicos:");
        for (Medico medico : medicos) {
            System.out.println("ID: " + medico.getId() + " | Nome: " + medico.getNome());
        }

        // Solicitar que o usuário escolha um médico
        System.out.print("Digite o ID do médico para vincular à consulta: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o médico existe
        Medico medicoSelecionado = buscarMedicoPorId(idMedico, medicos);
        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado. A consulta não será agendada.");
            return;
        }

        // Criar a consulta e adicionar à lista
        Consulta consulta = new Consulta(data, hora, diagnostico, prescricaomedica);
        consulta.setIdPaciente(idPaciente); // Vincula o paciente à consulta
        consulta.setIdMedico(idMedico); // Vincula o médico à consulta
        consultas.add(consulta);

        System.out.println("Consulta registrada com sucesso! ID: " + consulta.getId() +
                " | Paciente Vinculado: " + pacienteSelecionado.getNome() +
                " | Médico Vinculado: " + medicoSelecionado.getNome());
    }

    public void removerConsulta(Scanner scanner) {
        System.out.print("Digite o ID da Consulta a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Para evitar problemas com a leitura

        Consulta consultaARemover = null;

        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                consultaARemover = consulta;
                break;
            }
        }

        if (consultaARemover != null) {
            consultas.remove(consultaARemover);
            System.out.println("Consulta removida com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    public void listarConsultasComPacientesEMedicos(List<Paciente> pacientes, List<Medico> medicos) {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas cadastradas.");
        } else {
            System.out.println("Lista de consultas com Pacientes e Médicos:");
            for (Consulta consulta : consultas) {
                Paciente pacienteVinculado = buscarPacientePorId(consulta.getIdPaciente(), pacientes);
                Medico medicoVinculado = buscarMedicoPorId(consulta.getIdMedico(), medicos);

                // Exibindo as informações da consulta com o paciente e médico
                System.out.println("ID: " + consulta.getId() + " | Data: " + consulta.getData() +
                        " | Paciente: " + (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum") +
                        " | Médico: " + (medicoVinculado != null ? medicoVinculado.getNome() : "Nenhum"));
            }
        }
    }

    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }

    public Medico buscarMedicoPorId(int idMedico, List<Medico> medicos) {
        for (Medico medico : medicos) {
            if (medico.getId() == idMedico) {
                return medico;
            }
        }
        return null;
    }
}