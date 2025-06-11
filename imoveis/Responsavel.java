package imoveis; 

public abstract class Responsavel {
    protected String nome;

    public Responsavel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
