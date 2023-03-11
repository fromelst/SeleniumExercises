package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise3 {

	public static void main(String[] args) {
		String website = "https://satrngselcypr.z16.web.core.windows.net";
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get(website);
		
		WebElement btnLogout = firefoxDriver.findElement(By.id("logout"));
		btnLogout.click();
		
		WebElement language = firefoxDriver.findElement(By.name("language"));
		Select langOptions = new Select(language);
		langOptions.selectByVisibleText("French");
		
		WebElement username = firefoxDriver.findElement(By.id("username"));
		username.click();
		username.sendKeys("admin");
		
		WebElement password = firefoxDriver.findElement(By.id("password"));
		password.click();
		password.sendKeys("superduper");
		
		WebElement login = firefoxDriver.findElement(By.tagName("span"));
		login.click();
		
		WebElement newNav = firefoxDriver.findElement(By.id("crudConnection"));
		newNav.click();
		
		WebElement firsName = firefoxDriver.findElement(By.id("firstName"));
		firsName.click();
		firsName.sendKeys("my name");

		WebElement lastName = firefoxDriver.findElement(By.id("lastName"));
		lastName.click();
		lastName.sendKeys("lastname");
		
		firefoxDriver.quit();
	}
	
	public static void waitFor() {
		try {
			Thread.sleep(1000);			
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
