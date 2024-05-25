package com.previsao.backend.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ClimaServicesTest {

    @Test
    public void testObterDadosClima() {
        // Mock do RestTemplate
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        // Define a resposta simulada
        String responseBody = "{\"temperature\":25}";
        when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(responseBody);

        // Cria uma instância do serviço ClimaServices com o RestTemplate mockado
        ClimaServices climaServices = new ClimaServices(restTemplate);

        // Chama o método a ser testado
        String dadosClima = climaServices.obterDadosClima(0.0, 0.0);

        // Verifica se os dados do clima são os esperados
        assertEquals("{\"temperature\":25}", dadosClima);
    }
}


