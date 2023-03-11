package FrameworkPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EDriverManager {
	private static EventFiringWebDriver eDriver;
	
	public static WebDriver getDriver() {
		if(eDriver == null) {
			setFirefoxDriver();
		}
		return eDriver;
	}
	
	public static void setChromeDriver() {
		if(eDriver != null)
			killDriver();
		
		eDriver = new EventFiringWebDriver(new ChromeDriver()); 
	}
	public static void setFirefoxDriver() {
		if(eDriver != null)
			killDriver();
		eDriver = eDriver = new EventFiringWebDriver(new FirefoxDriver()); 

	}
	
	public static void killDriver() {
		if(eDriver !=  null) {
			eDriver.quit();
			eDriver = null;
		}
	}
	
}
