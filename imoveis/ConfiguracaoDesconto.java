package imoveis;

public class ConfiguracaoDesconto {
    private int idadeMinima1;
    private double percentualDesconto1;
    private int idadeMinima2;
    private double percentualDesconto2;

    public ConfiguracaoDesconto(int idadeMinima1, double percentualDesconto1, int idadeMinima2, double percentualDesconto2) {
        this.idadeMinima1 = idadeMinima1;
        this.percentualDesconto1 = percentualDesconto1;
        this.idadeMinima2 = idadeMinima2;
        this.percentualDesconto2 = percentualDesconto2;
    }

    public int getIdadeMinima1() {
        return idadeMinima1;
    }

    public double getPercentualDesconto1() {
        return percentualDesconto1;
    }

    public int getIdadeMinima2() {
        return idadeMinima2;
    }

    public double getPercentualDesconto2() {
        return percentualDesconto2;
    }
}
