import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private float custoTotal = 0;

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(produto);
        System.out.println("Produto adicionado com sucesso!");

        custoTotal += produto.getValor();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public float getCustoTotal() {
        return custoTotal;
    }
}
