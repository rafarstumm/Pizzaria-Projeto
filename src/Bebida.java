public class Bebida extends Itens {
    private int ml;
    private double preco;

    public Bebida(String nome, int ml, double preco) {
        super(nome);
        this.ml = ml;
        this.preco = preco;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Bebida: " + nome + " | " + ml + "ml | R$ " + preco);
    }
}