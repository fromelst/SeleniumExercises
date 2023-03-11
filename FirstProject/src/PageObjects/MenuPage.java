package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPage {
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	@FindBy(how = How.ID, using = "crudConnection")
	private WebElement btnNew;
	
	//div[@i='nav-bar]//a[normalize-space()='Admin']
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Admin']")
	private WebElement btnAdmin;
	
	public void clickLogout() {
		System.out.println("op de logout button clicken");
		btnLogout.click();
	}
	
	public void clickNew() {
		System.out.println("op de new button clicken");
		btnNew.click();
	}
	
	public void clickAdmin() {
		btnAdmin.click();
	}
}
