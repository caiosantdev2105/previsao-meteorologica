package com.previsao.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Classe para direcionar ao Jackson qual informação ir para qual objeto
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizacaoDTO {

    private String name;
    @JsonIgnore
    private LocalNames local_names;
    private double lat;
    private double lon;
    private String country;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalNames getLocal_names() {
        return local_names;
    }

    public void setLocal_names(LocalNames local_names) {
        this.local_names = local_names;
    }

}
