package Reusables;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Extentreport.ReportConfiguration;

public class BaseTest  extends ReportConfiguration {
	    public WebDriver driver;
		String Browsertype;
		Properties prop ;
		String url;
	

//		@BeforeClass
//	public void startReport() throws IOException {
//			prop = readPropertiesFile(".\\src\\Config\\Application.properties");
//			Browsertype=prop.getProperty("Browser");
//			url=prop.getProperty("Application_url");
//			Browsers.SetWebDriver(Browsertype);
//	        
//
//	}
		
	    @BeforeTest(groups= {"SmokeTest"})
		public void setup() throws IOException {
			prop = readPropertiesFile(".\\src\\Config\\Application.properties");
			Browsertype=prop.getProperty("Browser");
			url=prop.getProperty("Application_url");
			Browsers.SetWebDriver(Browsertype);
			ReportConfiguration.ExtendReportConfiguraiton();
		}
		
	    @AfterTest
	    public void getResult(ITestResult result) throws Exception{
	    	if(result.getStatus() == ITestResult.FAILURE){
	    //MarkupHelper is used to display the output in different colors
	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	    	
	    	String screenshotPath = common_methods.getScreenShot(driver, result.getName());
	    	
	    	logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	    	}
	    	else if(result.getStatus() == ITestResult.SKIP){
	    	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	    	}
	    	else if(result.getStatus() == ITestResult.SUCCESS)
	    	{
	    	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    	}
	    	driver.quit();
	    	}
	    }

