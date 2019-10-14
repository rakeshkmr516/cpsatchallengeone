package org.cpsat;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChallengeTestTwo {

	@Test
	public void testChallengeTwo() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cii.in/OnlineRegistration.aspx");

		WebElement drpNumberOfAttendees = driver.findElement(By.name("drpAttendee"));

		Select selNumberofAttendees = new Select(drpNumberOfAttendees);
		selNumberofAttendees.selectByVisibleText("3");

		Assert.assertEquals("Row Count should be 3	", 3, driver.findElements(By.xpath("//table[@id='Gridview1']/tbody/tr[contains(@style,'color:#333333')]")).size());

		WebElement drptrOne = driver.findElement(By.id("Gridview1_ctl02_drpTitle"));
		Select selTrOne = new Select(drptrOne);
		selTrOne.selectByVisibleText("Admiral");

		WebElement drptrTwo = driver.findElement(By.id("Gridview1_ctl03_drpTitle"));
		Select selTrTwo = new Select(drptrTwo);
		selTrTwo.selectByValue("CA");

		WebElement drptrThree = driver.findElement(By.id("Gridview1_ctl04_drpTitle"));
		Select selTrThree = new Select(drptrThree);
		selTrThree.selectByIndex(18);

		selTrThree.getOptions().forEach(option -> System.out.println(option.getText()));


		driver.quit();
	}

}
