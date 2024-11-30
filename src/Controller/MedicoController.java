package Controller;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController {
    private List<Medico> medicos;

    public MedicoController() {
        this.medicos = new ArrayList<>();
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void registrarMedico(Scanner scanner) {

        System.out.print("Digite o crm do medico: ");
        int crm = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o nome do medico: ");
        String nome = scanner.nextLine();


        System.out.print("Digite a especialidade do medico: ");
        String especialidade = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o email do medico: ");
        String email = scanner.nextLine();


        System.out.print("Digite o telefone do medico: ");
        String telefone = scanner.nextLine();




        Medico medico = new Medico( crm, nome,  especialidade, email, telefone);
        medicos.add(medico);
        System.out.println("Médico " + nome + " registrado com sucesso.");
    }



    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Medico medico : medicos) {
                System.out.println( "ID: " + medico.getId() + " Nome: " + medico.getNome() + " | CRM: " + medico.getCrm());
            }
        }

    }



    public void removerMedico(Scanner scanner) {
        System.out.println("Digite o ID do medico a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Medico medicoRemover = null;

        for(Medico medico : medicos) {
            if(medico.getId() == id) {
                medicoRemover = medico;
                break;
            }
        }

        if(medicoRemover != null) {
            medicos.remove(medicoRemover);
            System.out.println("Medico removido com sucesso.");
        }else{
            System.out.println("ID Invalido. Nenhum Medico encontrado.");
        }

    }


    public void alterarDadosMedico(Scanner scanner) {
        System.out.print("Digite o ID do médico que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Medico medico = buscarMedicoPorId(id);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.println("Dados atuais do médico:");
        System.out.println("Nome: " + medico.getNome());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialidade: " + medico.getEspecialidade());
        System.out.println("Email: " + medico.getEmail());
        System.out.println("Telefone: " + medico.getTelefone());

        System.out.println("Digite os novos dados. Pressione Enter para manter os dados atuais.");

        System.out.print("Novo nome (atual: " + medico.getNome() + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isBlank()) {
            medico.setNome(novoNome);
        }

        System.out.print("Nova especialidade (atual: " + medico.getEspecialidade() + "): ");
        String novaEspecialidade = scanner.nextLine();
        if (!novaEspecialidade.isBlank()) {
            medico.setEspecialidade(novaEspecialidade);
        }

        System.out.print("Novo email (atual: " + medico.getEmail() + "): ");
        String novoEmail = scanner.nextLine();
        if (!novoEmail.isBlank()) {
            medico.setEmail(novoEmail);
        }

        System.out.print("Novo telefone (atual: " + medico.getTelefone() + "): ");
        String novoTelefone = scanner.nextLine();
        if (!novoTelefone.isBlank()) {
            medico.setTelefone(novoTelefone);
        }

        System.out.println("Dados do médico atualizados com sucesso.");
    }

    public Medico buscarMedicoPorId(int idMedico) {
        for (Medico medico : medicos) {
            if (medico.getId() == idMedico) {
                return medico;
            }
        }
        return null; // Retorna null se o médico não for encontrado
    }

}
