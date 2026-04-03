package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePAge;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String pwd , String exp)  {
		logger.info("****TC003LoginDDt is started");
		try {
//		home page
		
		HomePAge hp = new HomePAge(driver);
		hp.clickAccount();
		hp.clickLogin();
		
//		loginpage
		loginPage lp = new loginPage(driver);
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.clicklogn();
		
		
//		myaccountpage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage =  mp.isMyAccPageExists();
		Assert.assertEquals(targetPage, true,"login failed");
		/*
		 * Data is valid  - login success - test pass - logout
		 * 					login failed - test failed 
		 * 
		 * Data is invalid  - login success - test fail -logout
		 * 					login failed - test pass
		 */
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				mp.logoutClick();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("inValid")) {
			if(targetPage==true) {
				mp.logoutClick();
				Assert.assertTrue(false);
			
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("fimishe execution of TC003");
	}
}

