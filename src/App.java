import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double limiteGastos = 0;

        int option = 1;

        String nomeProduto;
        double valorProduto;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu seu limite de gastos: ");
        limiteGastos = scanner.nextDouble();

        Carrinho carrinho = new Carrinho();

        while (option != 0) {
            System.out.println("");
            System.out.println("---MENU---");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Conferir limite");
            System.out.println("3 - Adicionar limite");
            System.out.println("4 - Pagar com boleto");
            System.out.println("5 - Pagar com pix");
            System.out.println("6 - Conferir produtos");
            System.out.println("0 - Sair de Compras");
            System.out.println("---------\n");
            option = scanner.nextInt();
            System.out.println("");
            System.out.println("---------");

            switch (option) {
                case 1:
                    System.out.println("1 - Adicionar produto");
                    System.out.print("Digite o nome do produto que deseja adicionar no carrinho: ");
                    nomeProduto = scanner.next();

                    System.out.print("Digite o valor de *" + nomeProduto + "*: ");
                    valorProduto = scanner.nextDouble();

                    Produto produto = new Produto(nomeProduto, valorProduto);

                    carrinho.adicionarProduto(produto);
                    break;
                case 2:
                    System.out.println("2 - Conferir limite");
                    break;
                case 3:
                    System.out.println("3 - Adicionar limite");
                    break;
                case 4:
                    System.out.println("4 - Pagar com boleto");
                    break;
                case 5:
                    System.out.println("5 - Pagar com pix");
                    break;
                case 6:
                    System.out.println("6 - Conferir produtos");
                
                    for (Produto eachProduto : carrinho.getProdutos() ) {
                        System.out.println(eachProduto);
                    }

                    System.out.println(carrinho.getProdutos());
                    break;
                case 0:
                    System.out.println("0 - Sair de Compras");
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}
