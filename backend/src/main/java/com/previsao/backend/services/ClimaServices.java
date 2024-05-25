package com.previsao.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço para obter dados de clima da API HGWeather com base nas coordenadas.
 */
@Service
public class ClimaServices {

    private final RestTemplate restTemplate;

    /**
     * Construtor do serviço ClimaServices.
     *
     * @param restTemplate O RestTemplate usado para fazer chamadas HTTP.
     */
    @Autowired
    public ClimaServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Obtém os dados de clima da API HGWeather com base nas coordenadas de latitude e longitude.
     *
     * @param latitude  A latitude da localização.
     * @param longitude A longitude da localização.
     * @return Uma string contendo os dados de clima retornados pela API.
     */
    public String obterDadosClima(double latitude, double longitude) {
        // Construa a URL da API HGWeather com as coordenadas
        String url = "https://api.hgbrasil.com/weather?format=json-cors&fields=only_results&key=316f27ba&lat="
                + latitude + "&lon=" + longitude + "&user_ip=remote";

        try {
            // Faça uma requisição para a API HGWeather
            String responseBody = restTemplate.getForObject(url, String.class);

            // Processar a resposta da API HGWeather e retornar os dados de clima
            return responseBody;
        } catch (Exception e) {
            // Lida com exceções
            e.printStackTrace();
            return "Erro ao obter dados de clima da API HGWeather";
        }
    }
}
