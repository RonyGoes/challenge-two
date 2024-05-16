import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Map;

public class ConversorMoeda {
    private static final String API_KEY = "2700d1b035dd2ee9e1af2c58";
    private static final String BASE_CURRENCY = "USD";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + BASE_CURRENCY;

    // Método para extrair as taxas de câmbio relevantes da resposta JSON
    private Map<String, Double> extrairTaxas(String respostaJson) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(respostaJson, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return gson.fromJson(conversionRates, new TypeToken<Map<String, Double>>() {}.getType());
    }

    public double converter(MoedaEnum moedaOrigem, MoedaEnum moedaDestino, double valor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Extrair as taxas de câmbio da resposta JSON
        Map<String, Double> taxas = extrairTaxas(response.body());

        // Selecionar as taxas de câmbio para as moedas de origem e destino
        Double taxaOrigem = taxas.get(moedaOrigem.getCodigo());
        Double taxaDestino = taxas.get(moedaDestino.getCodigo());

        if (taxaOrigem == null || taxaDestino == null) {
            System.out.println("Erro ao obter as taxas de câmbio.");
            return -1; // Valor inválido para indicar um erro
        }

        // Realizar o cálculo da conversão
        return (valor / taxaOrigem) * taxaDestino;
    }
}
