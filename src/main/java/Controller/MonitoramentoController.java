package Controller;

import Model.Alerta;
import Model.Dispositivo;
import Model.Monitoramento;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonitoramentoController {

    // Lista para armazenar todos os monitoramentos
    private final List<Monitoramento> monitoramentos = new ArrayList<>();

    // Contador de IDs para garantir a unicidade dos IDs
    private int idCounter = 1;

    // Método para retornar a lista de monitoramentos
    public List<Monitoramento> getMonitoramentos() {
        return monitoramentos;
    }

    // Método para adicionar um novo monitoramento
    public void adicionarMonitoramento(Scanner scanner, List<Paciente> pacientes, List<Dispositivo> dispositivos) {
        try {
            // Limpa o buffer do scanner após leitura de um número para garantir que o nextLine() funcione corretamente
            scanner.nextLine();

            System.out.print("Digite os dados da monitoração: ");
            String dadosMonitoracao = scanner.nextLine();
            System.out.println("Dados monitoramento: " + dadosMonitoracao);  // Depuração para verificar os dados inseridos

            // Exibe a lista de pacientes cadastrados
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println("ID: " + paciente.getId() + " | Nome: " + paciente.getNome());
            }

            // Solicita que o usuário digite o ID de um paciente
            System.out.print("Digite o ID do paciente para vincular à consulta: ");
            int idPaciente = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            System.out.println("ID do paciente escolhido: " + idPaciente);  // Depuração

            // Verifica se o paciente existe
            Paciente pacienteSelecionado = buscarPacientePorId(idPaciente, pacientes);
            if (pacienteSelecionado == null) {
                System.out.println("Paciente não encontrado. A consulta não será agendada.");
                return;
            }

            // Exibe a lista de dispositivos cadastrados
            System.out.println("Lista de Dispositivos:");
            for (Dispositivo dispositivo : dispositivos) {
                System.out.println("ID: " + dispositivo.getId() + " | Nome: " + dispositivo.getModelo());
            }

            // Solicita que o usuário digite o ID de um dispositivo
            System.out.print("Digite o ID do dispositivo para vincular à consulta: ");
            int idDispositivo = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            System.out.println("ID do dispositivo escolhido: " + idDispositivo);  // Depuração

            // Verifica se o dispositivo existe
            Dispositivo dispositivoSelecionado = buscarDispositivoPorId(idDispositivo, dispositivos);
            if (dispositivoSelecionado == null) {
                System.out.println("Dispositivo não encontrado. A consulta não será agendada.");
                return;
            }

            // Cria um novo monitoramento, o ID será atribuído automaticamente no construtor
            Monitoramento monitoramento = new Monitoramento(dadosMonitoracao);
            monitoramento.setIdPaciente(idPaciente);  // Vincula o paciente ao monitoramento
            monitoramento.setIdDispositivo(idDispositivo);  // Vincula o dispositivo ao monitoramento

            // Adiciona o monitoramento à lista
            monitoramentos.add(monitoramento);

            // Exibe uma mensagem de sucesso com os detalhes do monitoramento
            System.out.println("Monitoramento registrado com sucesso! ID: " + monitoramento.getId() +
                    " | Paciente Vinculado: " + pacienteSelecionado.getNome() +
                    " | Dispositivo Vinculado: " + dispositivoSelecionado.getModelo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar monitoramento: " + e.getMessage());
            e.printStackTrace();  // Exibe a pilha de erros para ajudar na depuração
        }
    }

    // Método para buscar um paciente pelo ID na lista de pacientes
    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        // Percorre a lista de pacientes e retorna o paciente correspondente ao ID
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null;  // Retorna null se o paciente não for encontrado
    }

    // Método para buscar um dispositivo pelo ID na lista de dispositivos
    public Dispositivo buscarDispositivoPorId(int idDispositivo, List<Dispositivo> dispositivos) {
        // Percorre a lista de dispositivos e retorna o dispositivo correspondente ao ID
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId() == idDispositivo) {
                return dispositivo;
            }
        }
        return null;  // Retorna null se o dispositivo não for encontrado
    }

    // Método para listar todos os monitoramentos
    public void listarMonitoramento(List<Paciente> pacientes, List<Dispositivo> dispositivos) {
        // Verifica se a lista de monitoramentos está vazia
        if (monitoramentos.isEmpty()) {
            System.out.println("Não há monitoramentos cadastrados.");
        } else {
            System.out.println("Lista de Monitoramentos com Pacientes e Dispositivos:");
            // Percorre a lista de monitoramentos e exibe os dados de cada um
            for (Monitoramento monitoramento : monitoramentos) {
                // Busca o paciente e o dispositivo vinculados ao monitoramento
                Paciente pacienteVinculado = buscarPacientePorId(monitoramento.getIdPaciente(), pacientes);
                Dispositivo dispositivoVinculado = buscarDispositivoPorId(monitoramento.getIdDispositivo(), dispositivos);

                // Exibe os detalhes do monitoramento
                System.out.println("ID: " + monitoramento.getId() +
                        " | Dados monitoração: " + monitoramento.getDadosMonitoracao() +
                        " | Paciente: " + (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum") +
                        " | Dispositivo: " + (dispositivoVinculado != null ? dispositivoVinculado.getModelo() : "Nenhum"));
            }
        }
    }
}
