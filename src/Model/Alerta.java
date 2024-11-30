package Model;

import java.time.LocalDateTime;

public class Alerta {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String tipo; // Emergência ou anormalidade
    private String mensagem;
    private String dataAlerta;
    private Integer idPaciente;
    private Integer idMedico;

    public Alerta(String tipo, String mensagem, String dataAlerta) {
        this.id = ++contadorId;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.dataAlerta = dataAlerta;
        this.idPaciente = null;
        this.idMedico = null;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Alerta.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(String dataAlerta) {
        this.dataAlerta = dataAlerta;
    }
}
