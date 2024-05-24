package com.previsao.backend.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.previsao.backend.dto.LocalizacaoDTO;

@Service
public class LocalizacaoServices {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public LocalizacaoServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<LocalizacaoDTO> getLocalizacao(String nomeCidade) throws Exception {
        String encodedCityName = URLEncoder.encode(nomeCidade, "UTF-8");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?q=" + encodedCityName
                        + ",BR&limit=1&appid=aa64c985297e12b2d3e6d1a566f41b78"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<List<LocalizacaoDTO>>() {
        });
    }
}
