import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        int opcao;

        do {
            System.out.println("\n=== PIZZARIA ===");
            System.out.println("1 - Adicionar pizza");
            System.out.println("2 - Adicionar bebida");
            System.out.println("3 - Ver pedido");
            System.out.println("4 - Finalizar pedido");
            System.out.println("5 - Sair");
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
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        sc.close();
    }

    public static void pedirPizza(Scanner sc, Pedido pedido) {
        System.out.println("\nEscolha o sabor:");
        System.out.println("1 - Calabresa");
        System.out.println("2 - Frango com Catupiry");
        System.out.println("3 - Portuguesa");
        System.out.print("Opção: ");
        int saborOpcao = sc.nextInt();
        sc.nextLine();

        String sabor;
        switch (saborOpcao) {
            case 1:
                sabor = "Calabresa";
                break;
            case 2:
                sabor = "Frango com Catupiry";
                break;
            case 3:
                sabor = "Portuguesa";
                break;
            default:
                System.out.println("Sabor inválido.");
                return;
        }

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