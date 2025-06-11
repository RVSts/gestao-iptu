package imoveis;

import java.util.ArrayList;
import java.util.List;

public class Prefeitura {
    private ConfiguracaoDesconto configDesconto;
    private List<Imovel> imoveis;

    public Prefeitura(ConfiguracaoDesconto configDesconto) {
        this.configDesconto = configDesconto;
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public double calcularTotalIPTUSemDesconto() {
        double total = 0;
        for (Imovel imovel : imoveis) {
            total += imovel.calcularIPTU();
        }
        return total;
    }

    public double calcularTotalIPTUComDesconto() {
        double total = 0;
        for (Imovel imovel : imoveis) {
            total += imovel.calcularIPTUComDesconto(configDesconto);
        }
        return total;
    }

    public void exibirDescricoesDetalhadas() {
        System.out.println("\n--- DESCRIÇÕES DETALHADAS DOS IMÓVEIS ---");
        for (Imovel imovel : imoveis) {
            System.out.println(imovel.descricaoDetalhada());
        }
    }

    public void exibirRelatoriosResumidos() {
        System.out.println("\n--- RELATÓRIOS RESUMIDOS DE IPTU ---");
        for (Imovel imovel : imoveis) {
            System.out.println(imovel.relatorioResumo(configDesconto));
        }
    }
}