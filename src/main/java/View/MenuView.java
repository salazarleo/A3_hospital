package View;

import Controller.*;

import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);
    private final PacienteController pacienteController = new PacienteController();
    private final MedicoController medicoController = new MedicoController();
    private final DispositivoController dispositivoController = new DispositivoController();
    private final ConsultaController consultaController = new ConsultaController();
    private final MonitoramentoController monitoramentoController = new MonitoramentoController();
    private final AlertaController alertaController = new AlertaController();


    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n----- MENU PRINCIPAL -----");
            System.out.println("1. Menu Pacientes");
            System.out.println("2. Menu Médicos");
            System.out.println("3. Menu Dispositivos");
            System.out.println("4. Agendar Consulta");
            System.out.println("5. Monitoramento");
            System.out.println("6. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> exibirMenuPacientes();
                case 2 -> exibirMenuMedicos();
                case 3 -> exibirMenuDispositivos();
                case 4 -> agendarConsulta();
                case 5 -> monitorar();
                case 6 -> System.out.println("\nSaindo... Até logo!");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 6);
    }

    private void exibirMenuPacientes() {
        int opcao;
        do {
            System.out.println("\n----- MENU PACIENTES -----");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Remover Pacientes");
            System.out.println("4. Alterar Dados Pacientes");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> pacienteController.registrarPaciente(scanner);
                case 2 -> pacienteController.listarPacientes();
                case 3 -> pacienteController.removerPaciente(scanner);
                case 4 -> pacienteController.alterarDadosPaciente(scanner);
                case 5 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 5);
    }


    private void exibirMenuMedicos() {
        int opcao;
        do {
            System.out.println("\n----- MENU MÉDICOS -----");
            System.out.println("1. Registrar Médico");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Remover Médicos");
            System.out.println("4. Alterar Dados Médicos");
            System.out.println("5. Ajustar Plano Paciente");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> medicoController.registrarMedico(scanner);
                case 2 -> medicoController.listarMedicos();
                case 3 -> medicoController.removerMedico(scanner);
                case 4 -> medicoController.alterarDadosMedico(scanner);
                case 5 -> consultaController.alterarConsulta(scanner, pacienteController.getPacientes(), medicoController.getMedicos());
                case 6 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 6);
    }

    private void exibirMenuDispositivos() {
        int opcao;
        do {
            System.out.println("\n----- MENU DISPOSITIVOS -----");
            System.out.println("1. Cadastrar Dispositivo");
            System.out.println("2. Listar Dispositivos");
            System.out.println("3. Remover Dispositivo");
            System.out.println("4. Vincular Dispositivo a Paciente");
            System.out.println("5. Listar Dispositivo com Pacientes");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> dispositivoController.registrarDispositivo(scanner);
                case 2 -> dispositivoController.listarDispositivos();
                case 3 -> dispositivoController.removerDispositivo(scanner);
                case 4 -> dispositivoController.vincularDispositivoPaciente(scanner);
                case 5 -> dispositivoController.listarDispositivosComPacientes(pacienteController.getPacientes());
                case 6 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 6);
    }

    private void agendarConsulta() {
        int opcao;
        do {
            System.out.println("\n----- AGENDAR CONSULTA -----");
            System.out.println("1. Criar Consulta");
            System.out.println("2. Remover Consulta");
            System.out.println("3. Listar Consultas");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> consultaController.agendarConsulta(scanner, pacienteController.getPacientes(), medicoController.getMedicos());
                case 2 -> consultaController.removerConsulta(scanner);
                case 3 -> consultaController.listarConsultasComPacientesEMedicos(pacienteController.getPacientes(), medicoController.getMedicos(), consultaController.getConsultas());
                case 4 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        }while (opcao != 4);
    }



    private void monitorar() {
        int opcao;
        do {
            System.out.println("\n----- MENU MONITORAÇÃO -----");
            System.out.println("1. Registrar Monitoramento");
            System.out.println("2. Listar Monitoramentos");
            System.out.println("3. Gerar Alerta");
            System.out.println("4. Remover Alertas");
            System.out.println("5. Listar Alertas");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> monitoramentoController.adicionarMonitoramento(scanner, pacienteController.getPacientes(), dispositivoController.getDispositivos());
                case 2 -> monitoramentoController.listarMonitoramento(pacienteController.getPacientes(), dispositivoController.getDispositivos());
                case 3 -> alertaController.gerarAlerta(scanner, pacienteController.getPacientes(), medicoController.getMedicos());
                case 4 -> alertaController.removerAlerta(scanner);
                case 5 -> alertaController.listarAlertas(pacienteController.getPacientes(), medicoController.getMedicos(), alertaController.getAlertas());
                case 6 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 6);
    }




    private int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

}