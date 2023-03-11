package Exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise1_ProjectSetup {

	public static void main(String[] args) {
		String website = "https://www.google.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bvanelst\\Documents\\Chrome_Driver\\chromedriver.exe");
		
		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get(website);		
		System.out.print("Chrome: The title is " + chromeDriver.getTitle());
		chromeDriver.quit();

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\bvanelst\\Documents\\Gecko_Driver\\geckodriver.exe");
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get(website);		
		System.out.print("Firefox: The title is " + firefoxDriver.getTitle());
		firefoxDriver.quit();
	}

}
