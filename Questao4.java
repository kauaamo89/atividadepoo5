@FunctionalInterface
interface OperacaoMatematica {
    double executar(double a, double b);
}

public class Questao4 {
    public static void main(String[] args) {
        OperacaoMatematica soma = (a, b) -> a + b;
        OperacaoMatematica subtracao = (a, b) -> a - b;
        OperacaoMatematica multiplicacao = (a, b) -> a * b;
        OperacaoMatematica divisao = (a, b) -> a / b;

        double x = 10;
        double y = 2;

        System.out.println("Soma: " + soma.executar(x, y));
        System.out.println("Subtração: " + subtracao.executar(x, y));
        System.out.println("Multiplicação: " + multiplicacao.executar(x, y));
        System.out.println("Divisão: " + divisao.executar(x, y));
    }
}
