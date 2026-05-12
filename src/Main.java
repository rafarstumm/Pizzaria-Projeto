import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        Cardapio cardapio = new Cardapio();

        int opcao;

        do {
            System.out.println("\n PIZZARIA ");
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
                    pedirPizza(sc, pedido, cardapio);
                    break;
                case 2:
                    pedirBebida(sc, pedido, cardapio);
                    break;
                case 3:
                    pedido.listarItens();
                    System.out.println("Total: R$ " + pedido.calcularTotal());
                    break;
                case 4:
                    System.out.println("\n PEDIDO FINAL ");
                    pedido.listarItens();
                    System.out.println("Total final: R$ " + pedido.calcularTotal());

                    System.out.println("\nEscolha a forma de pagamento:");
                    System.out.println("1 - Dinheiro");
                    System.out.println("2 - Cartao");
                    System.out.println("3 - Pix");
                    System.out.print("Opcao: ");
                    int pagamento = sc.nextInt();
                    sc.nextLine();

                    switch (pagamento) {
                        case 1:
                            System.out.println("Pagamento em dinheiro. Obrigado, volte sempre!");
                            break;
                        case 2:
                            System.out.println("Pagamento no cartao. Obrigado, volte sempre!");
                            break;
                        case 3:
                            System.out.println("Pagamento via Pix. Obrigado, volte sempre!");
                            break;
                        default:
                            System.out.println("Forma de pagamento invalida.");
                    }
                    break;
                case 5:
                    cadastrarNovoSabor(sc, cardapio);
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 6);

        sc.close();
    }

    public static void pedirPizza(Scanner sc, Pedido pedido, Cardapio cardapio) {
        System.out.println("\nEscolha o sabor:");
        cardapio.listarSabores();

        System.out.print("Opcao: ");
        int saborOpcao = sc.nextInt();
        sc.nextLine();

        if (saborOpcao < 1 || saborOpcao > cardapio.getQuantidadeSabores()) {
            System.out.println("Sabor invalido.");
            return;
        }

        String sabor = cardapio.getSabor(saborOpcao - 1);

        System.out.println("Escolha o tamanho:");
        System.out.println("1 - Pequena");
        System.out.println("2 - Media");
        System.out.println("3 - Grande");
        System.out.print("Opcao: ");
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
                tamanho = "Media";
                preco = 35.0;
                break;
            case 3:
                tamanho = "Grande";
                preco = 45.0;
                break;
            default:
                System.out.println("Tamanho invalido.");
                return;
        }

        Pizza pizza = new Pizza(sabor, tamanho, preco);
        pedido.adicionarItem(pizza);
        System.out.println("Pizza adicionada com sucesso!");
    }

    public static void cadastrarNovoSabor(Scanner sc, Cardapio cardapio) {
        System.out.print("\nDigite o nome do novo sabor: ");
        String novoSabor = sc.nextLine();

        cardapio.adicionarSabor(novoSabor);

        System.out.println("Sabor cadastrado com sucesso!");
    }

    public static void pedirBebida(Scanner sc, Pedido pedido, Cardapio cardapio) {
        System.out.println("\nEscolha a bebida:");
        cardapio.listarBebidas();

        System.out.print("Opcao: ");
        int bebidaOpcao = sc.nextInt();
        sc.nextLine();

        if (bebidaOpcao < 1 || bebidaOpcao > cardapio.getQuantidadeBebidas()) {
            System.out.println("Bebida invalida.");
            return;
        }

        Bebida bebida = cardapio.getBebida(bebidaOpcao - 1);
        pedido.adicionarItem(bebida);
        System.out.println("Bebida adicionada com sucesso!");
    }
}