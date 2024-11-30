package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Paciente;

public class MonitoramentoController {

    // Lista para monitoramentos
    private final List<Monitoramento> monitoramentos = new ArrayList<>();

    // Lista para alertas
    private final List<Alerta> alertas = new ArrayList<>();


    public List<Monitoramento> getMonitoramentos() {
        return monitoramentos;
    }


    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }

    public Dispositivo buscarDispositivoPorId(int idDispositivo, List<Dispositivo> dispositivos) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId() == idDispositivo) {
                return dispositivo;
            }
        }
        return null;
    }


    // Método para adicionar monitoramento
    public void adicionarMonitoramento(Scanner scanner, List<Paciente> pacientes, List<Dispositivo> dispositivos) {

        // Solicitar dados da consulta
        scanner.nextLine();
        System.out.print("Digite os dados da monitoração: ");
        String dadosMonitoracao = scanner.nextLine();


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




        // Mostrar a lista de dispositivos
        System.out.println("Lista de Dispositivos:");
        for (Dispositivo dispositivo : dispositivos) {
            System.out.println("ID: " + dispositivo.getId() + " | Nome: " + dispositivo.getModelo());
        }

        // Solicitar que o usuário escolha um paciente
        System.out.print("Digite o ID do dispostivo para vincular à consulta: ");
        int idDispositivo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o paciente existe
        Dispositivo dispositivoSelecionado = buscarDispositivoPorId(idDispositivo, dispositivos);
        if (dispositivoSelecionado == null) {
            System.out.println("Dispositivo não encontrado. A consulta não será agendada.");
            return;
        }


        // Criar a consulta e adicionar à lista
        Monitoramento monitoramento = new Monitoramento(dadosMonitoracao);
        monitoramento.setIdPaciente(idPaciente); // Vincula o paciente à consulta
        monitoramento.setIdDispositivo(idDispositivo); // Vincula o médico à consulta
        monitoramentos.add(monitoramento);

        System.out.println("Monitoramento registrado com sucesso! ID: " + monitoramento.getId() +
                " | Paciente Vinculado: " + pacienteSelecionado.getNome() +
                " | Médico Vinculado: " + dispositivoSelecionado.getModelo());



    }


    public void listarMonitoramento(List<Paciente> pacientes, List<Dispositivo> dispositivos) {
        if (monitoramentos.isEmpty()) {
            System.out.println("Não há monitoramentos cadastradas.");
        } else {
            System.out.println("Lista de Monitoramentos com Pacientes e Dispositivos:");
            for (Monitoramento monitoramento : monitoramentos) {
                Paciente pacienteVinculado = buscarPacientePorId(monitoramento.getIdPaciente(), pacientes);
                Dispositivo dispositivoVinculado = buscarDispositivoPorId(monitoramento.getIdDispositivo(), dispositivos);

                // Exibindo as informações da consulta com o paciente, médico, diagnóstico e prescrição
                System.out.println("ID: " + monitoramento.getId() +
                        " | Dados monitoraçao: " + monitoramento.getDadosMonitoracao() +
                        " | Paciente: " + (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum") +
                        " | Dispositivo: " + (dispositivoVinculado != null ? dispositivoVinculado.getModelo() : "Nenhum") );
            }
        }
    }









}
