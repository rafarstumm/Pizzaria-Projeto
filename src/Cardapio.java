import java.util.ArrayList;

public class Cardapio {
    private ArrayList<String> sabores;
    private ArrayList<Bebida> bebidas;

    public Cardapio() {
        sabores = new ArrayList<>();
        bebidas = new ArrayList<>();
        carregarItensPadrao();
    }

    private void carregarItensPadrao() {
        sabores.add("Calabresa");
        sabores.add("Frango com Catupiry");
        sabores.add("Portuguesa");

        bebidas.add(new Bebida("Refrigerante", 2000, 12.0));
        bebidas.add(new Bebida("Suco", 1000, 8.0));
    }

    public void adicionarSabor(String sabor) {
        sabores.add(sabor);
    }

    public void adicionarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public void listarSabores() {
        for (int i = 0; i < sabores.size(); i++) {
            System.out.println((i + 1) + " - " + sabores.get(i));
        }
    }

    public void listarBebidas() {
        for (int i = 0; i < bebidas.size(); i++) {
            Bebida bebida = bebidas.get(i);
            System.out.println((i + 1) + " - " + bebida.getNome() + " " + bebida.getMl() + "ml | R$ " + bebida.calcularPreco());
        }
    }

    public String getSabor(int indice) {
        return sabores.get(indice);
    }

    public Bebida getBebida(int indice) {
        return bebidas.get(indice);
    }

    public int getQuantidadeSabores() {
        return sabores.size();
    }

    public int getQuantidadeBebidas() {
        return bebidas.size();
    }
}
