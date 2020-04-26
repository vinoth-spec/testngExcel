package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Example {
	public static WebDriver driver;
	@Test
		public String getExcel() throws IOException {
			File f=new File("C:\\Users\\vinoth\\Desktop\\Book1");
			FileInputStream fIS=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fIS);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			String data=null;
			for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
					data = row.getCell(j).getStringCellValue();
				}
			}
			return data;
		}
		@Test
		public void browser(String name, String pass) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinoth\\eclipse-workspace\\TestNGExcel\\chrome\\chromedriver.exe");
		driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
	}
	}
