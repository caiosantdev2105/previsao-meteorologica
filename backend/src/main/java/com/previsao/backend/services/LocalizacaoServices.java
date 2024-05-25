package com.previsao.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.previsao.backend.dto.LocalizacaoDTO;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Service
public class LocalizacaoServices {

    private final RestTemplate restTemplate;

    @Autowired
    public LocalizacaoServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<LocalizacaoDTO> getLocalizacao(String nomeCidade) throws Exception {
        String encodedCityName = URLEncoder.encode(nomeCidade, StandardCharsets.UTF_8.toString());
        URI uri = URI.create("http://api.openweathermap.org/geo/1.0/direct?q=" + encodedCityName
                + ",BR&limit=1&appid=aa64c985297e12b2d3e6d1a566f41b78");
        LocalizacaoDTO[] response = restTemplate.getForObject(uri, LocalizacaoDTO[].class);
        System.out.println(Arrays.asList(response));
        return Arrays.asList(response);
    }
}
