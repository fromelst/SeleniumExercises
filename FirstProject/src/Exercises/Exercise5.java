package Exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.NewPage;
import PageObjects.WelcomePage;

public class Exercise5 {

	public static void main(String[] args) {
		String website = "https://satrngselcypr.z16.web.core.windows.net";
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get(website);
		
		MenuPage menuP = new MenuPage();
		LoginPage loginP = new LoginPage();
		NewPage newP = new NewPage();
		WelcomePage welcomeP = new WelcomePage();
		PageFactory.initElements(firefoxDriver, menuP);
		PageFactory.initElements(firefoxDriver, loginP);
		PageFactory.initElements(firefoxDriver, newP);
		PageFactory.initElements(firefoxDriver, welcomeP);
		
		loginP.login("admin", "superduper");
	}
	

}
