package Exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;

import FrameworkPackage.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.NewPage;
import PageObjects.WelcomePage;

public class LoginParameterizedTest {
	
	static MenuPage menuP;
	static LoginPage loginP;
	static NewPage newP;
	static WelcomePage welcomeP;
	static AdminPage adminP;
	@BeforeAll
	public static void setup() {
		DriverManager.setChromeDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net");
		String currentWindow = DriverManager.getDriver().getWindowHandle();
		String firstWindow = currentWindow;
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
	
	@BeforeEach
	public void clearText() {
		loginP.clearLogin();
	}
	
	@AfterEach
	public void logOut() {
		menuP.clickLogout();
	}
	
	@AfterAll
	public static void quit() {
		DriverManager.getDriver().close();
	}

	@Test
	public void loginWithCorrectUserNameAndPassword() {
		
		loginP.login("admin", "superduper");
		Assert.assertTrue("FAILED : Welcome is not displayed",welcomeP.getWelcomeText().equals("Welcome"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"admin,wrong",
		"wrong,superduper",
		"/,/"
	})
	public void loginWithIncorrectUserName(String userName, String password) {
		loginP.login(userName, password);
		Assert.assertTrue("FAILED : Welcome is displayed",!welcomeP.getWelcomeText().equals("Welcome"));
	}
	
	
	
}
