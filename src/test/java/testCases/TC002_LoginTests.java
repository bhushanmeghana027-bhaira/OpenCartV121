package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePAge;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testbase.BaseClass;

public class TC002_LoginTests extends BaseClass {
	
	@Test
	public void verify_login() {
		logger.info("Starting Tc002 login test");
		try {
//		home page
		HomePAge hp = new HomePAge(driver);
		hp.clickAccount();
		hp.clickLogin();
		
//		loginpage
		loginPage lp = new loginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("password"));
		lp.clicklogn();
		
		System.out.println("Email: " + p.getProperty("email"));
		System.out.println("Password: " + p.getProperty("password"));
		System.out.println("Login clicked");
		
//		myaccountpage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage =  mp.isMyAccPageExists();
		Assert.assertEquals(targetPage, true,"login failed");
//		Assert.assertTrue(targetPage);
		
		logger.info("Finishing testing");
	}catch(Exception e) {
		Assert.fail();
	}
		
		
		
	}

}
