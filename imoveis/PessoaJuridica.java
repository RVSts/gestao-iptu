package imoveis;

public class PessoaJuridica extends Responsavel {
    private String cnpj;
    private int anoFundacao;

    public PessoaJuridica(String nome, String cnpj, int anoFundacao) {
        super(nome);
        this.cnpj = formatarCNPJ(cnpj);
        this.anoFundacao = anoFundacao;
    }

    private String formatarCNPJ(String cnpj) {
        // Valida se o CNPJ tem 14 dígitos
        if (cnpj.length() == 14) {
            return String.format("%s.%s.%s/%s-%s", cnpj.substring(0, 2), cnpj.substring(2, 5),
                    cnpj.substring(5, 8), cnpj.substring(8, 12), cnpj.substring(12));
        } else {
            return "CNPJ inválido";
        }
    }

    @Override
    public String getDocumentoFormatado() {
        return cnpj;
    }

    public int getAno() {
        return this.anoFundacao;
    }

    public void setAno(int anoFundacao) { this.anoFundacao = anoFundacao; }
}