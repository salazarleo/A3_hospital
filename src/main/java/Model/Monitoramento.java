package Model;

public class Monitoramento {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String dadosMonitoracao;
    private int idPaciente; // Usando 'int' ao invés de Integer
    private int idDispositivo; // Usando 'int' ao invés de Integer

    // Construtor
    public Monitoramento(String dadosMonitoracao) {
        this.id = ++contadorId;
        this.dadosMonitoracao = dadosMonitoracao;
        this.idPaciente = -1; // Representando ausência de vínculo com valor negativo
        this.idDispositivo = -1; // Representando ausência de vínculo com valor negativo
    }

    // Getter para ID
    public int getId() {
        return id;
    }

    // Getters e Setters para outros campos
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getDadosMonitoracao() {
        return dadosMonitoracao;
    }

    public void setDadosMonitoracao(String dadosMonitoracao) {
        this.dadosMonitoracao = dadosMonitoracao;
    }

    // Método estático para obter o contador de IDs (se necessário)
    public static int getContadorId() {
        return contadorId;
    }

    // Método estático para reiniciar o contador de IDs
    public static void setContadorId(int valor) {
        contadorId = valor;
    }
}
