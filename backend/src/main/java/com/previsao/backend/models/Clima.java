package com.previsao.backend.models;

public class Clima {
    private String cidade;
    private String data;
    private double temperaturaAtual;
    private double temperaturaMaxima;
    private double temperaturaMinima;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }

    public void setTemperaturaAtual(double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getTipoClima() {
        return tipoClima;
    }

    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }

    public double getProbabilidadeChuva() {
        return probabilidadeChuva;
    }

    public void setProbabilidadeChuva(double probabilidadeChuva) {
        this.probabilidadeChuva = probabilidadeChuva;
    }

    public String getFaseLua() {
        return faseLua;
    }

    public void setFaseLua(String faseLua) {
        this.faseLua = faseLua;
    }

    private String tipoClima;
    private double probabilidadeChuva;
    private String faseLua;
}
