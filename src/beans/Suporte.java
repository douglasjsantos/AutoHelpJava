package beans;

public class Suporte {
    private Cliente cliente;
    private String reclamacao;

    public Suporte() {
    }

    public Suporte(Cliente cliente, String reclamacao) {
        this.cliente = cliente;
        this.reclamacao = reclamacao;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public void registrarReclamacao() {
        System.out.println("Reclamação registrada:");
        System.out.println("Cliente: " + cliente.getEmail());
        System.out.println("Reclamação: " + reclamacao);
    }
}
