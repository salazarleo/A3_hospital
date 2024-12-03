package Controller; // Declara o pacote onde essa classe está localizada, utilizado para organização do projeto.

import Model.Paciente; // Importa a classe Paciente do pacote Model, que será usada para manipular objetos do tipo Paciente.
import java.util.ArrayList; // Importa a classe ArrayList, usada para criar uma lista dinâmica de pacientes.
import java.util.List; // Importa a interface List, que define o comportamento da lista de pacientes.
import java.util.Scanner; // Importa a classe Scanner, usada para entrada de dados pelo usuário.

public class PacienteController { // Declara a classe PacienteController, que gerencia as operações relacionadas a pacientes.

    private final List<Paciente> pacientes = new ArrayList<>();
    // Declara e inicializa uma lista para armazenar objetos Paciente. A lista é final, indicando que sua referência não pode ser alterada.

    // Método para buscar paciente por ID
    public Paciente buscarPacientePorId(int idPaciente) {
        // Itera pela lista de pacientes e retorna o paciente cujo ID corresponde ao ID fornecido.
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                return paciente; // Retorna o paciente encontrado.
            }
        }
        return null; // Retorna null se nenhum paciente com o ID correspondente for encontrado.
    }

    public List<Paciente> getPacientes() {
        // Retorna a lista de pacientes. Útil para acessar a lista fora da classe.
        return pacientes;
    }

    // Método para registrar um paciente
    public void registrarPaciente(Scanner scanner) {
        // Lê os dados do paciente do console e adiciona o paciente à lista.

        System.out.print("Digite o CPF do paciente: ");
        // Solicita o CPF do paciente.
        String cpf = scanner.nextLine();
        // Lê a entrada do usuário como uma string.

        System.out.print("Digite o nome do paciente: ");
        // Solicita o nome do paciente.
        String nome = scanner.nextLine();
        // Lê a entrada do usuário como uma string.

        System.out.print("Digite a idade do paciente: ");
        // Solicita a idade do paciente.
        int idade = scanner.nextInt();
        // Lê a entrada do usuário como um inteiro.
        scanner.nextLine();
        // Limpa o buffer do scanner para evitar problemas na próxima leitura de string.

        Paciente paciente = new Paciente(cpf, nome, idade);
        // Cria um novo objeto Paciente com os dados fornecidos.
        pacientes.add(paciente);
        // Adiciona o paciente à lista.
        System.out.println("Paciente registrado com sucesso!");
        // Confirma o registro ao usuário.
    }

    // Método para listar todos os pacientes
    public void listarPacientes() {
        // Exibe a lista de pacientes ou informa que a lista está vazia.
        if (pacientes.isEmpty()) {
            // Verifica se a lista está vazia.
            System.out.println("Não há pacientes cadastrados.");
            // Mensagem para o usuário caso não existam pacientes.
        } else {
            System.out.println("Lista de Pacientes:");
            // Exibe o título da lista.
            for (Paciente paciente : pacientes) {
                // Itera pela lista de pacientes.
                System.out.println("ID: "+paciente.getId() + " | CPF: " + paciente.getCpf() +
                        " Nome: " + paciente.getNome() + " | Idade: " + paciente.getIdade());
                // Exibe os detalhes de cada paciente.
            }
        }
    }

    // Método para remover um paciente
    public void removerPaciente(Scanner scanner) {
        // Permite que o usuário remova um paciente fornecendo seu ID.

        System.out.println("Digite o ID do paciente a ser removido: ");
        // Solicita o ID do paciente a ser removido.
        int id = scanner.nextInt();
        // Lê o ID como um inteiro.
        scanner.nextLine();
        // Limpa o buffer do scanner.

        Paciente pacienteRemover = null;
        // Declara uma variável para armazenar o paciente a ser removido.

        for (Paciente paciente : pacientes) {
            // Itera pela lista de pacientes.
            if (paciente.getId() == id) {
                // Verifica se o ID do paciente corresponde ao fornecido.
                pacienteRemover = paciente;
                // Armazena o paciente a ser removido.
                break;
                // Sai do loop após encontrar o paciente.
            }
        }

        if (pacienteRemover != null) {
            // Verifica se um paciente foi encontrado.
            pacientes.remove(pacienteRemover);
            // Remove o paciente da lista.
            System.out.println("Paciente removido com sucesso.");
            // Confirma a remoção.
        } else {
            System.out.println("ID Inválido. Nenhum Paciente encontrado.");
            // Mensagem de erro caso o ID não corresponda a nenhum paciente.
        }
    }

    // Método para alterar os dados de um paciente
    public void alterarDadosPaciente(Scanner scanner) {
        // Permite que o usuário altere os dados de um paciente existente.

        System.out.print("Digite o ID do paciente que deseja alterar: ");
        // Solicita o ID do paciente.
        int id = scanner.nextInt();
        // Lê o ID como um inteiro.
        scanner.nextLine();
        // Limpa o buffer do scanner.

        Paciente paciente = buscarPacientePorId(id);
        // Busca o paciente com o ID fornecido.

        if (paciente == null) {
            // Verifica se o paciente foi encontrado.
            System.out.println("Paciente não encontrado.");
            // Mensagem de erro caso o paciente não seja encontrado.
            return;
            // Sai do método.
        }

        // Exibe os dados atuais do paciente.
        System.out.println("Dados atuais do paciente:");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("CPF: " + paciente.getCpf());
        System.out.println("Idade: " + paciente.getIdade());

        System.out.println("Digite os novos dados. Pressione Enter para manter os dados atuais.");
        // Instrui o usuário sobre como atualizar os dados.

        System.out.print("Novo nome (atual: " + paciente.getNome() + "): ");
        // Solicita um novo nome.
        String novoNome = scanner.nextLine();
        // Lê a entrada do usuário.
        if (!novoNome.isBlank()) {
            // Verifica se o novo nome não está em branco.
            paciente.setNome(novoNome);
            // Atualiza o nome do paciente.
        }

        System.out.print("Novo CPF (atual: " + paciente.getCpf() + "): ");
        // Solicita um novo CPF.
        String novoCpf = scanner.nextLine();
        // Lê a entrada do usuário.
        if (!novoCpf.isBlank()) {
            // Verifica se o novo CPF não está em branco.
            paciente.setCpf(novoCpf);
            // Atualiza o CPF do paciente.
        }

        System.out.print("Nova idade (atual: " + paciente.getIdade() + "): ");
        // Solicita uma nova idade.
        String novaIdade = scanner.nextLine();
        // Lê a entrada do usuário.
        if (!novaIdade.isBlank()) {
            // Verifica se a nova idade não está em branco.
            try {
                paciente.setIdade(Integer.parseInt(novaIdade));
                // Tenta converter a entrada para inteiro e atualizar a idade.
            } catch (NumberFormatException e) {
                // Captura exceções de formato inválido.
                System.out.println("Idade inválida. Dados não alterados.");
                // Mensagem de erro para idade inválida.
            }
        }

        System.out.println("Dados do paciente atualizados com sucesso.");
        // Confirma a atualização dos dados.
    }
}
