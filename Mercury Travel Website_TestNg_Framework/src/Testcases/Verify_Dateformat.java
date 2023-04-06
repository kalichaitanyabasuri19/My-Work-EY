package Testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object_Repository.Book_Flight_Online_Screen;
import Reusables.BaseTest;
import Reusables.Browsers;
import Reusables.Datatable;
import Reusables.Steps;

public class Verify_Dateformat extends BaseTest{

	WebDriver driver;
	String Browsertype;
	Properties prop ;
	@Test(groups= {"SmokeTest"})
	public void Verify_Dateformat()  {
		try {
			prop = readPropertiesFile(".\\src\\Config\\Application.properties");
			driver=new Browsers().getDriver();
			Datatable datatable=new Datatable();
			datatable.openExcelSheet(prop.getProperty("testdata"));
			datatable.setSheet("FlightData");
			String from=datatable.getValuefromCell("from", 1);
			String to=datatable.getValuefromCell("to", 1);
			String cabinclass=datatable.getValuefromCell("cabinclass", 1);
			Book_Flight_Online_Screen bs=new Book_Flight_Online_Screen(driver);
			String fromformat=bs.fromDateFormat.getAttribute("data-date-format").toUpperCase();
			String toformat=bs.toDateFormat.getAttribute("data-date-format").toUpperCase();
			if(fromformat.contentEquals("DD/MM/YY")) {
				Reporter.log("Application accepting the date format of DD/MM/YY");
				Assert.assertEquals("DD/MM/YY", fromformat);
			}
			else {
				Reporter.log("Application not accepting the date format of DD/MM/YY");
				
			}
			if(fromformat.contentEquals("MM/DD/YY")) {
				Assert.assertEquals("MM/DD/YY", fromformat);
				Reporter.log("Application accepting the date format of MM/DD/YY");
			}
			else {
				Reporter.log("Application not accepting the date format of MM/DD/YY");
			}
			if(fromformat.contentEquals("M/D/YY")) {
				Assert.assertEquals("M/D/YY", fromformat);
				Reporter.log("Application accepting the single digit date format of M/D/YY");
			}
			else {
				Reporter.log("Application not accepting the single digit date format of M/D/YY");
			}
			EnterValuesIntoTextBox(driver, bs.fromCity, from);
			click(driver,bs.selectcity);
			EnterValuesIntoTextBox(driver, bs.toCity, to);
			wait(3);
			click(driver,bs.selectto(to));
			
			selectDateto(driver,datatable.getValuefromCell("year1", 1),datatable.getValuefromCell("month1", 1),datatable.getValuefromCell("date2", 1));
			selectDate(driver,datatable.getValuefromCell("year1", 1),datatable.getValuefromCell("month1", 1),datatable.getValuefromCell("date1", 1));
			selectByIndex(bs.adults, 1);
			selectByIndex(bs.childs, 1);
			selectByIndex(bs.infants, 1);
			selectBytext(bs.cabinClass,cabinclass);
			click(driver, bs.searchFlightsBtn);
			Reporter.log("Flight filtering is working fine");
			
			
		}
		catch(Exception e) {
			Takescreenshot(driver, "./src/Screenshots/Verify_Dateformat.jpg");
		}
	}


}
