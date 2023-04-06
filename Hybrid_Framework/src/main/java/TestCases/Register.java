package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import GlobalReusables.Datatable;
import GlobalReusables.ReusableWebElement;

public class Register {
	

	public static String register(WebDriver driver,String OR_File,String TestData,String URL,int DatasetNo){
		
		
		ReusableWebElement Element=new ReusableWebElement(OR_File);
		
		driver.get(URL);
		driver.manage().window().maximize();
		Datatable datatable=new Datatable();
		datatable.openExcelSheet(TestData);
		datatable.setSheet("Register");
		try{
			Element.EnterValueIntoTextBox(driver, "email", datatable.getValuefromCell("EmailAddress", DatasetNo));
			Element.ClickWebElement(driver, "submit");
			Thread.sleep(6000);
			Element.ClickWebElement(driver, "salutation");
			Thread.sleep(2000);
			Element.EnterValueIntoTextBox(driver, "cfirstname", datatable.getValuefromCell("FirstName", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "clastname", datatable.getValuefromCell("LastName", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "cemail", datatable.getValuefromCell("EmailAddress", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "cpwd", datatable.getValuefromCell("Password", DatasetNo));
			Element.selectDropDownListSpaces(driver, "cday", datatable.getValuefromCell("Day", DatasetNo));
			Element.selectDropDownListSpaces(driver, "cmonth", datatable.getValuefromCell("Month", DatasetNo));
			Element.selectDropDownListSpaces(driver, "cyear", datatable.getValuefromCell("Year", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "firstname", datatable.getValuefromCell("FirstName", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "lastname", datatable.getValuefromCell("LastName", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "company", datatable.getValuefromCell("Company", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "address", datatable.getValuefromCell("Address", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "city", datatable.getValuefromCell("City", DatasetNo));
			Element.selectDropDownList(driver, "state", datatable.getValuefromCell("State", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "postcode", datatable.getValuefromCell("Zip", DatasetNo));
			Element.selectDropDownList(driver, "id_country", datatable.getValuefromCell("Country", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "other", datatable.getValuefromCell("Other", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "homephone", datatable.getValuefromCell("HomeNumber", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "phone", datatable.getValuefromCell("Mobile", DatasetNo));
			Element.EnterValueIntoTextBox(driver, "addressalias", datatable.getValuefromCell("Address", DatasetNo));
//			Element.ClickWebElement(driver, "registerbutton");
			return "Pass";
			
		}
		catch(Exception e){
//			e.printStackTrace();
			return "Fail";
		}
		
		
	}

}
