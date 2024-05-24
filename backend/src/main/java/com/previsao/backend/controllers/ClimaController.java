package com.previsao.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.previsao.backend.dto.LocalizacaoDTO;
import com.previsao.backend.services.LocalizacaoServices;
import com.previsao.backend.services.ClimaServices;

@RestController
public class ClimaController {
    private final LocalizacaoServices localizacaoServices;
    private final ClimaServices climaService;

    @Autowired
    public ClimaController(LocalizacaoServices localizacaoServices, ClimaServices climaService) {
        this.localizacaoServices = localizacaoServices;
        this.climaService = climaService;
    }

    @GetMapping("/backend/clima")
    public String obterInformacoesClima(@RequestParam("cidade") String nomeCidade) {
        try {
            // Obtém as informações de localização usando LocalizacaoServices
            LocalizacaoDTO localizacao = localizacaoServices.getLocalizacao(nomeCidade).get(0);

            // Obtém a latitude e longitude da localização
            double latitude = localizacao.getLat();
            double longitude = localizacao.getLon();

            // Obtém os dados de clima usando ClimaService
            String dadosClima = climaService.obterDadosClima(latitude, longitude);

            // Retorna uma resposta com os dados de clima
            return dadosClima;
        } catch (Exception e) {
            // Lida com possíveis exceções
            return "Erro ao obter informações de clima para a cidade: " + nomeCidade;
        }
    }
}
