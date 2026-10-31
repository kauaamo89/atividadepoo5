import java.util.ArrayList;
import java.util.List;

interface Imprimivel {
    void imprimir();

    // por padrão o documento só é impresso
    default void processar() {
        imprimir();
    }
}

interface EnviavelPorEmail {
    void enviar(String email);
}

class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail {
    String email;

    RelatorioFinanceiro(String email) {
        this.email = email;
    }

    public void imprimir() {
        System.out.println("Imprimindo relatório financeiro");
    }

    public void enviar(String email) {
        System.out.println("Enviando relatório para " + email);
    }

    // o relatório imprime e também envia por email
    public void processar() {
        imprimir();
        enviar(email);
    }
}

class Contrato implements Imprimivel {
    public void imprimir() {
        System.out.println("Imprimindo contrato");
    }
}

public class Questao5 {
    public static void main(String[] args) {
        List<Imprimivel> documentos = new ArrayList<>();
        documentos.add(new RelatorioFinanceiro("financeiro@empresa.com"));
        documentos.add(new Contrato());
        documentos.add(new RelatorioFinanceiro("gerente@empresa.com"));
        documentos.add(new Contrato());

        System.out.println("Usando instanceof:");
        for (Imprimivel doc : documentos) {
            doc.imprimir();
            if (doc instanceof EnviavelPorEmail) {
                ((EnviavelPorEmail) doc).enviar("financeiro@empresa.com");
            }
        }

        System.out.println();
        System.out.println("Usando polimorfismo:");
        for (Imprimivel doc : documentos) {
            doc.processar();
        }
    }
}
