import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Carrinho carrinho = new Carrinho();
    private static Pagamento pagamento;

    public static void main(String[] args) throws Exception {
        inicializarLimite();
        exibirMenu();
    }

    private static void inicializarLimite() {
        System.out.print("Digite seu seu limite de gastos: ");
        double limiteGastos = scanner.nextDouble();
        pagamento = new Pagamento(limiteGastos, carrinho);
    }

    private static void exibirMenu() {
        int option = 1;

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

            processarOpcao(option);
        }
    }

    private static void processarOpcao(int option) {
        switch (option) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                conferirLimite();
                break;
            case 3:
                adicionarLimite();

                break;
            case 4:
                conferirProdutos();
                break;
            case 5:
                conferirCustoTotal();
                break;
            case 0:
                System.out.println("0 - Sair de Compras");
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public static void adicionarProduto() {
        System.out.println("1 - Adicionar produto");

        System.out.print("Digite o nome do produto que deseja adicionar no carrinho: ");
        String nomeProduto = scanner.next();

        System.out.print("Digite o valor de *" + nomeProduto + "*: ");
        double valorProduto = scanner.nextDouble();

        Produto produto = new Produto(nomeProduto, valorProduto);

        carrinho.adicionarProduto(produto);
    }

    public static void conferirLimite() {
        System.out.println("2 - Conferir limite");

        if (pagamento.getLimite() >= 0) {
            pagamento.getLimite();
            System.out.println("Você está dentro do limite. Restou R$ " + pagamento.getLimite() + " para mais compras.");
        } else {
            System.out.println("Você excedeu o limite em R$ " + pagamento.getLimite()*-1);
        }
    }

    private static void adicionarLimite() {
        System.out.println("3 - Adicionar limite");

        System.out.print("Digite o valor de adicional: ");
        double valorAdicional = scanner.nextDouble();

        pagamento.adicionarLimite(valorAdicional);
        
        System.out.println("Seu novo limite é R$ " + pagamento.getLimite());
    }

    private static void conferirProdutos(){
        System.out.println("4 - Conferir produtos");
            
        for (Produto eachProduto : carrinho.getProdutos() ) {
            System.out.println(eachProduto);
        }

        System.out.println(carrinho.getProdutos());
    }

    private static void conferirCustoTotal() {
        System.out.println("5 - Conferir custo total");
        System.out.println(carrinho.getCustoTotal());
    }
}
