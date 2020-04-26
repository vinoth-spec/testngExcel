package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exce {
	public static WebDriver driver;
@DataProvider(name="getExceldata")
public Object[][] getExceldata() throws IOException {
	File f=new File("C:\\Users\\vinoth\\Desktop\\Book1.xlsx");
	FileInputStream fIS=new FileInputStream(f);
	XSSFWorkbook wb=new XSSFWorkbook(fIS);
	XSSFSheet sheet = wb.getSheet("Sheet2");
	int rowCount = sheet.getPhysicalNumberOfRows();
	XSSFRow row = sheet.getRow(0);
	int cellCount = row.getPhysicalNumberOfCells();
	Object[][] data=new Object[rowCount][cellCount];
	for(int i=0;i<rowCount;i++) {
		XSSFRow row2 = sheet.getRow(i);
		for(int j=0;j<cellCount;j++) {
			data[i][j]=row2.getCell(j).getStringCellValue();
		}
	}
	return data;

}
@BeforeSuite
public void browser() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinoth\\eclipse-workspace\\TestNGExcel\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	}
@Test(dataProvider = "getExceldata", threadPoolSize = 1000)
public void values(String name, String pwd) {
	driver.findElement(By.id("email")).clear();
	driver.findElement(By.id("pass")).clear();
	driver.findElement(By.id("email")).sendKeys(name);
	driver.findElement(By.id("pass")).sendKeys(pwd);
	
}
}
