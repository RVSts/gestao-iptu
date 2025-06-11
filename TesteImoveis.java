import imoveis.*;

public class TesteImoveis {
    public static void main(String[] args) {

        Responsavel r1 = new Responsavel("Carlos", "111.111.111-11", 45);
        Responsavel r2 = new Responsavel("Maria", "222.222.222-22", 65);
        Responsavel r3 = new Responsavel("João", "333.333.333-33", 80);

        Imovel terreno = new Terreno("Av. Brasil, 100, Centro", 150000.00, r1, 500.0);
        Imovel casa = new Casa("Rua das Flores, 250, Jardim", 300000.00, r2, 120.0, 400.0);
        Imovel ap = new Apartamento("Rua do Sol, 50, Zona Sul", 350000.00, r3, 12, 90.0);

        Prefeitura prefeitura = new Prefeitura();
        prefeitura.adicionarImovel(terreno);
        prefeitura.adicionarImovel(casa);
        prefeitura.adicionarImovel(ap);

        System.out.println("### TOTAL DE IPTU SEM DESCONTO: R$ " + 
            String.format("%.2f", prefeitura.calcularTotalIPTUSemDesconto()));
        
        System.out.println("### TOTAL DE IPTU COM DESCONTO: R$ " + 
            String.format("%.2f", prefeitura.calcularTotalIPTUComDesconto()));
        
        prefeitura.exibirDescricoesDetalhadas();
        prefeitura.exibirRelatoriosResumidos();
    }
}
