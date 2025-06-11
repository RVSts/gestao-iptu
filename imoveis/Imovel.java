package imoveis;

public abstract class Imovel {
    private String rua;
    private int numero;
    private String bairro;
    private double valorAvaliacao;
    private Responsavel responsavel;

    public Imovel(String rua, int numero, String bairro, double valorAvaliacao, Responsavel responsavel) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.valorAvaliacao = valorAvaliacao;
        this.responsavel = responsavel;
    }

    public abstract double calcularIPTU();

    public double calcularIPTUComDesconto(ConfiguracaoDesconto config) {
        if (this instanceof Terreno) {
            return calcularIPTU(); // terrenos não têm desconto
        }
        int idade = responsavel.getIdade();
        double iptu = calcularIPTU();

        if (idade >= config.getIdadeMinima2()) {
            return iptu * (1 - config.getPercentualDesconto2()/100.0);
        } else if (idade >= config.getIdadeMinima1()) {
            return iptu * (1 - config.getPercentualDesconto1()/100.0);
        } else {
            return iptu;
        }
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public double getValorAvaliacao() {
        return valorAvaliacao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public abstract String descricaoDetalhada();

    public String relatorioResumo(ConfiguracaoDesconto config) {
        return "Responsável: " + responsavel.getNome() + " - IPTU final: R$ " + String.format("%.2f", calcularIPTUComDesconto(config));
    }
}
