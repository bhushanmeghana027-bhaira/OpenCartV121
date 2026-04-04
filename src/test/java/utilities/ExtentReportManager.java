package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReportManager implements ITestListener {
	  public ExtentSparkReporter sparkReporter;  // UI of the report
	    public ExtentReports extent;               // populate common info on the report
	    public ExtentTest test;                    // create test entries & update status
	    String repName;
	    public void onStart(ITestContext context) {
	    	
//	    	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//	    	Date dt = new Date();
//	    	String currentdatetimestamp=df.format(dt);
	    	
	    	
	    	String timeStamp = new SimpleDateFormat("yyyy.MM..dd.HH.mm.ss").format(new Date());
	    	repName = "Test-Report-"+timeStamp+".html";
	        sparkReporter = new ExtentSparkReporter(".\\reports\\"+ repName);

	        sparkReporter.config().setDocumentTitle("Automation Report"); // title
	        sparkReporter.config().setReportName("Functional Testing");   // report name
	        sparkReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        extent.setSystemInfo("Computer Name", "localhost");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Tester Name", "Pavan");
	        extent.setSystemInfo("OS", "Windows10");
	        extent.setSystemInfo("Browser name", "Chrome");
	    }
	    public void onTestSuccess(ITestResult result) {

	        test = extent.createTest(result.getName()); // create a new entry in the report
	        test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status
	    }
	    
	    public void onTestFailure(ITestResult result) {

	        test = extent.createTest(result.getName());
	        test.assignCategory(result.getMethod().getGroups());

	        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
	        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable().getMessage());
	        
	        try {
	        	String imgPath = new BaseClass().captureScreen(result.getName());
	        	test.addScreenCaptureFromPath(imgPath);
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	
	        }
	    }
	    public void onTestSkipped(ITestResult result) {

	        test = extent.createTest(result.getName());
	        test.assignCategory(result.getMethod().getGroups());

	        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	        test.log(Status.INFO, result.getThrowable().getMessage());
	    }
	    public void onFinish(ITestContext context) {
	    	extent.flush();
	    	
	    	String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
	    	File extentReport = new File(pathOfExtentReport);
	    	
	    	try {
	    		Desktop.getDesktop().browse(extentReport.toURI());
	    		
	    	}catch(IOException e1){
	    		e1.printStackTrace();
	    	}
	    	
	    	
	    	
	    }
}