public class Pizza extends Itens {
    private String tamanho;
    private double preco;

    public Pizza(String sabor, String tamanho, double preco) {
        super(sabor);
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Pizza: " + nome + " | Tamanho: " + tamanho + " | R$ " + preco);
    }
}