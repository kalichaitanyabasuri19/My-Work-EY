package Testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reusables.BaseTest;
import Reusables.Browsers;
import Reusables.Steps;
import Reusables.common_methods;

public class VerifyLogin_Functionality extends BaseTest {
	
	WebDriver driver;
	String Browsertype;
	Properties prop ;
	String url;
	@Test(groups= {"SmokeTest"})
	public void verifyLoginFunctionality() throws IOException {
		try {
		driver=new Browsers().getDriver();	
		Steps s=new Steps();
		prop = readPropertiesFile(".\\src\\Config\\Application.properties");
		url=prop.getProperty("Application_url");
		Steps.launch_url(driver,url);
		String username=prop.getProperty("user_name");
		String password=prop.getProperty("password");
		s.verifyloginWithoutEnteringUserCreadentials(driver,"","");
		s.verifyloginbyEnteringvalidUsername(driver,username);
		s.verifyloginWithInvalidpassword(driver,username,"odfgdfgdfg");
		s.login(driver,username,password);
		
		}
		catch(Exception e) {
			Takescreenshot(driver, "./src/Screenshots/verifyLoginFunctionality.jpg");
		}
	}

}
