package com.previsao.backend.services;

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

    // Instância da Classe HTTPCLIENT e ObjectMapper do Jackson
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    // Construtor
    public LocalizacaoServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    // Método que envia a requisição do tipo GET para a API OpenWeather GeoCoding e
    // retorna o JSON que é convertido pelo Jackson em Objeto Java para manipulação.
    public List<LocalizacaoDTO> getLocalizacao(String nomeCidade) throws Exception {
        String encodedCityName = URLEncoder.encode(nomeCidade, "UTF-8");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?q=" + encodedCityName
                        + ",BR&limit=1&appid=aa64c985297e12b2d3e6d1a566f41b78"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        List<LocalizacaoDTO> respFinal = objectMapper.readValue(response.body(),
                new TypeReference<List<LocalizacaoDTO>>() {
                });
        return respFinal;

    }
}
