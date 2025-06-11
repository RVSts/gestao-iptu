package imoveis;

public abstract class Imovel {
    private String endereco;
    private double valorAvaliacao;
    private Responsavel responsavel;

    public Imovel(String endereco, double valorAvaliacao, Responsavel responsavel) {
        this.endereco = endereco;
        this.valorAvaliacao = valorAvaliacao;
        this.responsavel = responsavel;
    }

    public abstract double calcularIPTU();
        

    public String getEndereco() {
        return endereco;
    }

    public double getValorAvaliacao() {
        return valorAvaliacao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }
    
    public void setEndereco(String endereco) { this.endereco = endereco; }
    
    public void setValorAvaliacao(double valorAvaliacao) { this.valorAvaliacao = valorAvaliacao; }
    
    public void setResponsavel(Responsavel responsavel) { this.responsavel = responsavel; }

    public String descricaoDetalhada(){
        return "Responsável: " + responsavel.getNome() +"Endereço: " + getEndereco()+ ". Valor de avaliação: R$" +
               String.format("%.2f", getValorAvaliacao());
    }

    public String relatorioResumo(double iptuFinal) {
        return "Responsável: " + responsavel.getNome() + " - IPTU final: R$" + 
               String.format("%.2f", iptuFinal);
    }
}
