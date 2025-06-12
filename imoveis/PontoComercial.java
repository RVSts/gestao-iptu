package imoveis;

public class PontoComercial extends Imovel {
    private double areaConstruida;
    private double areaTerreno;

    public PontoComercial(String endereco, double valorAvaliacao, Responsavel responsavel,double areaConstruida,double areaTerreno) {
        super(endereco, valorAvaliacao, responsavel);
        this.areaTerreno = areaTerreno;
        this.areaConstruida = areaConstruida;
    }

    @Override
    public double calcularIPTU() {
        return (areaConstruida * 7.50);
    }
    public String descricaoDetalhada() {
        return super.descricaoDetalhada() +
                ". Área construída: " + areaConstruida + "m², área do terreno: " + areaTerreno + "m².";
    }

    public double getAreaConst(){
        return this.areaConstruida;
    }
    public double getAreaTerr(){
        return this.areaTerreno;
    }
}