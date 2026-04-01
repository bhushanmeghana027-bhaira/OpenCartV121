package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePAge extends BasePage {

	public HomePAge(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement Register;
	
	public void clickAccount() {
		myAccount.click();
	}
	
	public void clickRegister() {
		Register.click();
	}
	

}
