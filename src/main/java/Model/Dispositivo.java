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

    // Construtor
    public Dispositivo(String tipo, String marca, String modelo, String status, String valoresReferencia) {
        this.id = ++contadorId; // Gera ID único
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.status = status;
        this.valoresReferencia = valoresReferencia;
        this.idPaciente = null; // Inicialmente, sem vínculo
    }

    // Método para simular o registro
    public boolean registrar() {
        // Simula o sucesso do registro (poderia ser uma operação de banco de dados, por exemplo)
        return true;
    }

    // Getters e setters
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

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    // Método toString para facilitar a depuração
    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", status='" + status + '\'' +
                ", valoresReferencia='" + valoresReferencia + '\'' +
                ", idPaciente=" + (idPaciente != null ? idPaciente : "Sem vínculo") +
                '}';
    }

    // Método estático para permitir reiniciar o contador de IDs, necessário para testes
    public static void setContadorId(int valor) {
        contadorId = valor;
    }
}
