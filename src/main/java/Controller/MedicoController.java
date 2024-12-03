package Controller;

import Model.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController {
    // Atributo que armazena a lista de médicos registrados
    private List<Medico> medicos;

    // Construtor da classe, inicializa a lista de médicos
    public MedicoController() {
        this.medicos = new ArrayList<>();
    }

    // Getter para obter a lista de médicos
    public List<Medico> getMedicos() {
        return medicos;
    }

    // Método para registrar um novo médico
    public void registrarMedico(Scanner scanner) {
        // Solicita o CRM do médico
        System.out.print("Digite o crm do medico: ");
        int crm = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Solicita o nome do médico
        System.out.print("Digite o nome do medico: ");
        String nome = scanner.nextLine();

        // Solicita a especialidade do médico
        System.out.print("Digite a especialidade do medico: ");
        String especialidade = scanner.nextLine();

        // Solicita o email do médico
        System.out.print("Digite o email do medico: ");
        String email = scanner.nextLine();

        // Solicita o telefone do médico
        System.out.print("Digite o telefone do medico: ");
        String telefone = scanner.nextLine();

        // Cria um novo objeto Medico e adiciona à lista de médicos
        Medico medico = new Medico(crm, nome, especialidade, email, telefone);
        medicos.add(medico);

        // Exibe mensagem de sucesso
        System.out.println("Médico " + nome + " registrado com sucesso.");
    }

    // Método para listar todos os médicos cadastrados
    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Não há médicos cadastrados.");
        } else {
            System.out.println("Lista de Médicos:");
            // Exibe o ID, nome e CRM de cada médico
            for (Medico medico : medicos) {
                System.out.println("ID: " + medico.getId() + " Nome: " + medico.getNome() + " | CRM: " + medico.getCrm());
            }
        }
    }

    // Método para remover um médico da lista
    public void removerMedico(Scanner scanner) {
        // Solicita o ID do médico a ser removido
        System.out.println("Digite o ID do medico a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Medico medicoRemover = null;

        // Busca o médico com o ID informado na lista de médicos
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                medicoRemover = medico;
                break;
            }
        }

        // Se o médico foi encontrado, remove da lista e exibe mensagem de sucesso
        if (medicoRemover != null) {
            medicos.remove(medicoRemover);
            System.out.println("Médico removido com sucesso.");
        } else {
            // Se o médico não for encontrado, exibe mensagem de erro
            System.out.println("ID inválido. Nenhum médico encontrado.");
        }
    }

    // Método para alterar os dados de um médico
    public void alterarDadosMedico(Scanner scanner) {
        // Solicita o ID do médico que deseja alterar
        System.out.print("Digite o ID do médico que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Busca o médico pelo ID
        Medico medico = buscarMedicoPorId(id);

        // Se o médico não for encontrado, exibe mensagem de erro
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        // Exibe os dados atuais do médico
        System.out.println("Dados atuais do médico:");
        System.out.println("Nome: " + medico.getNome());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialidade: " + medico.getEspecialidade());
        System.out.println("Email: " + medico.getEmail());
        System.out.println("Telefone: " + medico.getTelefone());

        // Solicita os novos dados, permitindo que o usuário pressione Enter para manter os dados atuais
        System.out.println("Digite os novos dados. Pressione Enter para manter os dados atuais.");

        // Solicita o novo nome
        System.out.print("Novo nome (atual: " + medico.getNome() + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isBlank()) {
            medico.setNome(novoNome);
        }

        // Solicita a nova especialidade
        System.out.print("Nova especialidade (atual: " + medico.getEspecialidade() + "): ");
        String novaEspecialidade = scanner.nextLine();
        if (!novaEspecialidade.isBlank()) {
            medico.setEspecialidade(novaEspecialidade);
        }

        // Solicita o novo email
        System.out.print("Novo email (atual: " + medico.getEmail() + "): ");
        String novoEmail = scanner.nextLine();
        if (!novoEmail.isBlank()) {
            medico.setEmail(novoEmail);
        }

        // Solicita o novo telefone
        System.out.print("Novo telefone (atual: " + medico.getTelefone() + "): ");
        String novoTelefone = scanner.nextLine();
        if (!novoTelefone.isBlank()) {
            medico.setTelefone(novoTelefone);
        }

        // Exibe mensagem de sucesso após a atualização
        System.out.println("Dados do médico atualizados com sucesso.");
    }

    // Método para buscar um médico pelo ID
    public Medico buscarMedicoPorId(int idMedico) {
        // Percorre a lista de médicos e retorna o médico com o ID correspondente
        for (Medico medico : medicos) {
            if (medico.getId() == idMedico) {
                return medico;
            }
        }
        // Retorna null se não encontrar o médico
        return null;
    }
}
