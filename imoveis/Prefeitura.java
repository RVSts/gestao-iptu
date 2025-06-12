package imoveis;

import java.util.ArrayList;
import java.util.List;

public class Prefeitura {
    private List<Imovel> imoveis;
    private List<PessoaFisica> pessoasFisicas;
    private List<PessoaJuridica> pessoasJuridicas;

    public Prefeitura() {
        this.imoveis = new ArrayList<>();
        this.pessoasFisicas = new ArrayList<>();
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void adicionarPessoaFisica(PessoaFisica pessoaFisica)
    {
        pessoasFisicas.add(pessoaFisica);
    }

    public void adicionarPessoaJuridica(PessoaJuridica pessoaJuridica)
    {
        pessoasJuridicas.add(pessoaJuridica);
    }

    public double calcularIPTUComDesconto(Imovel imovel) {
        if (imovel instanceof Terreno || imovel instanceof PontoComercial) {
            return imovel.calcularIPTU();
        }

        Responsavel responsavel = imovel.getResponsavel();

         if (responsavel instanceof PessoaFisica) {
             PessoaFisica pessoaFisica = (PessoaFisica) responsavel;
             int idade = pessoaFisica.getIdade();
             double iptu = imovel.calcularIPTU();

             if (idade >= 75){
                 return iptu * 0.85;
             } else if (idade >= 60) {
                 return iptu * 0.90;
             } else {
                 return iptu;
             }
         }
         return imovel.calcularIPTU();
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

    public List<PessoaFisica> getPessoasFisicas() { return pessoasFisicas; }
    public List<PessoaJuridica> getPessoasJuridicas() { return pessoasJuridicas; }
    public List<Imovel> getImoveis() { return imoveis;}
}