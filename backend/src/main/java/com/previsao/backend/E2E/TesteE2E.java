package com.previsao.backend.E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class TesteE2E {

    public static void main(String[] args) {
        // Configuração do WebDriver
        System.setProperty("webdriver.edge.driver", "/com/previsao/backend/E2E/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Abre a página da sua aplicação
        driver.get("../../../../frontend/index.html");

        // Encontra o campo de entrada de texto para a cidade e insere o nome da cidade
        WebElement txtCidade = driver.findElement(By.id("txtCidade"));
        txtCidade.sendKeys("São Paulo");

        // Encontra o botão de consulta e clica nele
        WebElement btnConsulta = driver.findElement(By.id("btnConsulta"));
        btnConsulta.click();

        // Aguarda alguns segundos para a resposta da aplicação
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Verifica se as informações do clima são exibidas corretamente
        WebElement divInfosClima = driver.findElement(By.id("div-infos-clima"));
        String textoInfosClima = divInfosClima.getText();
        if (textoInfosClima.contains("Nome da Cidade") && textoInfosClima.contains("Temperatura Atual:") && textoInfosClima.contains("Clima Previsto:")) {
            System.out.println("Teste bem-sucedido!");
        } else {
            System.out.println("Teste falhou!");
        }

        // Fecha o navegador
        driver.quit();
    }
}
