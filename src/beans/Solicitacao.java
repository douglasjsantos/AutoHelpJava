package beans;

public class Solicitacao {
    private String nomeMotorista;
    private double valor;
    private int distancia;

    public Solicitacao(String nomeMotorista, double valor, int distancia) {
        this.nomeMotorista = nomeMotorista;
        this.valor = valor;
        this.distancia = distancia;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
