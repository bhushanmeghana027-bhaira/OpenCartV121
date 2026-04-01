package testbase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	protected WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomStringGene() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumGene() {
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNum = RandomStringUtils.randomNumeric(3);
		return generatedString+generatedNum;
	}
		
}

