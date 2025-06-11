package imoveis; 

public class Responsavel {
    private String nome;

    public Responsavel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String formatar(); // formataçao dos codigos identificadores para cada classe, forçando a implementação
}
