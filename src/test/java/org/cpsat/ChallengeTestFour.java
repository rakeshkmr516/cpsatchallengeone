package org.cpsat;


import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChallengeTestFour {



	@Test
	public void testChallengeFour() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.hometown.in/");
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No Thanks']"))).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics"))).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Color')]"))).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Black']"))).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'Product__ProductImg')]")));

		Actions act = new Actions(driver);
		WebElement img = driver.findElement(By.xpath("//img[contains(@class,'Product__ProductImg')]"));
		WebElement btnQuickView = driver.findElement(By.xpath("//button[text()='QUICK VIEW']"));
		act.moveToElement(img).click(btnQuickView).build().perform();

		String txtProductName = driver.findElement(By.xpath("//h1//a")).getText();
		Assert.assertTrue("Producrt name should contain Black", txtProductName.contains("Black"));

		driver.findElement(By.xpath("//button[contains(@class,'styles_closeButton')]")).click();
		Assert.assertTrue(" Black should present in Applied filters ", driver.findElement(By.xpath("//label[text()='Applied Filters']//following::li[text()='Black']")).isDisplayed());

		driver.quit();

	}

}
