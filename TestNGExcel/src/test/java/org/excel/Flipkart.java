package org.excel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinoth\\eclipse-workspace\\TestNGExcel\\chrome\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*WebElement first = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
	driver.get(driver.getCurrentUrl());
	first.click();*/
	WebElement mens = driver.findElement(By.xpath("(//span[@class='_1QZ6fC _3Lgyp8'])[3]"));
	Actions acc=new Actions(driver);
	acc.moveToElement(mens).click().perform();
	driver.findElement(By.xpath("//a[@title='Casio']")).click();
/*List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_2mylT6']"));
for(int i=0;i<elements.size();i++) {
	String attribute = elements.get(i).getAttribute("title");
	System.out.println(attribute);
	}
for(int j=1;j<=50;j++) {
	WebDriverWait wait=new WebDriverWait(driver, 3);
	WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	until.click();
	List<WebElement> page = driver.findElements(By.xpath("//a[@class='_2mylT6']"));
	for(int k=0;k<page.size();k++) {
		String attribute1 = page.get(k).getAttribute("title");
		System.out.println(attribute1);
	
	}
	}*/
}
}

