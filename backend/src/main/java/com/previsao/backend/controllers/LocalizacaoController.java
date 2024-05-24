package com.previsao.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.previsao.backend.models.Clima;
import com.previsao.backend.models.Localizacao;
import com.previsao.backend.services.ClimaServices;
import com.previsao.backend.services.LocalizacaoServices;

//Controlador da Localização
@RestController
public class LocalizacaoController {

    //Injeção dos serviços (lógica) da localização
    @Autowired
    private LocalizacaoServices servicosLocalizacao;

    //
    @PostMapping("/previsao/localizacao")
    public String obterLocalizacao(@RequestBody Localizacao cidade) {
        String response = servicosLocalizacao.obterCoordenadas(cidade);

        return response;
    }

}
