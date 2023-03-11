package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise2 {

	public static void main(String[] args) {
		String website = "https://www.google.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bvanelst\\Documents\\Chrome_Driver\\chromedriver.exe");
		
		
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get(website);
		String firstTitle = chromeDriver.getTitle();
		System.out.println(chromeDriver.getCurrentUrl());
		
		//check for footer google
		//chromeDriver.findElement(By.text);
		
		chromeDriver.get("https://bing.com/");
		System.out.println(chromeDriver.getCurrentUrl());
		
		//check footer bing
		
		chromeDriver.navigate().back();
		String navigatedBackTitle = chromeDriver.getTitle();
		System.out.println(chromeDriver.getCurrentUrl());
		
		if(firstTitle.equals(navigatedBackTitle))
			System.out.println("It is the same");
		
		System.out.println(chromeDriver.getCurrentUrl());
		
		chromeDriver.navigate().refresh();
		System.out.println(chromeDriver.getCurrentUrl());
		if(firstTitle.equals(navigatedBackTitle))
			System.out.println("It is still the same!");
		else System.out.println("It is not the same");
		
		
		
		chromeDriver.quit();
		chromeDriver = new FirefoxDriver();
		}
}
