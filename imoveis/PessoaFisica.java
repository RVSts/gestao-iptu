package imoveis;

public class PessoaFisica extends Responsavel{
    private String cpf;
    private int idade;

    public PessoaFisica(String nome, String cpf, int idade)
    {
        super(nome);
        this.cpf = formatarCPF(cpf);
        this.idade = idade;
    }

    private String formatarCPF(String cpf) {
        if (cpf.length() == 11) {
            return cpf.substring(0, 3) + "." +
                    cpf.substring(3, 6) + "." +
                    cpf.substring(6, 9) + "-" +
                    cpf.substring(9);
        } else {
            return "CPF inválido";
        }
    }

    @Override
    public String getDocumentoFormatado() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
