package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailloginPage;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwdloginPage;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	public void setEmail(String Email) {
		emailloginPage.sendKeys(Email);	
	}
	public void setPwd(String pwd) {
		pwdloginPage.sendKeys(pwd);	
	}
	
	public void clicklogn() {
		login.click();
	}
	
	
	
}
