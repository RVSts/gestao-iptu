package imoveis;

public class Terreno extends Imovel {
    private double areaTotal;

    public Terreno(String endereco, double valorAvaliacao, Responsavel responsavel, double areaTotal) {
        super(endereco, valorAvaliacao, responsavel);
        this.areaTotal = areaTotal;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    @Override
    public double calcularIPTU() {
        return getValorAvaliacao() * 0.01;
    }

    @Override
    public String descricaoDetalhada() {
        return "Endereço: " + getEndereco() +
               ". Área total: " + areaTotal + "m². Valor de avaliação: R$" + String.format("%.2f", getValorAvaliacao());
    }
}
