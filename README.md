# Atividade POO - Interfaces

Os códigos das questões 3, 4 e 5 estão nos arquivos Questao3.java, Questao4.java e Questao5.java.

Para rodar:
```
javac Questao3.java
java Questao3
```
(mesma coisa para a 4 e a 5)

## Questão 1

A partir do Java 8 passou a ser possível colocar métodos com corpo nas interfaces, usando default ou static. Antes disso a interface só podia ter métodos abstratos e constantes.

O método default serve para dar uma implementação padrão para o método. Assim, se for adicionado um método novo numa interface que já é usada por várias classes, essas classes não quebram, porque já recebem a implementação padrão. Se a classe quiser, ela pode sobrescrever o método. Foi assim que o Java conseguiu colocar o forEach() nas listas sem quebrar o código que já existia.

O método static serve para criar métodos auxiliares ligados à interface. Ele é chamado pelo nome da interface (por exemplo Comparator.comparing()) e não é herdado pelas classes que implementam a interface.

## Questão 2

A interface funciona como um contrato, ela diz o que a classe tem que fazer mas não como. Quando uma parte do sistema depende da interface e não de uma classe concreta, dá pra trocar a implementação sem mexer no resto do código. Isso deixa o sistema desacoplado e mais fácil de manter, de adicionar coisas novas e de testar.

Exemplo: uma loja online que aceita vários tipos de pagamento.

```java
interface Pagamento {
    void pagar(double valor);
}

class PagamentoPix implements Pagamento {
    public void pagar(double valor) {
        System.out.println("Pagando " + valor + " no pix");
    }
}

class PagamentoCartao implements Pagamento {
    public void pagar(double valor) {
        System.out.println("Pagando " + valor + " no cartão");
    }
}

class Pedido {
    void finalizar(Pagamento pagamento, double total) {
        pagamento.pagar(total);
    }
}
```

A classe Pedido só conhece a interface Pagamento. Se a loja quiser aceitar boleto depois, é só criar uma classe PagamentoBoleto que implementa Pagamento, sem precisar alterar a classe Pedido. Se o Pedido usasse direto a classe PagamentoCartao, toda vez que mudasse a forma de pagamento teria que mexer nele.
