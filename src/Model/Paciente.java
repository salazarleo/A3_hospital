package Model;

public class Paciente {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String cpf;
    private String nome;
    private int idade;



    public Paciente(String cpf, String nome, int idade) {
        this.id = ++contadorId;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;

    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Paciente.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
