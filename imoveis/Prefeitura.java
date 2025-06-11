package imoveis;

import java.util.ArrayList;
import java.util.List;

public class Prefeitura {
    private List<Imovel> imoveis;

    public Prefeitura() {
        this.configDesconto = configDesconto;
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }
    
    public double calcularIPTUComDesconto(Imovel imovel) {
        if (imovel instanceof Terreno || imovel instanceof PontoComercial) {
            return imovel.calcularIPTU();
        }
        
        int idade = imovel.getResponsavel().getIdade();
        double iptu = imovel.calcularIPTU();

        if (idade >= 75) {
            return iptu * (1 - 0.15);
        } else if (idade >= 60) {
            return iptu * (1 - 0.1);
        } else {
            return iptu;
        }
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
            total += calcularIPTUComDesconto(imovel);
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
            double iptuFinal = calcularIPTUComDesconto(imovel);
            System.out.println(imovel.relatorioResumo(iptuFinal));
        }
    }
}
