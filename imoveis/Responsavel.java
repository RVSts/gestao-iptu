package imoveis; 

public abstract class Responsavel {
    protected String nome;

    public Responsavel(String nome) {
        this.nome = nome;
    }

    private abstract String formatar(String string);
    
    public String getNome() {
        return nome;
    }
}
