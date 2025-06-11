package imoveis;

public class PessoaFisica extends Responsavel{
    private String cpf;
    private int idade;

    public PessoaFisica(String nome, String cpf, int idade)
    {
        super(nome);
        this.cpf = cpf;
        this.idade = idade;
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
