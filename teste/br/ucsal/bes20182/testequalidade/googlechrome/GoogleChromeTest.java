package br.ucsal.bes20182.testequalidade.googlechrome;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GoogleChromeTest {

	@Test
	public void testeChrome() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luiiz\\estoque-2019\\estoque\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("C:\\Users\\luiiz\\estoque-2019\\estoque\\src\\main\\webapp\\lista-compras.html");

		selecionarProduto(driver);

		informarQuantidade(driver);

		informarValor(driver);

		confirmarCompra(driver);

		pagar(driver);

	}

	@When("E confirmo a compra")
	private void confirmarCompra(WebDriver driver) {
		WebElement elementButton = driver.findElement(By.id("calcularBtn"));
		elementButton.click();
	}

	@When("informo o valor uniario $reais reais")
	private void informarValor(WebDriver driver) {
		WebElement elementValor = driver.findElement(By.id("valorUnitario"));
		elementValor.sendKeys("5");
	}

	@When("informo a quantidade $quantidade")

	private void informarQuantidade(WebDriver driver) {
		WebElement elementQtd = driver.findElement(By.id("quantidade"));
		elementQtd.sendKeys("10");
	}

	@When("seleciono o produto $nome")
	private void selecionarProduto(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByVisibleText("Manga");
	}

	@Then("terei de pagar $reais reais")
	private void pagar(WebDriver driver) {
		WebElement elementTotal = driver.findElement(By.id("valorTotal"));

		Assert.assertNotEquals(elementTotal, 50);

	}

}
