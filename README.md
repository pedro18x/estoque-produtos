# Sistema de Estoque de Produtos

Exercício de implementação em Java: classes abstratas, herança, interfaces, polimorfismo, composição e exceções.

## Estrutura

| Arquivo | Conceito |
|---|---|
| `EstoqueException`, `QuantidadeInvalidaException`, `ProdutoIndisponivelException` | Hierarquia de exceções checadas |
| `Product` | Classe abstrata, encapsulamento, implementa `Vendavel`, sobrecarga de `aplicarDesconto()` |
| `ProdutoComum`, `ProdutoPerecivel` | Herança e sobrescrita (`@Override`) de `calcularValorTotal()` e `getDescricao()` |
| `Vendavel` | Interface com `vender()` |
| `Estoque` | Composição: tem uma `List<Product>`; soma polimórfica do valor total |
| `EstoqueApp` | `main()` com o cenário de demonstração |

## Como executar

Requer JDK 17+ (funciona com JDK 8+).

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

=== 4. Estoque após as vendas ===
  [0] Arroz 5kg | Preço: R$ 25,90 | Quantidade: 7 -> total: R$ 181,30
  [1] Detergente | Preço: R$ 3,50 | Quantidade: 40 -> total: R$ 140,00
  [2] Leite 1L | Preço: R$ 5,00 | Quantidade: 20 | Vence em: 2 dia(s) (20% de desconto) -> total: R$ 80,00
  [3] Queijo Minas | Preço: R$ 32,00 | Quantidade: 5 | Vence em: 15 dia(s) -> total: R$ 160,00
  [4] Feijão 1kg | Preço: R$ 8,00 | Quantidade: 30 -> total: R$ 240,00
Valor total do estoque: R$ 801,30
```
