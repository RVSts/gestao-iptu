package imoveis;

public class Casa extends Imovel {
    private double areaConstruida;
    private double areaTerreno;

    public Casa(String endereco, double valorAvaliacao, Responsavel responsavel, double areaConstruida, double areaTerreno) {
        super(endereco, valorAvaliacao, responsavel);
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
        return super.descricaoDetalhada() + 
               ". Área construída: " + areaConstruida + "m², área do terreno: " + areaTerreno + "m².";
    }
}
