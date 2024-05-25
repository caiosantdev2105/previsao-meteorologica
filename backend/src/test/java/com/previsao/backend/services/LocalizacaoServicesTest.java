package com.previsao.backend.services;

import com.previsao.backend.dto.LocalizacaoDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LocalizacaoServicesTest {

    @Test
    public void testGetLocalizacao() throws Exception {
        // Mock RestTemplate
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        // Cria uma instância de LocalizacaoDTO simulada para retornar
        LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO();
        localizacaoDTO.setName("São Paulo");
        localizacaoDTO.setLat(23.32);
        localizacaoDTO.setLon(46.38);

        // Configura o RestTemplate mockado para retornar a localização simulada
        when(restTemplate.getForObject(any(URI.class), any(Class.class))).thenReturn(new LocalizacaoDTO[]{localizacaoDTO});

        // Cria uma instância do serviço LocalizacaoServices com o RestTemplate mockado
        LocalizacaoServices localizacaoServices = new LocalizacaoServices(restTemplate);

        // Chama o método a ser testado
        List<LocalizacaoDTO> localizacaoDTOs = localizacaoServices.getLocalizacao("São Paulo");

        // Verifica se a lista de localizações retornada contém os dados esperados
        assertEquals(1, localizacaoDTOs.size());
        assertEquals("São Paulo", localizacaoDTOs.get(0).getName());
        assertEquals(23.32, localizacaoDTOs.get(0).getLat());
        assertEquals(46.38, localizacaoDTOs.get(0).getLon());
    }
}
