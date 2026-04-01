package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePAge;
import testbase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass {
	
	@Test
	public void verify_Account_Registration_Page() {
		HomePAge hp = new HomePAge(driver);
		hp.clickAccount();
		hp.clickRegister();
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		arp.setFirstName(randomStringGene().toUpperCase());
		arp.setLasttName(randomStringGene().toUpperCase());
		arp.setEmail(randomStringGene()+"@gmail.com");
		arp.setTel(randomNumGene());
		String pass = randomAlphaNumeric();
		arp.setPwd(pass);
		arp.setConfirmPwd(pass);
		arp.setPrivacyBox();
		arp.clickContinue();
		String msg = arp.getConfirmationMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		
	}

	
}
