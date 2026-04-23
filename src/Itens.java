public abstract class Itens {
    protected String nome;

    public Itens(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularPreco();
    public abstract void exibirDetalhes();
}