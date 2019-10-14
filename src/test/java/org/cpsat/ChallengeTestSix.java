package org.cpsat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChallengeTestSix {



	@Test
	public void testChallengeSix() throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		XSSFWorkbook testDataFile = new XSSFWorkbook("./src/test/resources/Testdata.xlsx");     
		XSSFSheet testDataSheet = testDataFile.getSheetAt(0);
		XSSFRow testDataRow = testDataSheet.getRow(0);
		List<String> data = new ArrayList<String>();
		for(int iData= 0; iData<=2; iData++) data.add((testDataRow.getCell(iData).getStringCellValue()));
		testDataFile.close();

		driver.get("https://www.woodlandworldwide.com/");

		for(String sData: data) {

			driver.findElement(By.xpath("//div[contains(@class,'searchIcon')]")).click();

			driver.findElement(By.id("searchkey")).sendKeys(sData);

			driver.findElement(By.id("searchBtn")).click(); 

			driver.findElement(By.xpath("//input[@id='prcHTL_sort']/parent::li")).click();

			List<Integer> EightPriceList = new ArrayList<Integer>();
			List<WebElement> prices = driver.findElements(By.xpath("//span[@class='mrp']"));
			for(int iPriceCounter=0; iPriceCounter<8; iPriceCounter++) {
				EightPriceList.add(Integer.parseInt(prices.get(iPriceCounter).getText().replaceAll("[\\D]", "")));
			}
			Reporter.log( sData + " First Eight prices list: " + EightPriceList, true);
			List<Integer> descendingList = new ArrayList<Integer>(EightPriceList); 			
			Collections.sort(descendingList, Collections.reverseOrder());
			Reporter.log("Descending order list: " + descendingList, true);
			
			Assert.assertTrue(EightPriceList.equals(descendingList), "Prices should be in descending order");

			driver.findElement(By.xpath("//img[@alt='Woodland logo']")).click();
		}

		driver.quit();

	}

}
