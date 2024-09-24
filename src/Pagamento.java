
public class Pagamento {
    private double limite = 0;
    Carrinho carrinho;

    public Pagamento(double limite, Carrinho carrinho) {
        this.limite = limite;
        this.carrinho = carrinho;
    }

    public double getLimite() {
        return limite - carrinho.getCustoTotal();
    }

    void adicionarLimite(double valorAdicional) {
        limite += valorAdicional;
    }
}
