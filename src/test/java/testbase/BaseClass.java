package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity","master","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
//		loading the config.properties file
		FileReader file = new FileReader("./src//main//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger  = LogManager.getLogger(this.getClass());
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name.,.,");
			return;
		}
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
//		after u write conf,properties and add properties and all here 
//		u can rewrite the above statement as 
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","master","Regression"})
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
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}
		
}

