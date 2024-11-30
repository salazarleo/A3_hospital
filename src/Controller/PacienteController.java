package Controller;

import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PacienteController {

    private final List<Paciente> pacientes = new ArrayList<>();

    public Paciente buscarPacientePorId(int idPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null; // Retorna null se o paciente não for encontrado
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }


    public void registrarPaciente(Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Paciente paciente = new Paciente(nome, idade, cpf);
        pacientes.add(paciente);
        System.out.println("Paciente registrado com sucesso!");
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println("ID: "+paciente.getId() +" Nome: " + paciente.getNome() + " | CPF: " + paciente.getCpf());
            }
        }

    }


    public void removerPaciente(Scanner scanner) {
        System.out.println("Digite o ID do paciente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente pacienteRemover = null;

        for(Paciente paciente : pacientes) {
            if(paciente.getId() == id) {
                pacienteRemover = paciente;
                break;
            }
        }

        if(pacienteRemover != null) {
            pacientes.remove(pacienteRemover);
            System.out.println("Paciente removido com sucesso.");
        }else{
            System.out.println("ID Invalido. Nenhum Paciente encontrado.");
        }

    }



}
