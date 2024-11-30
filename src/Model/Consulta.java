package Model;

public class Consulta {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String data;
    private String hora;
    private String diagnostico;
    private String prescricaomed;
    private Integer idPaciente;
    private int idMedico;

    public Consulta(String data, String hora, String diagnostico, String prescricaomed) {
        this.id = ++contadorId;
        this.data = data;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.prescricaomed = prescricaomed;
        this.idPaciente = null; // Inicialmente, sem vínculo
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Consulta.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricaomed() {
        return prescricaomed;
    }

    public void setPrescricaomed(String prescricaomed) {
        this.prescricaomed = prescricaomed;
    }
}
