package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Dispositivo;
import Model.Medico;
import Model.Paciente;

import java.util.Scanner;

public class DispositivoController {


    private final List<Dispositivo> dispositivos = new ArrayList<>();


    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void registrarDispositivo(Scanner scanner) {
        System.out.print("Digite o tipo do dispositivo: ");
        String tipo = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite a marca do dispositivo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do dispositivo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o status (ativo/inativo): ");
        String status = scanner.nextLine();

        System.out.print("Digite os valores de referência: ");
        String valoresReferencia = scanner.nextLine();

        Dispositivo dispositivo = new Dispositivo(tipo, marca, modelo, status, valoresReferencia);
        dispositivos.add(dispositivo);
        System.out.println("Dispositivo registrado com sucesso: " + dispositivo);
    }


    public void listarDispositivos() {
        if (dispositivos.isEmpty()) {
            System.out.println("Não há dispositivos cadastrados.");
        } else {
            System.out.println("Lista de Dispositivos:");
            for (Dispositivo dispositivo : dispositivos) {
                System.out.println("ID: " + dispositivo.getId() +
                        " | Modelo: " + dispositivo.getModelo() +
                        " | Status: " + dispositivo.getStatus());
            }
        }
    }


    public void removerDispositivo(Scanner scanner) {
        System.out.print("Digite o ID do dispositivo a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Para evitar problemas com a leitura

        Dispositivo dispositivoARemover = null;

        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId() == id) {
                dispositivoARemover = dispositivo;
                break;
            }
        }

        if (dispositivoARemover != null) {
            dispositivos.remove(dispositivoARemover);
            System.out.println("Dispositivo removido com sucesso!");
        } else {
            System.out.println("ID inválido. Nenhum dispositivo encontrado.");
        }
    }

    public void vincularDispositivoPaciente(Scanner scanner) {
        System.out.print("Digite o ID do dispositivo: ");
        int idDispositivo = scanner.nextInt();
        System.out.print("Digite o ID do paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId() == idDispositivo) {
                dispositivo.setIdPaciente(idPaciente);
                System.out.println("Dispositivo ID " + idDispositivo + " vinculado ao Paciente ID " + idPaciente);
                return;
            }
        }

        System.out.println("Dispositivo não encontrado.");
    }

    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null; // Retorna null se o paciente não for encontrado
    }


    public void listarDispositivosComPacientes(List<Paciente> pacientes) {
        if (dispositivos.isEmpty()) {
            System.out.println("Não há dispositivos cadastrados.");
        } else {
            System.out.println("Lista de Dispositivos e seus Pacientes:");
            for (Dispositivo dispositivo : dispositivos) {
                // Buscando o paciente pelo ID
                Paciente pacienteVinculado = buscarPacientePorId(dispositivo.getIdPaciente(), pacientes);

                // Exibindo as informações do dispositivo e do paciente, caso haja vínculo
                System.out.println("ID: " + dispositivo.getId() + " | Modelo: " + dispositivo.getModelo() +
                        " | Paciente Vinculado: " +
                        (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum"));
            }
        }
    }


    }




