package Exercises;


import org.openqa.selenium.support.PageFactory;

import FrameworkPackage.DriverManager;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.NewPage;
import PageObjects.WelcomePage;

public class Exercise7 {

	public static void main(String[] args) {
		DriverManager.setFirefoxDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net");
		
		MenuPage menuP = new MenuPage();
		LoginPage loginP = new LoginPage();
		NewPage newP = new NewPage();
		WelcomePage welcomeP = new WelcomePage();
		PageFactory.initElements(DriverManager.getDriver(), menuP);
		PageFactory.initElements(DriverManager.getDriver(), loginP);
		PageFactory.initElements(DriverManager.getDriver(), newP);
		PageFactory.initElements(DriverManager.getDriver(), welcomeP);
		menuP.clickLogout();
		loginP.login("admin", "superduper");
		String expectedWelcomeHeader = "Welcome";
		String expectedFirstParagraph  = "Welcome to the exciting features provided to you by this Connection Management website, a glorified address book.";
		
		if(welcomeP.getWelcomeText().equals(expectedWelcomeHeader)) {
			System.out.println("welcome header is correct and is: "+ expectedWelcomeHeader);
		}
		else
			System.out.println("welcome header is incorrect and displays: "+ welcomeP.getWelcomeText());
		
		if(welcomeP.getWelcomeTextP1().equals(expectedFirstParagraph)) {
			System.out.println("welcome header is correct and is: "+ expectedFirstParagraph);
		}
		else
			System.out.println("welcome paragraph is incorrect and displays: "+ welcomeP.getWelcomeTextP1());
		
		DriverManager.killDriver();
	}
	

}
