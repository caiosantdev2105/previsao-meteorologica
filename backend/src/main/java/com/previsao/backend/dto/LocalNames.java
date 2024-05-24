package com.previsao.backend.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalNames {
    private Map<String, String> names;

    // getters e setters
    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public String getName(String languageCode) {
        return names.get(languageCode);
    }
}
