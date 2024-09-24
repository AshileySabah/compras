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

        Pagamento pagamento = new Pagamento(limiteGastos, carrinho);

        while (option != 0) {
            System.out.println("");
            System.out.println("---MENU---");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Conferir limite");
            System.out.println("3 - Adicionar limite");
            System.out.println("4 - Conferir produtos");
            System.out.println("5 - Conferir custo total");
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

                    if (pagamento.getLimite() >= 0) {
                        pagamento.getLimite();
                        System.out.println("Você está dentro do limite. Restou R$ " + pagamento.getLimite() + " para mais compras.");
                    } else {
                        System.out.println("Você excedeu o limite em R$ " + pagamento.getLimite()*-1);
                    }

                    break;
                case 3:
                    System.out.println("3 - Adicionar limite");

                    System.out.print("Digite o valor de adicional: ");
                    double valorAdicional = scanner.nextDouble();

                    pagamento.adicionarLimite(valorAdicional);
                    
                    System.out.println("Seu novo limite é R$ " + pagamento.getLimite());

                    break;
                case 4:
                    System.out.println("4 - Conferir produtos");
                
                    for (Produto eachProduto : carrinho.getProdutos() ) {
                        System.out.println(eachProduto);
                    }

                    System.out.println(carrinho.getProdutos());

                    break;
                case 5:
                    System.out.println("5 - Conferir custo total");

                    System.out.println(carrinho.getCustoTotal());;

                    break;
                case 0:
                    System.out.println("0 - Sair de Compras");

                    System.out.println("Saindo...");

                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}
