package Model;

public class Paciente {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String cpf;
    private String nome;
    private int idade;

    // Construtor
    public Paciente(String cpf, String nome, int idade) {
        this.id = ++contadorId; // Incrementa o contador e atribui ao paciente
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    // Getter e Setter para o contador de ID (para manipulação nos testes, se necessário)
    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Paciente.contadorId = contadorId; // Permite reiniciar o contador, útil para testes
    }

    // Getters e Setters para os atributos do paciente
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

    @Override
    public String toString() {
        return "Paciente{id=" + id + ", cpf='" + cpf + "', nome='" + nome + "', idade=" + idade + '}';
    }

}