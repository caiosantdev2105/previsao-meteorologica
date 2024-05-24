package com.previsao.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.previsao.backend.dto.LocalizacaoDTO;
import com.previsao.backend.services.LocalizacaoServices;

@RestController
public class LocalizacaoController {

    @Autowired
    private LocalizacaoServices servicosLocalizacao;

    @PostMapping("/backend/coordenadas")
    public List<LocalizacaoDTO> getCoordenadas(@RequestBody String nomeCidade) throws Exception {

        List<LocalizacaoDTO> resposta = servicosLocalizacao.getLocalizacao(nomeCidade);

        return resposta;
    }

}
