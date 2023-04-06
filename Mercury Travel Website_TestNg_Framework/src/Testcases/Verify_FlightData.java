package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object_Repository.Book_Flight_Online_Screen;
import Object_Repository.Flight_Data;
import Reusables.BaseTest;
import Reusables.Browsers;
import Reusables.Datatable;
import Reusables.Steps;

public class Verify_FlightData extends BaseTest{
	private static final String proirity = null;
	WebDriver driver;
	@Test(priority=1, groups= {"SmokeTest"})
	public void Verify_FlightInformation()  {
		try {
			Properties prop = readPropertiesFile(".\\src\\Config\\Application.properties");
			Datatable datatable=new Datatable();
			datatable.openExcelSheet(prop.getProperty("testdata"));
			datatable.setSheet("FlightData");
			driver=new Browsers().getDriver();
			Book_Flight_Online_Screen bs=new Book_Flight_Online_Screen(driver);
			Flight_Data fd=new Flight_Data(driver);
			Book_Flight_Online_Screen fs=new Book_Flight_Online_Screen(driver);
			wait(10);
			driver.switchTo().frame(fd.closeframe);
			if(checkElement(fd.close)==true) {
				click(driver, fd.close);
			}
			driver.switchTo().defaultContent();
			scrollandclick(driver, fd.search);
			cleartext(driver, fs.toCity);
			EnterValuesIntoTextBox(driver,fs.toCity,datatable.getValuefromCell("to", 1));
			wait(1);
			List<String> destination=new ArrayList();
			for(WebElement a:fd.dest) {
				wait(1);
				destination.add(a.getText());
			}
			click(driver,bs.selectcity);
			click(driver,bs.searchFlightsBtn);
			wait(1);
			System.out.println(destination.toString());
			Reporter.log(destination.toString());
		}
		catch(Exception e) {
			Takescreenshot(driver, "./src/Screenshots/Verify_FlightInformation.jpg");
		}
	}
	
	@Test(priority=2 , groups= {"SmokeTest"})
	public void Verify_FlightDetails()  {
		try {
			Properties prop = readPropertiesFile(".\\src\\Config\\Application.properties");
			driver=new Browsers().getDriver();
			Datatable datatable=new Datatable();
			datatable.openExcelSheet(prop.getProperty("testdata"));
			datatable.setSheet("FlightData");
			Book_Flight_Online_Screen bs=new Book_Flight_Online_Screen(driver);
			Flight_Data fd=new Flight_Data(driver);
			Book_Flight_Online_Screen fs=new Book_Flight_Online_Screen(driver);
			wait(7);
			scrollandclick(driver, fd.flightbookdetails);
			List<String> flightinfo1=new ArrayList();
			wait(3);
			for(WebElement aa:fd.flightinfo) {
				wait(2);
				flightinfo1.add(aa.getText());
				System.out.println(aa.getText());
				if(aa.getText().contains("Date")) {
					String [] todate=aa.getText().split(":");
					if(todate[1].equals(datatable.getValuefromCell("FromDate", 1))) {
						Reporter.log("Travel From date is matching ");	
				}
			}
				Reporter.log(aa.getText());
			}
			wait(4);
			if(checkElement(fd.close3)==true) {
			click(driver,fd.close3);
			}
			
			scrollandclick(driver, fd.flightbookdetails2);
			List<String> flightinfo2=new ArrayList();
			wait(3);
			for(WebElement aa:fd.flightinfo) {
				wait(2);
				flightinfo2.add(aa.getText());
				System.out.println(aa.getText());
				if(aa.getText().contains("Date")) {
					String [] todate=aa.getText().split(":");
					if(todate[1].equals(datatable.getValuefromCell("ToDate", 1))) {
						Reporter.log("Travel To date is matching ");	
				}
			}
				
				Reporter.log(aa.getText());
			}
			wait(4);
			if(checkElement(fd.close3)==true) {
			click(driver,fd.close3);
			}
			Reporter.log(flightinfo1.toString());
			fd.booknowbtn.click();
		}
		catch(Exception e) {
			Takescreenshot(driver, "./src/Screenshots/Verify_FlightDetails.jpg");
		}
	}


}
