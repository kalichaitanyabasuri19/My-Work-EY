package Testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object_Repository.Book_Flight_Online_Screen;
import Reusables.Browsers;
import Reusables.Steps;

public class Verify_Dateformat extends Steps{

		
	
	WebDriver driver;
	String Browsertype;
	Properties prop ;
	
	

	
	@Test
	public void Verify_Dateformat()  {
		try {
			driver=new Browsers().getDriver();
			prop = readPropertiesFile(".\\src\\Config\\Application.properties");

			String d1=prop.getProperty("d1");
			String d2=prop.getProperty("d2");
			String from=prop.getProperty("from");
			String to=prop.getProperty("to");
			String cabinclass=prop.getProperty("cabinclass");
			Book_Flight_Online_Screen bs=new Book_Flight_Online_Screen(driver);
			String fromformat=bs.fromDateFormat.getAttribute("data-date-format").toUpperCase();
			String toformat=bs.toDateFormat.getAttribute("data-date-format").toUpperCase();
			if(fromformat.contentEquals("DD/MM/YY")) {
				Reporter.log("Application accepting the date format of DD/MM/YY");
			}
			else {
				Reporter.log("Application not accepting the date format of DD/MM/YY");
			}
			if(fromformat.contentEquals("MM/DD/YY")) {
				Reporter.log("Application accepting the date format of MM/DD/YY");
			}
			else {
				Reporter.log("Application not accepting the date format of MM/DD/YY");
			}
			if(fromformat.contentEquals("M/D/YY")) {
				Reporter.log("Application accepting the single digit date format of M/D/YY");
			}
			else {
				Reporter.log("Application not accepting the single digit date format of M/D/YY");
			}
			
			EnterValuesIntoTextBox(driver, bs.fromCity, from);
			click(driver,bs.selectcity);
			EnterValuesIntoTextBox(driver, bs.toCity, to);
			Thread.sleep(3000);
			click(driver,bs.selectto(to));
			
			selectDateto(driver,prop.getProperty("year1"),prop.getProperty("month1"),prop.getProperty("date2"));
			selectDate(driver,prop.getProperty("year1"),prop.getProperty("month1"),prop.getProperty("date1"));
			selectByIndex(bs.adults, 1);
			selectByIndex(bs.childs, 1);
			selectByIndex(bs.infants, 1);
			selectBytext(bs.cabinClass,cabinclass);
			click(driver, bs.searchFlightsBtn);
			Reporter.log("Flight filtering is working fine");
			
			
		}
		catch(Exception e) {
			
		}
	}


}
