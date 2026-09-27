public class ProdutoPerecivel extends Product {
    private static final int DIAS_LIMITE_DESCONTO = 3;
    private static final double DESCONTO_VENCIMENTO = 0.20;

    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer)
            throws QuantidadeInvalidaException {
        super(nome, preco, quantidade);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double total = getPreco() * getQuantidade();
        if (diasParaVencer <= DIAS_LIMITE_DESCONTO) {
            total *= (1 - DESCONTO_VENCIMENTO);
        }
        return total;
    }

    @Override
    public String getDescricao() {
        String descricao = super.getDescricao() + " | Vence em: " + diasParaVencer + " dia(s)";
        if (diasParaVencer <= DIAS_LIMITE_DESCONTO) {
            descricao += " (20% de desconto)";
        }
        return descricao;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }
}
