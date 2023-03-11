package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	@FindBy(how = How.ID, using = "username")
	private WebElement fieldUsername;
	@FindBy(how = How.ID, using = "password")
	private WebElement fieldPassword;
	@FindBy(how = How.NAME, using = "language")
	private WebElement languageDropdown;
	@FindBy(how = How.CLASS_NAME, using = "content")
	private WebElement loginButton;
	
	
	public void login (String username, String password) {
		
		fieldPassword.sendKeys(password);
		fieldUsername.sendKeys(username);
		loginButton.click();
	}
	
	public void clearLogin() {
		fieldUsername.clear();
		fieldPassword.clear();
	}
	
	public void setLanguage(String language) {
		Select langOptions = new Select(languageDropdown);
		langOptions.selectByVisibleText(language);
	}
	
}


