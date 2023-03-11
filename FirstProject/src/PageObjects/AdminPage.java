package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {
	@FindBy(how = How.ID, using = "new_username")
	private WebElement newUsername;
	
	@FindBy(how = How.ID, using = "new_password")
	private WebElement newPassword;
	
	@FindBy(how = How.XPATH, using = "//td[@onclick='createUser()']")
	private WebElement createBtn;
	
	@FindBy(how = How.XPATH, using = "//td[@onclick='resetUsers(true)']")
	private WebElement resetUser;
	
	public void createNewUser(String newUN, String newPW) {
		newUsername.click();
		newUsername.sendKeys(newUN);
		newPassword.click();
		newPassword.sendKeys(newPW);
		createBtn.click();
	}
	
	public void resetUser() {
		resetUser.click();
	}
}
