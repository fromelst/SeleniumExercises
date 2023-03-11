package FrameworkPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		if(driver == null) {
			setFirefoxDriver();
		}
		return driver;
	}
	
	public static void setChromeDriver() {
		if(driver != null)
			killDriver();
		
		driver = new ChromeDriver();
	}
	public static void setFirefoxDriver() {
		if(driver != null)
			killDriver();
		driver = new FirefoxDriver();
	}
	
	public static void killDriver() {
		if(driver !=  null) {
			driver.quit();
			driver = null;
		}
	}
	
}
