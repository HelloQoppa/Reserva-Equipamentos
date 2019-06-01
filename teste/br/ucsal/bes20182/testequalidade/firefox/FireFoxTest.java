package br.ucsal.bes20182.testequalidade.firefox;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FireFoxTest {

	@Test
	public void testeFire() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\luiiz\\estoque-2019\\estoque\\lib\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("C:\\Users\\luiiz\\estoque-2019\\estoque\\src\\main\\webapp\\lista-compras.html");

		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByVisibleText("Manga");

		WebElement elementQtd = driver.findElement(By.id("quantidade"));
		elementQtd.sendKeys("10");

		WebElement elementValor = driver.findElement(By.id("valorUnitario"));
		elementValor.sendKeys("5");

		WebElement elementButton = driver.findElement(By.id("calcularBtn"));
		elementButton.click();

	}

	@Test
	public void testeValorTotalFire() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\luiiz\\estoque-2019\\estoque\\lib\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("C:\\Users\\luiiz\\estoque-2019\\estoque\\src\\main\\webapp\\lista-compras.html");

		WebElement elementTotal = driver.findElement(By.id("valorTotal"));

		Assert.assertNotEquals(elementTotal, 50);
	}
}
