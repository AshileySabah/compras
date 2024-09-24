import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
