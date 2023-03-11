package Exercises;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;

import FrameworkPackage.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.NewPage;
import PageObjects.WelcomePage;

public class Exercise8 {

	public static void main(String[] args) {
		DriverManager.setChromeDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net");
		String currentWindow = DriverManager.getDriver().getWindowHandle();
		String firstWindow = currentWindow;
		MenuPage menuP = new MenuPage();
		LoginPage loginP = new LoginPage();
		NewPage newP = new NewPage();
		WelcomePage welcomeP = new WelcomePage();
		AdminPage adminP = new AdminPage();
		
		PageFactory.initElements(DriverManager.getDriver(), menuP);
		PageFactory.initElements(DriverManager.getDriver(), loginP);
		PageFactory.initElements(DriverManager.getDriver(), newP);
		PageFactory.initElements(DriverManager.getDriver(), welcomeP);
		PageFactory.initElements(DriverManager.getDriver(), adminP);
		
		menuP.clickLogout();
		loginP.login("admin", "superduper");
		menuP.clickAdmin();
		
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		String newWindow = null;
		for(String window : allWindows) {
			if(!currentWindow.equals(window)) {
				newWindow = window;
				break;
			}
		}
		DriverManager.getDriver().switchTo().window(newWindow);
		System.out.println(newWindow);
		
		String newUser = "newName";
		String newPW = "newerPW";
		
		adminP.resetUser();
		Alert popup = DriverManager.getDriver().switchTo().alert();
		popup.accept();
		adminP.createNewUser(newUser, newPW);
		DriverManager.getDriver().switchTo().window(firstWindow);
		menuP.clickLogout();
		loginP.login(newUser, newPW);
		System.out.println(welcomeP.getWelcomeText()); 
		
		DriverManager.getDriver().quit();
	}

}
