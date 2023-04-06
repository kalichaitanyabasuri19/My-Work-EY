package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import GlobalReusables.Datatable;
import GlobalReusables.ReusableWebElement;

public class Login {
	
	public static String login(WebDriver driver,String OR_File,String TestData,String URL,int DatasetNo){
		
		
		ReusableWebElement Element=new ReusableWebElement(OR_File);
		
		driver.get(URL);
		driver.manage().window().maximize();
		
		Datatable datatable=new Datatable();
		datatable.openExcelSheet(TestData);
		datatable.setSheet("Register");
		try{
			
			
			return "Pass";
		}
		catch(Exception e){
			e.printStackTrace();
			return "Fail";
		}
		
		
	}

}
