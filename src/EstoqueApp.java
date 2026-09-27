import java.util.Locale;

public class EstoqueApp {
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Product detergente = null;
        Product queijo = null;

        System.out.println("=== 1. Cadastro de produtos ===");
        try {
            detergente = new ProdutoComum("Detergente", 3.50, 40);
            queijo = new ProdutoPerecivel("Queijo Minas", 32.00, 5, 15);
            estoque.adicionarProduto(new ProdutoComum("Arroz 5kg", 25.90, 10));
            estoque.adicionarProduto(detergente);
            estoque.adicionarProduto(new ProdutoPerecivel("Leite 1L", 5.00, 20, 2));   // vence em <= 3 dias
            estoque.adicionarProduto(queijo);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro inesperado no cadastro: " + e.getMessage());
        }
        estoque.listarProdutos();

        System.out.println();
        System.out.println("=== 2. Cadastro com quantidade negativa ===");
        try {
            estoque.adicionarProduto(new ProdutoComum("Feijão 1kg", 8.00, -5));
            System.out.println("Produto cadastrado (não deveria acontecer).");
        } catch (QuantidadeInvalidaException e) {
            System.out.println("QuantidadeInvalidaException capturada: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== 3. Novo cadastro e vendas ===");
        try {
            realizarOperacoes(estoque);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("QuantidadeInvalidaException capturada: " + e.getMessage());
        } catch (ProdutoIndisponivelException e) {
            System.out.println("ProdutoIndisponivelException capturada: " + e.getMessage());
        } catch (EstoqueException e) {
            // O mais genérico vem por último; antes, tornaria os catches acima inalcançáveis.
            System.out.println("EstoqueException capturada: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== 4. Descontos (sobrecarga de aplicarDesconto) ===");
        detergente.aplicarDesconto(10);          // 10% sem limite
        System.out.println("aplicarDesconto(10) no Detergente: " + detergente.getDescricao());
        queijo.aplicarDesconto(50, 5.00);        // 50%, limitado a R$ 5,00
        System.out.println("aplicarDesconto(50, 5.00) no Queijo Minas: " + queijo.getDescricao());

        System.out.println();
        System.out.println("=== 5. Estoque final ===");
        estoque.listarProdutos();
        System.out.printf(PT_BR, "Valor total do estoque: R$ %.2f%n", estoque.calcularValorTotalEstoque());
    }

    // Declara a exceção base: quem chama trata cada subtipo separadamente.
    private static void realizarOperacoes(Estoque estoque) throws EstoqueException {
        estoque.adicionarProduto(new ProdutoComum("Feijão 1kg", 8.00, 30));
        System.out.println("Produto cadastrado: Feijão 1kg.");

        estoque.venderProduto(0, 3);
        System.out.println("Venda realizada: 3 unidades de Arroz 5kg.");

        estoque.venderProduto(3, 50);
        System.out.println("Venda realizada (não deveria acontecer).");
    }
}
