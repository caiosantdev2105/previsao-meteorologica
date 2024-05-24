package com.previsao.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.previsao.backend.models.Clima;
import com.previsao.backend.services.ClimaServices;
import com.previsao.backend.services.LocalizacaoServices;

@RestController
public class LocalizacaoController {

    @Autowired
    private LocalizacaoServices servicosLocalizacao;

}
