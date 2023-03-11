package Exercises;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FrameworkPackage.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.NewPage;
import PageObjects.WelcomePage;

public class TestNGExercise {
	
	static MenuPage menuP;
	static LoginPage loginP;
	static NewPage newP;
	static WelcomePage welcomeP;
	static AdminPage adminP;
	@BeforeSuite
	public static void setup() {
		DriverManager.setChromeDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net");
		//String currentWindow = DriverManager.getDriver().getWindowHandle();
		//String firstWindow = currentWindow;
		 menuP = new MenuPage();
		 loginP = new LoginPage();
		 newP = new NewPage();
		 welcomeP = new WelcomePage();
		 adminP = new AdminPage();
		
		PageFactory.initElements(DriverManager.getDriver(), menuP);
		PageFactory.initElements(DriverManager.getDriver(), loginP);
		PageFactory.initElements(DriverManager.getDriver(), newP);
		PageFactory.initElements(DriverManager.getDriver(), welcomeP);
		PageFactory.initElements(DriverManager.getDriver(), adminP);
		menuP.clickLogout();
	}
	
	@BeforeMethod
	public void clearText() {
		loginP.clearLogin();
	}
	
	@AfterTest
	public void logOut() {
		menuP.clickLogout();
	}
	
	@AfterSuite
	public static void quit() {
		DriverManager.getDriver().close();
	}

	@Test
	public void loginWithCorrectUserNameAndPassword() {
		
		loginP.login("admin", "superduper");
		Assert.assertTrue(welcomeP.getWelcomeText().equals("Welcome"), "FAILED : Welcome is not displayed");
	}
	
	@Test
	public void loginWithIncorrectUserName() {
		loginP.login("userName", "password");
		Assert.assertTrue(!welcomeP.getWelcomeText().equals("Welcome"), "FAILED : Welcome is displayed");
	}
	
	
	
}
