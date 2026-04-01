package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage{
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelePhone;
	
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPrivacyBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBox;
	
	@FindBy(xpath="//h1[normalize-space()=\"Your Account Has Been Created!\"]")
	WebElement msgConfirmation;
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLasttName(String LName) {
		txtLastName.sendKeys(LName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTel(String Tel) {
		txtTelePhone.sendKeys(Tel);
	}
	
	public void setPwd(String Pwd) {
		txtPwd.sendKeys(Pwd);
	}
	
	public void setConfirmPwd(String Pwd) {
		txtConfirmPwd.sendKeys(Pwd);
	}
	
	public void setPrivacyBox() {
		checkPrivacyBox.click();
	}
	
	public void clickContinue() {
		continueBox.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	

}
