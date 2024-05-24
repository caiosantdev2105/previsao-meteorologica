package com.previsao.backend.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

@Service
public class ClimaServices {

    // Método para obter dados de clima da API HGWeather com base nas coordenadas
    public String obterDadosClima(double latitude, double longitude) {
        // Construa a URL da API HGWeather com as coordenadas
        String url = "https://api.hgbrasil.com/weather?format=json-cors&fields=only_results&key=fdda60df&lat="
                + latitude + "&lon=" + longitude + "&user_ip=remote";

        try {
            // Faça uma requisição para a API HGWeather
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept-Charset", "UTF-8") // Define o charset da resposta como UTF-8
                    .build();
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            // Converte a resposta para UTF-8 manualmente, se necessário
            byte[] responseBodyBytes = response.body();
            String responseBody = new String(responseBodyBytes, StandardCharsets.UTF_8);

            // Processar a resposta da API HGWeather e retornar os dados de clima
            System.out.println(responseBody);
            return responseBody;
        } catch (IOException | InterruptedException e) {
            // Lida com exceções
            e.printStackTrace();
            return "Erro ao obter dados de clima da API HGWeather";
        }
    }
}