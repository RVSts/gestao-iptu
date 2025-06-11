package imoveis;

public class Apartamento extends Imovel {
    private int andar;
    private double areaPrivativa;

    public Apartamento(String endereco, double valorAvaliacao, Responsavel responsavel, int andar, double areaPrivativa) {
        super(endereco, valorAvaliacao, responsavel);
        this.andar = andar;
        this.areaPrivativa = areaPrivativa;
    }

    public int getAndar() {
        return andar;
    }

    public double getAreaPrivativa() {
        return areaPrivativa;
    }

    @Override
    public double calcularIPTU() {
        double iptu = getValorAvaliacao() * 0.015;
        if (andar > 10) {
            iptu -= 200.0;
        }
        return iptu;
    }

    @Override
    public String descricaoDetalhada() {
        return "Apartamento no andar " + andar + ", localizado no Endereco" + getEndereco() + ". Área privativa: " + areaPrivativa + "m². Valor de avaliação: R$" +
               String.format("%.2f", getValorAvaliacao());
    }
}
