interface AparelhoTelefonico {
    void ligar();
    void atender();
}

interface NavegadorInternet {
    void exibirPagina();
    void adicionarNovaAba();
}

interface ReprodutorMusical {
    void tocar();
    void pausar();
}

class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    int abas = 1;

    public void ligar() {
        System.out.println("Ligando...");
    }

    public void atender() {
        System.out.println("Atendendo a ligação");
    }

    public void exibirPagina() {
        System.out.println("Exibindo a página");
    }

    public void adicionarNovaAba() {
        abas++;
        System.out.println("Nova aba aberta, total de abas: " + abas);
    }

    public void tocar() {
        System.out.println("Tocando música");
    }

    public void pausar() {
        System.out.println("Música pausada");
    }
}

public class Questao3 {
    public static void main(String[] args) {
        Smartphone celular = new Smartphone();

        celular.ligar();
        celular.atender();
        celular.exibirPagina();
        celular.adicionarNovaAba();
        celular.adicionarNovaAba();
        celular.tocar();
        celular.pausar();
    }
}
