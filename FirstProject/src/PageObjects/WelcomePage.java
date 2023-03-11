package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	@FindBy(how = How.XPATH, using = "//*[@id='welcome']/h1")
	private WebElement welcomeHeader;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Welcome to')]")
	private WebElement welcomeParagraph;
	
	public String getWelcomeText() {
		return welcomeHeader.getText();
	}
	public String getWelcomeTextP1() {
		return welcomeParagraph.getText();
	}
}
