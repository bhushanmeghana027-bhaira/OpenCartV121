package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePAge;
import testbase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass {
	
	@Test(groups={"Regression", "master"})
	public void verify_Account_Registration_Page() {
		logger.info("***Starting TC001_AccountRegisteration***");
		try {
		HomePAge hp = new HomePAge(driver);
		hp.clickAccount();
		logger.info("Clicked on my account ");
		hp.clickRegister();
		logger.info("Clicked on my register link ");
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		logger.info("Provideng customer details");
		arp.setFirstName(randomStringGene().toUpperCase());
		arp.setLasttName(randomStringGene().toUpperCase());
		arp.setEmail(randomStringGene()+"@gmail.com");
		arp.setTel(randomNumGene());
		String pass = randomAlphaNumeric();
		arp.setPwd(pass);
		arp.setConfirmPwd(pass);
		arp.setPrivacyBox();
		arp.clickContinue();
		logger.info("validating expected message");
		String msg = arp.getConfirmationMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("tc0001 finished");
		
	}

	
}
