package Controller;

import Model.Alerta;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class AlertaController {

    private final List<Alerta> alertas = new ArrayList<>();

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void gerarAlerta (Scanner scanner, List<Paciente> pacientes, List<Medico> medicos) {
        // Solicitar dados da consulta
        scanner.nextLine();
        System.out.print("Digite o tipo de alerta: ");
        String tipo = scanner.nextLine();


        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();

        System.out.print("Digite a data do alerta: ");
        String dataAlerta = scanner.nextLine();


        // Mostrar a lista de pacientes
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + " | Nome: " + paciente.getNome());
        }

        // Solicitar que o usuário escolha um paciente
        System.out.print("Digite o ID do paciente para vincular ao alerta: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o paciente existe
        Paciente pacienteSelecionado = buscarPacientePorId(idPaciente, pacientes);
        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado. O alerta não será gerado.");
            return;
        }

        // Mostrar a lista de médicos
        System.out.println("Lista de Médicos:");
        for (Medico medico : medicos) {
            System.out.println("ID: " + medico.getId() + " | Nome: " + medico.getNome());
        }

        // Solicitar que o usuário escolha um médico
        System.out.print("Digite o ID do médico para vincular ao alerta: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o médico existe
        Medico medicoSelecionado = buscarMedicoPorId(idMedico, medicos);
        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado. O alerta nao será gerado.");
            return;
        }

        // Criar a consulta e adicionar à lista
        Alerta alerta = new Alerta(tipo, mensagem, dataAlerta);
        alerta.setIdPaciente(idPaciente); // Vincula o paciente à consulta
        alerta.setIdMedico(idMedico); // Vincula o médico à consulta
        alertas.add(alerta);

        System.out.println("Alerta registrado com sucesso! ID: " + alerta.getId() +
                " | Paciente Vinculado: " + pacienteSelecionado.getNome() +
                " | Médico Vinculado: " + medicoSelecionado.getNome());
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


    public void removerAlerta(Scanner scanner) {
        System.out.print("Digite o ID do Alerta a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Para evitar problemas com a leitura

        Alerta alertaARemover = null;

        for (Alerta alerta : alertas) {
            if (alerta.getId() == id) {
                alertaARemover = alerta;
                break;
            }
        }

        if (alertaARemover != null) {
            alertas.remove(alertaARemover);
            System.out.println("Alerta removido com sucesso!");
        } else {
            System.out.println("Alerta não encontrado.");
        }
    }



    public void listarAlertas(List<Paciente> pacientes, List<Medico> medicos, List<Alerta> alertas) {
        if (alertas.isEmpty()) {
            System.out.println("Não há alertas cadastrados.");
        } else {
            System.out.println("Lista de alertas com Pacientes e Médicos:");
            for (Alerta alerta : alertas) {
                Paciente pacienteVinculado = buscarPacientePorId(alerta.getIdPaciente(), pacientes);
                Medico medicoVinculado = buscarMedicoPorId(alerta.getIdMedico(), medicos);

                // Exibindo as informações da consulta com o paciente, médico, diagnóstico e prescrição
                System.out.println("ID: " + alerta.getId() +
                        " | Data: " + alerta.getDataAlerta() +
                        " | Tipo: " + alerta.getTipo() +
                        " | Mensagem: " + alerta.getMensagem() +
                        " | Paciente: " + (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum") +
                        " | Médico: " + (medicoVinculado != null ? medicoVinculado.getNome() : "Nenhum"));
            }
        }
    }

}
