package Model;

public class Medico {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private int crm;
    private String nome;
    private String especialidade;
    private String email;
    private String telefone;

    // Construtor principal com todos os campos
    public Medico(int crm, String nome, String especialidade, String email, String telefone) {
        this.id = ++contadorId;
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
    }

    // Construtor simplificado (caso o CRM não seja necessário em todos os testes)
    public Medico(String nome, String especialidade) {
        this.id = ++contadorId;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = 0; // CRM não fornecido
        this.email = "não informado";
        this.telefone = "não informado";
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Medico.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método toString() para facilitar a impressão do objeto
    @Override
    public String toString() {
        return "Médico{id=" + id + ", crm=" + crm + ", nome='" + nome + "', especialidade='" + especialidade + "', email='" + email + "', telefone='" + telefone + "'}";
    }
}