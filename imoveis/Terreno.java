package imoveis;

public class Terreno extends Imovel {
    private double areaTotal;

    public Terreno(String rua, int numero, String bairro, double valorAvaliacao, Responsavel responsavel, double areaTotal) {
        super(rua, numero, bairro, valorAvaliacao, responsavel);
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
        return "Terreno na rua " + getRua() + ", nº " + getNumero() + ", bairro " + getBairro() +
               ". Área total: " + areaTotal + "m². Valor de avaliação: R$" + String.format("%.2f", getValorAvaliacao());
    }
}
