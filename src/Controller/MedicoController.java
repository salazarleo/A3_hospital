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



}
