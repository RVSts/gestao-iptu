import imoveis.*;
import java.util.Scanner;

public class TesteImoveis {
    public static void main(String[] args) {
        Prefeitura prefeitura = new Prefeitura();
        Scanner sc = new Scanner(System.in);

        // Cadastro de responsáveis
        cadastrarResponsaveis(prefeitura);

        // Cadastro de imóveis
        cadastrarImoveis(prefeitura, sc);

        // Testes de funcionalidades
        testarFuncionalidades(prefeitura);

        sc.close();
    }

    private static void cadastrarResponsaveis(Prefeitura prefeitura) {
        // Cadastro de pessoas físicas
        prefeitura.adicionarPessoaFisica(new PessoaFisica("João Silva", "12345678901", 65));
        prefeitura.adicionarPessoaFisica(new PessoaFisica("Maria Souza", "98765432100", 75));

        // Cadastro de pessoas jurídicas
        prefeitura.adicionarPessoaJuridica(new PessoaJuridica("Empresa ABC", "11222333000144", 1990));
        prefeitura.adicionarPessoaJuridica(new PessoaJuridica("Comércio XYZ", "55666777000188", 2005));

        System.out.println("Responsáveis cadastrados com sucesso!");
    }

    private static void cadastrarImoveis(Prefeitura prefeitura, Scanner sc) {
        // Obtendo responsáveis cadastrados
        PessoaFisica pf1 = prefeitura.getPessoasFisicas().get(0);
        PessoaFisica pf2 = prefeitura.getPessoasFisicas().get(1);
        PessoaJuridica pj1 = prefeitura.getPessoasJuridicas().get(0);
        PessoaJuridica pj2 = prefeitura.getPessoasJuridicas().get(1);

        // Cadastrando diferentes tipos de imóveis
        prefeitura.adicionarImovel(new Terreno("Rua das Flores, 100", 150000.0, pf1, 500.0));
        prefeitura.adicionarImovel(new Casa("Av. Principal, 500", 350000.0, pf2, 180.0, 300.0));
        prefeitura.adicionarImovel(new Apartamento("Rua Alto, 200 - Bloco B", 420000.0, pf1, 12, 85.0));

        // Ponto comercial obrigatoriamente com PJ
        prefeitura.adicionarImovel(new PontoComercial("Av. Comercial, 1000", 0.0, pj1, 120.0, 200.0));

        System.out.println("\nImóveis cadastrados:");
        System.out.println("- Terreno para " + pf1.getNome());
        System.out.println("- Casa para " + pf2.getNome());
        System.out.println("- Apartamento para " + pf1.getNome());
        System.out.println("- Ponto Comercial para " + pj1.getNome());
    }

    private static void testarFuncionalidades(Prefeitura prefeitura) {
        System.out.println("\n=== TESTES DE FUNCIONALIDADES ===");

        // 1. Exibir descrições detalhadas
        System.out.println("\nDescrições detalhadas dos imóveis:");
        prefeitura.exibirDescricoesDetalhadas();

        // 2. Exibir relatórios resumidos de IPTU
        System.out.println("\nRelatórios resumidos de IPTU:");
        prefeitura.exibirRelatoriosResumidos();

        // 3. Calcular totais de IPTU
        System.out.printf("\nTotal IPTU sem desconto: R$ %.2f", prefeitura.calcularTotalIPTUSemDesconto());
        System.out.printf("\nTotal IPTU com desconto: R$ %.2f\n", prefeitura.calcularTotalIPTUComDesconto());

        // 4. Testar formatação de documentos
        System.out.println("\nDocumentos formatados:");
        for (PessoaFisica pf : prefeitura.getPessoasFisicas()) {
            System.out.println(pf.getNome() + " - CPF: " + pf.getDocumentoFormatado());
        }
        for (PessoaJuridica pj : prefeitura.getPessoasJuridicas()) {
            System.out.println(pj.getNome() + " - CNPJ: " + pj.getDocumentoFormatado());
        }

        // 5. Testar restrição para ponto comercial
        System.out.println("\nTentando cadastrar ponto comercial com PF...");
        try {
            PessoaFisica pf = prefeitura.getPessoasFisicas().get(0);
            PontoComercial pc = new PontoComercial("Av. Inválida, 500", 0.0, pf, 80.0, 100.0);
            System.out.println("ERRO: Cadastro permitido indevidamente!");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCESSO: Restrição aplicada - " + e.getMessage());
        }

        // 6. Consultar idade do responsável
        System.out.println("\nIdade dos responsáveis:");
        for (Imovel imovel : prefeitura.getImoveis()) {
            Responsavel resp = imovel.getResponsavel();
            if (resp instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) resp;
                System.out.println(resp.getNome() + ": " + pf.getIdade() + " anos");
            } else if (resp instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) resp;
                System.out.println(resp.getNome() + ": Fundada em " + pj.getAno() +
                        " (" + (2025 - pj.getAno()) + " anos)");
            }
        }
    }
}