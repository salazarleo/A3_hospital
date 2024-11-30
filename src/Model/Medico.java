package Model;

public class Medico {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private int crm;
    private String nome;
    private String especialidade;
    private String email;
    private String telefone;

    public Medico(int crm, String nome, String especialidade, String email, String telefone) {
        this.id = ++contadorId;
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
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
}
