import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> sabores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();

        sabores.add("Calabresa");
        sabores.add("Frango com Catupiry");
        sabores.add("Portuguesa");

        int opcao;

        do {
            System.out.println("\n=== PIZZARIA ===");
            System.out.println("1 - Pedir pizza");
            System.out.println("2 - Pedir bebida");
            System.out.println("3 - Ver pedido");
            System.out.println("4 - Finalizar pedido");
            System.out.println("5 - Cadastrar novo sabor");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    pedirPizza(sc, pedido);
                    break;
                case 2:
                    pedirBebida(sc, pedido);
                    break;
                case 3:
                    pedido.listarItens();
                    System.out.println("Total: R$ " + pedido.calcularTotal());
                    break;
                case 4:
                    System.out.println("\n=== PEDIDO FINAL ===");
                    pedido.listarItens();
                    System.out.println("Total final: R$ " + pedido.calcularTotal());
                    break;
                case 5:
                    cadastrarNovoSabor(sc);
                    break;
                case 6:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        sc.close();
    }

    public static void pedirPizza(Scanner sc, Pedido pedido) {
        System.out.println("\nEscolha o sabor:");

        for (int i = 0; i < sabores.size(); i++) {
            System.out.println((i + 1) + " - " + sabores.get(i));
        }

        System.out.print("Opção: ");
        int saborOpcao = sc.nextInt();
        sc.nextLine();

        if (saborOpcao < 1 || saborOpcao > sabores.size()) {
            System.out.println("Sabor inválido.");
            return;
        }

        String sabor = sabores.get(saborOpcao - 1);

        System.out.println("Escolha o tamanho:");
        System.out.println("1 - Pequena");
        System.out.println("2 - Média");
        System.out.println("3 - Grande");
        System.out.print("Opção: ");
        int tamanhoOpcao = sc.nextInt();
        sc.nextLine();

        String tamanho;
        double preco;

        switch (tamanhoOpcao) {
            case 1:
                tamanho = "Pequena";
                preco = 25.0;
                break;
            case 2:
                tamanho = "Média";
                preco = 35.0;
                break;
            case 3:
                tamanho = "Grande";
                preco = 45.0;
                break;
            default:
                System.out.println("Tamanho inválido.");
                return;
        }

        Pizza pizza = new Pizza(sabor, tamanho, preco);
        pedido.adicionarItem(pizza);
        System.out.println("Pizza adicionada com sucesso!");
    }

    public static void cadastrarNovoSabor(Scanner sc) {
        System.out.print("\nDigite o nome do novo sabor: ");
        String novoSabor = sc.nextLine();

        sabores.add(novoSabor);

        System.out.println("Sabor cadastrado com sucesso!");
    }

    public static void pedirBebida(Scanner sc, Pedido pedido) {
        System.out.println("\nEscolha a bebida:");
        System.out.println("1 - Refrigerante 2L");
        System.out.println("2 - Suco 1L");
        System.out.print("Opção: ");
        int bebidaOpcao = sc.nextInt();
        sc.nextLine();

        Bebida bebida;

        switch (bebidaOpcao) {
            case 1:
                bebida = new Bebida("Refrigerante", 2000, 12.0);
                break;
            case 2:
                bebida = new Bebida("Suco", 1000, 8.0);
                break;
            default:
                System.out.println("Bebida inválida.");
                return;
        }

        pedido.adicionarItem(bebida);
        System.out.println("Bebida adicionada com sucesso!");
    }
}