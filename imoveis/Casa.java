package imoveis;

public class Casa extends Imovel {
    private double areaConstruida;
    private double areaTerreno;

    public Casa(String rua, int numero, String bairro, double valorAvaliacao, Responsavel responsavel, double areaConstruida, double areaTerreno) {
        super(rua, numero, bairro, valorAvaliacao, responsavel);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    @Override
    public double calcularIPTU() {
        return getValorAvaliacao() * 0.012 + (areaConstruida * 0.50);
    }

    @Override
    public String descricaoDetalhada() {
        return "Casa na rua " + getRua() + ", nº " + getNumero() + ", bairro " + getBairro() +
               ". Área construída: " + areaConstruida + "m², área do terreno: " + areaTerreno + "m². Valor de avaliação: R$" +
               String.format("%.2f", getValorAvaliacao());
    }
}
