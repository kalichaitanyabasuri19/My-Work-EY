package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object_Repository.Book_Flight_Online_Screen;
import Object_Repository.Flight_Data;
import Reusables.Browsers;
import Reusables.Steps;

public class Verify_FlightData extends Steps{
	private static final String proirity = null;
	WebDriver driver;
	@Test(priority=1)
	public void Verify_FlightInformation()  {
		try {
			Properties prop = readPropertiesFile(".\\src\\Config\\Application.properties");
			driver=new Browsers().getDriver();
			Book_Flight_Online_Screen bs=new Book_Flight_Online_Screen(driver);
			Flight_Data fd=new Flight_Data(driver);
			Book_Flight_Online_Screen fs=new Book_Flight_Online_Screen(driver);
			Thread.sleep(10000);
			driver.switchTo().frame(fd.closeframe);
			if(checkElement(fd.close)==true) {
				click(driver, fd.close);
			}
			
			driver.switchTo().defaultContent();
			scrollandclick(driver, fd.search);
			cleartext(driver, fs.toCity);
			EnterValuesIntoTextBox(driver,fs.toCity,prop.getProperty("to"));
			Thread.sleep(1000);
			List<String> destination=new ArrayList();
			for(WebElement a:fd.dest) {
				Thread.sleep(1000);
				destination.add(a.getText());
			}
			click(driver,bs.selectcity);
			click(driver,bs.searchFlightsBtn);
			Thread.sleep(1000);
			System.out.println(destination.toString());
			Reporter.log(destination.toString());
		}
		catch(Exception e) {
		}
	}
	
	@Test(priority=2)
	public void Verify_FlightDetails()  {
		try {
			Properties prop = readPropertiesFile(".\\src\\Config\\Application.properties");
			driver=new Browsers().getDriver();
			Book_Flight_Online_Screen bs=new Book_Flight_Online_Screen(driver);
			Flight_Data fd=new Flight_Data(driver);
			Book_Flight_Online_Screen fs=new Book_Flight_Online_Screen(driver);
			Thread.sleep(7000);
			scrollandclick(driver, fd.flightbookdetails);
			List<String> flightinfo1=new ArrayList();
			Thread.sleep(3000);
			for(WebElement aa:fd.flightinfo) {
				Thread.sleep(2000);
				flightinfo1.add(aa.getText());
				System.out.println(aa.getText());
				Reporter.log(aa.getText());
			}
			Thread.sleep(4000);
			if(checkElement(fd.close2)==true) {
			click(driver,fd.close2);
			}
			
			scrollandclick(driver, fd.flightbookdetails2);
			List<String> flightinfo2=new ArrayList();
			Thread.sleep(3000);
			for(WebElement aa:fd.flightinfo) {
				Thread.sleep(2000);
				flightinfo2.add(aa.getText());
				System.out.println(aa.getText());
				Reporter.log(aa.getText());
			}
//			driver.switchTo().frame(fd.closeframe);
//			if(checkElement(fd.close)==true) {
//				click(driver, fd.close);
//			}
//			driver.switchTo().defaultContent();
			Thread.sleep(4000);
			if(checkElement(fd.close2)==true) {
			click(driver,fd.close2);
			}
			Reporter.log(flightinfo1.toString());
			fd.booknowbtn.click();
		}
		catch(Exception e) {
		}
	}


}
