package Controller;

import Model.Alerta;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlertaController {

    private final List<Alerta> alertas = new ArrayList<>(); // Lista que armazena os alertas gerados

    public List<Alerta> getAlertas() {
        return alertas; // Retorna a lista de alertas
    }

    public void gerarAlerta(Scanner scanner, List<Paciente> pacientes, List<Medico> medicos) {
        // Solicita dados para gerar o alerta
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Digite o tipo de alerta: ");
        String tipo = scanner.nextLine(); // Tipo do alerta

        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine(); // Mensagem do alerta

        System.out.print("Digite a data do alerta: ");
        String dataAlerta = scanner.nextLine(); // Data do alerta

        // Exibe lista de pacientes e solicita escolha
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + " | Nome: " + paciente.getNome());
        }

        // Solicita o ID do paciente
        System.out.print("Digite o ID do paciente para vincular ao alerta: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Verifica se o paciente existe
        Paciente pacienteSelecionado = buscarPacientePorId(idPaciente, pacientes);
        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado. O alerta não será gerado.");
            return;
        }

        // Exibe lista de médicos e solicita escolha
        System.out.println("Lista de Médicos:");
        for (Medico medico : medicos) {
            System.out.println("ID: " + medico.getId() + " | Nome: " + medico.getNome());
        }

        // Solicita o ID do médico
        System.out.print("Digite o ID do médico para vincular ao alerta: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Verifica se o médico existe
        Medico medicoSelecionado = buscarMedicoPorId(idMedico, medicos);
        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado. O alerta não será gerado.");
            return;
        }

        // Cria o alerta e adiciona à lista de alertas
        Alerta alerta = new Alerta(tipo, mensagem, dataAlerta);
        alerta.setIdPaciente(idPaciente); // Vincula o paciente ao alerta
        alerta.setIdMedico(idMedico); // Vincula o médico ao alerta
        alertas.add(alerta);

        System.out.println("Alerta registrado com sucesso! ID: " + alerta.getId() +
                " | Paciente Vinculado: " + pacienteSelecionado.getNome() +
                " | Médico Vinculado: " + medicoSelecionado.getNome());
    }

    // Método para buscar um paciente por ID
    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente; // Retorna o paciente se encontrado
            }
        }
        return null; // Retorna null caso o paciente não seja encontrado
    }

    // Método para buscar um médico por ID
    public Medico buscarMedicoPorId(int idMedico, List<Medico> medicos) {
        for (Medico medico : medicos) {
            if (medico.getId() == idMedico) {
                return medico; // Retorna o médico se encontrado
            }
        }
        return null; // Retorna null caso o médico não seja encontrado
    }

    // Método para remover um alerta
    public void removerAlerta(Scanner scanner) {
        System.out.print("Digite o ID do Alerta a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Para evitar problemas com a leitura

        Alerta alertaARemover = null;

        // Procura o alerta na lista de alertas
        for (Alerta alerta : alertas) {
            if (alerta.getId() == id) {
                alertaARemover = alerta; // Alerta encontrado
                break;
            }
        }

        if (alertaARemover != null) {
            alertas.remove(alertaARemover); // Remove o alerta
            System.out.println("Alerta removido com sucesso!");
        } else {
            System.out.println("Alerta não encontrado.");
        }
    }

    // Método para listar todos os alertas
    public void listarAlertas(List<Paciente> pacientes, List<Medico> medicos, List<Alerta> alertas) {
        if (alertas.isEmpty()) {
            System.out.println("Não há alertas cadastrados.");
        } else {
            System.out.println("Lista de alertas com Pacientes e Médicos:");
            for (Alerta alerta : alertas) {
                Paciente pacienteVinculado = buscarPacientePorId(alerta.getIdPaciente(), pacientes);
                Medico medicoVinculado = buscarMedicoPorId(alerta.getIdMedico(), medicos);

                // Exibe as informações do alerta
                System.out.println("ID: " + alerta.getId() +
                        " | Data: " + alerta.getDataAlerta() +
                        " | Tipo: " + alerta.getTipo() +
                        " | Mensagem: " + alerta.getMensagem() +
                        " | Paciente: " + (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum") +
                        " | Médico: " + (medicoVinculado != null ? medicoVinculado.getNome() : "Nenhum"));
            }
        }
    }

    // Método para gerar um alerta simples, sem interação com o usuário
    public void gerarAlertaSimples(String tipo, String mensagem, String dataAlerta, int idPaciente, int idMedico, List<Paciente> pacientes, List<Medico> medicos) {
        // Verifica se o paciente existe
        Paciente pacienteSelecionado = buscarPacientePorId(idPaciente, pacientes);
        if (pacienteSelecionado == null) {
            return;
        }

        // Verifica se o médico existe
        Medico medicoSelecionado = buscarMedicoPorId(idMedico, medicos);
        if (medicoSelecionado == null) {
            return;
        }

        // Cria e adiciona o alerta
        Alerta alerta = new Alerta(tipo, mensagem, dataAlerta);
        alerta.setIdPaciente(idPaciente);
        alerta.setIdMedico(idMedico);
        alertas.add(alerta);
    }
}
