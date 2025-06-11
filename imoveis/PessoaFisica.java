package imoveis;

public class PessoaFisica extends Responsavel{
    private String cpf;
    private int idade;

    public PessoaFisica(String nome, String cpf, int idade)
    {
        super(nome);
        this.cpf = formatar(cpf);
        this.idade = idade;
    }

    @Override
    private String formatar(String cpf) {
            // Valida se o CPF tem 11 dígitos
            if (cpf.length() == 11) {
                return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6),
                        cpf.substring(6, 9), cpf.substring(9));
            } else {
                return "CPF inválido";
            }
        }
    


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
