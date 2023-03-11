package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewPage {
	@FindBy(how = How.ID, using = "firstName")
	private WebElement firstNameField;
	@FindBy(how = How.ID, using = "lastName")
	private WebElement lastNameeField;
	@FindBy(how = How.ID, using = "sex")
	private WebElement sexDropdown;
	
	public void newConnection (String firstName, String lastName) {
		firstNameField.sendKeys(firstName);
		lastNameeField.sendKeys(lastName);
	}
}
