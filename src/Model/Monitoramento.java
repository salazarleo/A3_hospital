package Model;

public class Monitoramento {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String dadosMonitoracao;
    private Integer idPaciente;
    private Integer idDispositivo;
    public Monitoramento(String dadosMonitoracao) {
        this.id = ++contadorId;
        this.dadosMonitoracao = dadosMonitoracao;
        this.idPaciente = null; // Inicialmente, sem vínculo
        this.idDispositivo = null; // Inicialmente, sem vínculo
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Monitoramento.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getDadosMonitoracao() {
        return dadosMonitoracao;
    }

    public void setDadosMonitoracao(String dadosMonitoracao) {
        this.dadosMonitoracao = dadosMonitoracao;
    }
}
