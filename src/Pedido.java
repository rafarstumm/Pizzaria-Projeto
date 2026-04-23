import java.util.ArrayList;

public class Pedido {
    private ArrayList<Itens> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Itens item) {
        itens.add(item);
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Pedido vazio.");
            return;
        }

        System.out.println("\n=== ITENS DO PEDIDO ===");
        for (Itens item : itens) {
            item.exibirDetalhes();
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Itens item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }
}