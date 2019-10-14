package org.cpsat;

import java.util.Set;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ChallengeTestThree {




	@Test
	public void testChallengeThree() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.premierleague.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Tables")).click();

		WebElement lnkArsenal = driver.findElement(By.xpath("//a[@href='/clubs/1/Arsenal/overview']"));

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='btn-primary cookies-notice-accept']")).click();
		Thread.sleep(5000);
		Actions a = new Actions(driver);
		a.contextClick(lnkArsenal).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(10000);
	
		Set<String> handles = driver.getWindowHandles();


		driver.switchTo().window((String) handles.toArray()[0]);

		System.out.println("New Window URL : " + driver.getCurrentUrl());

		System.out.println("New window page title: " + driver.getTitle());

		driver.switchTo().window((String) handles.toArray()[0]);


		System.out.println("old window page title: " + driver.getTitle());

		driver.quit();
	}


}
