package Model;

public class Dispositivo {
    private static int contadorId = 0; // Contador estático para IDs únicos
    private final int id;
    private String tipo;
    private String marca;
    private String modelo;
    private String status;
    private String valoresReferencia;
    private Integer idPaciente;

    public Dispositivo(String tipo, String marca, String modelo, String status, String valoresReferencia) {
        this.id = ++contadorId;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.status = status;
        this.valoresReferencia = valoresReferencia;
        this.idPaciente = null; // Inicialmente, sem vínculo
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
        Dispositivo.contadorId = contadorId;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValoresReferencia() {
        return valoresReferencia;
    }

    public void setValoresReferencia(String valoresReferencia) {
        this.valoresReferencia = valoresReferencia;
    }
}
