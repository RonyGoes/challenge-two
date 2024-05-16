import java.util.Scanner;

public class EntradaUsuario {
    private double valor;
    private MoedaEnum moedaOrigem;
    private MoedaEnum moedaDestino;

    public void solicitarDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a moeda de origem:");
        for (MoedaEnum moeda : MoedaEnum.values()) {
            System.out.println(moeda.ordinal() + 1 + ". " + moeda.getNome());
        }
        int opcaoOrigem = scanner.nextInt();
        this.moedaOrigem = MoedaEnum.values()[opcaoOrigem - 1];

        System.out.println("Selecione a moeda de destino:");
        for (MoedaEnum moeda : MoedaEnum.values()) {
            System.out.println(moeda.ordinal() + 1 + ". " + moeda.getNome());
        }
        int opcaoDestino = scanner.nextInt();
        this.moedaDestino = MoedaEnum.values()[opcaoDestino - 1];

        System.out.println("Digite o valor a ser convertido:");
        this.valor = scanner.nextDouble();
    }

    public double getValor() {
        return valor;
    }

    public MoedaEnum getMoedaOrigem() {
        return moedaOrigem;
    }

    public MoedaEnum getMoedaDestino() {
        return moedaDestino;
    }
}
