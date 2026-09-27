# Sistema de Estoque de Produtos

```bash
javac -d out src/*.java
java -cp out EstoqueApp
```

## Saída do programa

```
=== 1. Cadastro de produtos ===
  [0] Arroz 5kg | Preço: R$ 25,90 | Quantidade: 10 -> total: R$ 259,00
  [1] Detergente | Preço: R$ 3,50 | Quantidade: 40 -> total: R$ 140,00
  [2] Leite 1L | Preço: R$ 5,00 | Quantidade: 20 | Vence em: 2 dia(s) (20% de desconto) -> total: R$ 80,00
  [3] Queijo Minas | Preço: R$ 32,00 | Quantidade: 5 | Vence em: 15 dia(s) -> total: R$ 160,00

=== 2. Cadastro com quantidade negativa ===
QuantidadeInvalidaException capturada: Quantidade inválida para "Feijão 1kg": -5

=== 3. Novo cadastro e vendas ===
Produto cadastrado: Feijão 1kg.
Venda realizada: 3 unidades de Arroz 5kg.
ProdutoIndisponivelException capturada: Estoque insuficiente de "Queijo Minas": solicitado 50, disponível 5

=== 4. Descontos (sobrecarga de aplicarDesconto) ===
aplicarDesconto(10) no Detergente: Detergente | Preço: R$ 3,15 | Quantidade: 40
aplicarDesconto(50, 5.00) no Queijo Minas: Queijo Minas | Preço: R$ 27,00 | Quantidade: 5 | Vence em: 15 dia(s)

=== 5. Estoque final ===
  [0] Arroz 5kg | Preço: R$ 25,90 | Quantidade: 7 -> total: R$ 181,30
  [1] Detergente | Preço: R$ 3,15 | Quantidade: 40 -> total: R$ 126,00
  [2] Leite 1L | Preço: R$ 5,00 | Quantidade: 20 | Vence em: 2 dia(s) (20% de desconto) -> total: R$ 80,00
  [3] Queijo Minas | Preço: R$ 27,00 | Quantidade: 5 | Vence em: 15 dia(s) -> total: R$ 135,00
  [4] Feijão 1kg | Preço: R$ 8,00 | Quantidade: 30 -> total: R$ 240,00
Valor total do estoque: R$ 762,30
```
