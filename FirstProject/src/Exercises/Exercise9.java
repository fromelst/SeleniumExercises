package Exercises;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;

import FrameworkPackage.EDriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.NewPage;
import PageObjects.WelcomePage;

public class Exercise9 {

	public static void main(String[] args) {
		EDriverManager.setChromeDriver();
		EDriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net");
		String currentWindow = EDriverManager.getDriver().getWindowHandle();
		String firstWindow = currentWindow;
		MenuPage menuP = new MenuPage();
		LoginPage loginP = new LoginPage();
		NewPage newP = new NewPage();
		WelcomePage welcomeP = new WelcomePage();
		AdminPage adminP = new AdminPage();
		
		PageFactory.initElements(EDriverManager.getDriver(), menuP);
		PageFactory.initElements(EDriverManager.getDriver(), loginP);
		PageFactory.initElements(EDriverManager.getDriver(), newP);
		PageFactory.initElements(EDriverManager.getDriver(), welcomeP);
		PageFactory.initElements(EDriverManager.getDriver(), adminP);
		
		menuP.clickLogout();
		loginP.login("admin", "superduper");
		menuP.clickAdmin();
		
		Set<String> allWindows = EDriverManager.getDriver().getWindowHandles();
		String newWindow = null;
		for(String window : allWindows) {
			if(!currentWindow.equals(window)) {
				newWindow = window;
				break;
			}
		}
		EDriverManager.getDriver().switchTo().window(newWindow);
		System.out.println(newWindow);
		
		String newUser = "newName";
		String newPW = "newerPW";
		
		adminP.resetUser();
		Alert popup = EDriverManager.getDriver().switchTo().alert();
		popup.accept();
		adminP.createNewUser(newUser, newPW);
		EDriverManager.getDriver().switchTo().window(firstWindow);
		menuP.clickLogout();
		loginP.login(newUser, newPW);
		System.out.println(welcomeP.getWelcomeText()); 
		
		EDriverManager.getDriver().quit();
	}

}
