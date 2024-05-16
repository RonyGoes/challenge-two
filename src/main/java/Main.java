import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EntradaUsuario entrada = new EntradaUsuario();
        entrada.solicitarDados();

        ConversorMoeda conversor = new ConversorMoeda();
        try {
            double valorConvertido = conversor.converter(entrada.getMoedaOrigem(), entrada.getMoedaDestino(), entrada.getValor());
            System.out.println("O valor convertido é: " + valorConvertido            );
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
