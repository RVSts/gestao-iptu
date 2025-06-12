package imoveis; 

public abstract class Responsavel {
    protected String nome;

    public Responsavel(String nome) {
        this.nome = nome;
    }

    public abstract String getDocumentoFormatado();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome; }

}
