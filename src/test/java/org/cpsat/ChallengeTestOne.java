package org.cpsat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChallengeTestOne {
	
	
	
	
	@Test
	public void testChallengeOne() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.meripustak.com/ ");
		
		WebElement logoMeri = driver.findElement(By.xpath("//img[@alt='Meripustak logo']"));
		
		Reporter.log("The height of logo:" + logoMeri.getRect().getHeight(), true);
		Reporter.log("The Width of logo:" + logoMeri.getRect().getWidth(), true);
		
		
		WebElement iconTwitter = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		Reporter.log("Twitter href attribute is : " + iconTwitter.getAttribute("href"), true );
		
		
		driver.findElement(By.id("lblNoCartItem")).click();
		Reporter.log("Clicked on the shopping cart when an item in the cart is 0");
		
		
		WebElement txtnoCartMessage = driver.findElement(By.xpath("//h4[contains(text(),'No Item is Added In Cart yet.Cart is Empty!!!')]"));
		Assert.assertEquals(txtnoCartMessage.getText().trim(), "No Item is Added In Cart yet.Cart is Empty!!!", "No Item is Added In Cart yet.Cart is Empty!!! Message should be displayed");
		Reporter.log("Message Displyed is: " + txtnoCartMessage.getText());
		
		
		String sBook = "Core java";
		WebElement inputSearch = driver.findElement(By.id("txtsearch"));
		inputSearch.clear();
		inputSearch.sendKeys(sBook);
		
		
		driver.findElement(By.id("btnsearch")).click();
		Reporter.log("Searched for: " + sBook);
		
		driver.findElement(By.xpath("//div[@class='book_list_name']/a")).click();
		
		
		driver.findElement(By.id("ContentPlaceHolder1_AddtoCart")).click();
		Reporter.log("Added book to cart");
		
		Assert.assertTrue(driver.findElements(By.xpath("//h4[contains(text(),'No Item is Added In Cart yet.Cart is Empty!!!')]")).isEmpty());
		Reporter.log("Message does not exist");
		
		driver.quit();
		
	}
	

}
