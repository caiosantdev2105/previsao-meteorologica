package com.previsao.backend.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.previsao.backend.dto.LocalizacaoDTO;

public class LocalizacaoServices {
    public LocalizacaoDTO getLocalizacao(String nomeCidade) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?q=" + nomeCidade
                            + ",BR&limit=1&appid=aa64c985297e12b2d3e6d1a566f41b78"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}
