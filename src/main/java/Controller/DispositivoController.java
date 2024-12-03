package Controller;

import Model.Dispositivo;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DispositivoController {

    // Lista para armazenar os dispositivos registrados
    private final List<Dispositivo> dispositivos = new ArrayList<>();

    // Retorna a lista de dispositivos cadastrados
    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    // Método para registrar um novo dispositivo
    public void registrarDispositivo(Scanner scanner) {
        // Solicita o tipo do dispositivo
        System.out.print("Digite o tipo do dispositivo: ");
        String tipo = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer

        // Solicita a marca do dispositivo
        System.out.print("Digite a marca do dispositivo: ");
        String marca = scanner.nextLine();

        // Solicita o modelo do dispositivo
        System.out.print("Digite o modelo do dispositivo: ");
        String modelo = scanner.nextLine();

        // Solicita o status do dispositivo (ativo/inativo)
        System.out.print("Digite o status (ativo/inativo): ");
        String status = scanner.nextLine();

        // Solicita os valores de referência do dispositivo
        System.out.print("Digite os valores de referência: ");
        String valoresReferencia = scanner.nextLine();

        // Cria um novo dispositivo com as informações fornecidas
        Dispositivo dispositivo = new Dispositivo(tipo, marca, modelo, status, valoresReferencia);
        dispositivos.add(dispositivo); // Adiciona o dispositivo à lista
        System.out.println("Dispositivo registrado com sucesso: " + dispositivo);
    }

    // Método para listar todos os dispositivos registrados
    public void listarDispositivos() {
        if (dispositivos.isEmpty()) {
            System.out.println("Não há dispositivos cadastrados.");
        } else {
            System.out.println("Lista de Dispositivos:");
            // Exibe as informações do dispositivo
            for (Dispositivo dispositivo : dispositivos) {
                System.out.println("ID: " + dispositivo.getId() +
                        " | Modelo: " + dispositivo.getModelo() +
                        " | Status: " + dispositivo.getStatus());
            }
        }
    }

    // Método para remover um dispositivo
    public void removerDispositivo(Scanner scanner) {
        // Solicita o ID do dispositivo a ser removido
        System.out.print("Digite o ID do dispositivo a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Para evitar problemas com a leitura

        Dispositivo dispositivoARemover = null;

        // Busca o dispositivo pelo ID fornecido
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId() == id) {
                dispositivoARemover = dispositivo; // Encontrou o dispositivo
                break;
            }
        }

        // Remove o dispositivo caso encontrado
        if (dispositivoARemover != null) {
            dispositivos.remove(dispositivoARemover);
            System.out.println("Dispositivo removido com sucesso!");
        } else {
            System.out.println("ID inválido. Nenhum dispositivo encontrado.");
        }
    }

    // Método para vincular um dispositivo a um paciente
    public void vincularDispositivoPaciente(Scanner scanner) {
        // Solicita o ID do dispositivo e do paciente
        System.out.print("Digite o ID do dispositivo: ");
        int idDispositivo = scanner.nextInt();
        System.out.print("Digite o ID do paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Busca o dispositivo pelo ID fornecido e vincula o paciente a ele
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId() == idDispositivo) {
                dispositivo.setIdPaciente(idPaciente);
                System.out.println("Dispositivo ID " + idDispositivo + " vinculado ao Paciente ID " + idPaciente);
                return;
            }
        }

        // Caso o dispositivo não seja encontrado
        System.out.println("Dispositivo não encontrado.");
    }

    // Método auxiliar para buscar um paciente pelo ID
    public Paciente buscarPacientePorId(int idPaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente; // Retorna o paciente se encontrado
            }
        }
        return null; // Retorna null se o paciente não for encontrado
    }

    // Método para listar dispositivos vinculados aos pacientes
    public void listarDispositivosComPacientes(List<Paciente> pacientes) {
        if (dispositivos.isEmpty()) {
            System.out.println("Não há dispositivos cadastrados.");
        } else {
            System.out.println("Lista de Dispositivos e seus Pacientes:");
            for (Dispositivo dispositivo : dispositivos) {
                Integer idPaciente = dispositivo.getIdPaciente();

                // Verifica se o idPaciente não é null antes de buscar o paciente
                if (idPaciente != null) {
                    Paciente pacienteVinculado = buscarPacientePorId(idPaciente, pacientes);

                    // Exibe as informações do dispositivo e do paciente vinculado
                    System.out.println("ID: " + dispositivo.getId() + " | Modelo: " + dispositivo.getModelo() +
                            " | Paciente Vinculado: " +
                            (pacienteVinculado != null ? pacienteVinculado.getNome() : "Nenhum"));
                } else {
                    // Se idPaciente for null, o dispositivo não está vinculado a um paciente
                    System.out.println("ID: " + dispositivo.getId() + " | Modelo: " + dispositivo.getModelo() +
                            " | Paciente Vinculado: Nenhum");
                }
            }
        }
    }
}
