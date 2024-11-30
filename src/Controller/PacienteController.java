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


    public void alterarDadosPaciente(Scanner scanner) {
        System.out.print("Digite o ID do paciente que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Paciente paciente = buscarPacientePorId(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Dados atuais do paciente:");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("CPF: " + paciente.getCpf());
        System.out.println("Idade: " + paciente.getIdade());

        System.out.println("Digite os novos dados. Pressione Enter para manter os dados atuais.");

        System.out.print("Novo nome (atual: " + paciente.getNome() + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isBlank()) {
            paciente.setNome(novoNome);
        }

        System.out.print("Novo CPF (atual: " + paciente.getCpf() + "): ");
        String novoCpf = scanner.nextLine();
        if (!novoCpf.isBlank()) {
            paciente.setCpf(novoCpf);
        }

        System.out.print("Nova idade (atual: " + paciente.getIdade() + "): ");
        String novaIdade = scanner.nextLine();
        if (!novaIdade.isBlank()) {
            try {
                paciente.setIdade(Integer.parseInt(novaIdade));
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Dados não alterados.");
            }
        }

        System.out.println("Dados do paciente atualizados com sucesso.");
    }



}
