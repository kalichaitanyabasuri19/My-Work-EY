package Testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Reusables.Browsers;
import Reusables.Steps;
import Reusables.common_methods;

public class VerifyLogin_Functionality extends Steps {
	
	WebDriver driver;
	String Browsertype;
	Properties prop ;
	String url;
	
	
	@BeforeTest
	public void setup() throws IOException {
		prop = readPropertiesFile(".\\src\\Config\\Application.properties");
		Browsertype=prop.getProperty("Browser");
		url=prop.getProperty("Application_url");
		Browsers.SetWebDriver(Browsertype);
		
	}
	

	@Test
	public void verifyLoginFunctionality() throws IOException {
		try {
		driver=new Browsers().getDriver();	
		launch_url(driver,url);
		String username=prop.getProperty("user_name");
		String password=prop.getProperty("password");
		verifyloginWithoutEnteringUserCreadentials(driver,"","");
		verifyloginbyEnteringvalidUsername(driver,username);
		verifyloginWithInvalidpassword(driver,username,"odfgdfgdfg");
		login(driver,username,password);
		
		}
		catch(Exception e) {
			
		}
	}

}
