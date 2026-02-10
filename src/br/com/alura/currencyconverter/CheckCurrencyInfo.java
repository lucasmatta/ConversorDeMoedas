package br.com.alura.currencyconverter;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CheckCurrencyInfo {
    public ApiRecord currencyConversion (String baseCurrency, String targetCurrency, double moneyAmount) {
        String siteUrl = "https://v6.exchangerate-api.com/v6/401ec7ac1c33b27d98358c0e/pair/" + baseCurrency + "/" + targetCurrency + "/" + moneyAmount;
        System.out.println("Conectando à API no endereço: " + siteUrl);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(siteUrl))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ApiRecord.class);
        } catch (Exception e) {
            System.out.println("Um erro ocorreu! Veja abaixo:");
            throw new RuntimeException(e);
        }
    }
}
