package com.previsao.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.previsao.backend.services.ClimaServices;

@RestController
public class ClimaController {

    @Autowired
    private ClimaServices servicosClima;

}
