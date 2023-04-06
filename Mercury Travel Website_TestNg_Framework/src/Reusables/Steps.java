package Reusables;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import Object_Repository.Login_Screen;

public class Steps extends common_methods {
	
	
	
	public static void launch_url(WebDriver driver,String url) {
		try {
			driver.get(url);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void login(WebDriver driver, String username,String password) {
		try {
			Login_Screen l=new Login_Screen(driver);
			EnterValuesIntoTextBox(driver, l.inputenteremail, username);
			EnterValuesIntoTextBox(driver, l.inputenterpwd, password);
			click(driver,l.loginbtn);
			Thread.sleep(3000);
			Assert.assertEquals(true, l.welcometext.isDisplayed());
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public void verifyloginWithInvalidUser(WebDriver driver,String url , String username,String password) {
		try {
			Login_Screen l=new Login_Screen(driver);
		
			EnterValuesIntoTextBox(driver, l.inputenteremail, username);
			EnterValuesIntoTextBox(driver, l.inputenterpwd, password);
			click(driver,l.loginbtn);
			Assert.assertEquals(gettextofWebElement(driver,l.emailvalidationtext), "This value should be a valid email.");
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
}
	public void verifyloginWithoutEnteringUserCreadentials(WebDriver driver, String username,String password) {
		try {
			Login_Screen l=new Login_Screen(driver);
			click(driver,l.customerloginbtn);
			click(driver,l.userloginoption);
			click(driver,l.loginbtn);
			Assert.assertEquals(gettextofWebElement(driver,l.errorValidationusrname), "This value is required.");
			Assert.assertEquals(gettextofWebElement(driver,l.errorValidationpwd), "This value is required.");
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public void verifyloginbyEnteringvalidUsername(WebDriver driver , String username) {
		try {
			Login_Screen l=new Login_Screen(driver);
			EnterValuesIntoTextBox(driver, l.inputenteremail, username);
			click(driver,l.loginbtn);
			Reporter.log("Expected Value \"This value is required.\" and Actual Values in Application is "+  gettextofWebElement(driver,l.errorValidationusrname));
			Assert.assertEquals(gettextofWebElement(driver,l.errorValidationusrname), "This value is required.");
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public void verifyloginWithInvalidpassword(WebDriver driver, String username,String password) {
		try {
			Login_Screen l=new Login_Screen(driver);

			EnterValuesIntoTextBox(driver, l.inputenteremail, username);
			EnterValuesIntoTextBox(driver, l.inputenterpwd, password);
			click(driver,l.loginbtn);
			Reporter.log("Expected Value " + gettextofWebElement(driver,l.passwordinvalidmsg) + "and Actual Value in Application is Incorrect email address and password combination. Please try again.");
			Assert.assertEquals(gettextofWebElement(driver,l.passwordinvalidmsg), "Incorrect email address and password combination. Please try again.");
		
			click(driver,l.closeerror);
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
}
}
