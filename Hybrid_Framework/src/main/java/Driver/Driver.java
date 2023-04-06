
package Driver;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.xml.parsers.ParserConfigurationException;
import jxl.write.WriteException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import GlobalReusables.Datatable;
import GlobalReusables.HTMLResults;
import TestCases.Browser;

//@SuppressWarnings("static-access")
public class Driver {
	static long startTime=System.currentTimeMillis();
	static String sTime=HTMLResults.DateTime();
	static WebDriver driver;
	static String Result;
	@SuppressWarnings("deprecation")
	public static void scriptDriverMethod(String strTCPath,String strSheetName) throws ParserConfigurationException, IOException, SAXException, InterruptedException, WriteException{
		Datatable dataTable=new Datatable();
		dataTable.resultFile(strTCPath);
		dataTable.result_SetSheet("Configurations");
		String app_version=dataTable.result_GetValuefromCell("Application_Version",1);
		String browser=dataTable.result_GetValuefromCell("Browser",1);
		String browser_version=dataTable.result_GetValuefromCell("Browser_Version",1);
		String application_URL=dataTable.result_GetValuefromCell("Application_URL",1);
		System.out.println(browser+"  "+browser_version+"  "+app_version+"  "+application_URL);
	    dataTable.result_SetSheet(strSheetName);
	    int rowCount=dataTable.result_GetRowCount();
		int columnCount=dataTable.result_GetColumnCount();
		System.out.println("rows are :  "+rowCount+"   "+"Columns are  :  "+columnCount);
		try {
			dataTable.writeStyleString1(dataTable.result_GetCurrentSheet(), 5, 0, "TEST RESULT");
		} catch (WriteException e1) {
			e1.printStackTrace();
			dataTable.writeStyleString1(dataTable.result_GetCurrentSheet(), 5, 0, "TEST RESULT");
		}
		try{
			driver=Browser.Open(driver,browser);
			String URL=application_URL;
			
		for (int row=1;row<rowCount;row++)
		{	 
			Object testResult=null;
		    Class<?> MainClass=null;
		    Object object=null;
			String main_Scenario_Exec=dataTable.result_GetValuefromCell("Scenario_Required",row);
			String sub_Scenario_Exec=dataTable.result_GetValuefromCell("DataSet_Required",row);
			String func_Exec=dataTable.result_GetValuefromCell("TestCase_Required",row);
			if ((main_Scenario_Exec.equalsIgnoreCase("yes")))
			{
					//Function Calling
					String sub_Scenario=dataTable.result_GetValuefromCell("DataSet",row);
					int dataSetNo=Integer.parseInt(sub_Scenario);
					String function_Field=dataTable.result_GetValuefromCell("TestCase",row);
					System.out.println("row is "+ row);
				    String[] func_Field=function_Field.split("/");
					String scenario_Main_Class=func_Field[0];
					String scenario_Main_Method=func_Field[1];
					String TestData = ".\\src\\main\\java\\TestData\\TestData.xls";
					System.out.println("Executing Main Class  : "+scenario_Main_Class);
					MainClass=Class.forName("TestCases."+scenario_Main_Class);
					object=MainClass.newInstance();
					Method method=MainClass.getMethod(scenario_Main_Method,WebDriver.class,String.class,String.class,String.class,int.class);
					System.out.println("Calling Method  :  "+scenario_Main_Method);
					String OR_File=".\\src\\main\\java\\ObjectRepository\\"+scenario_Main_Method+".xml";
					testResult=method.invoke(object,driver,OR_File,TestData,URL,dataSetNo).toString();
					Result=testResult.toString();
					try{
					
					if(Result.equalsIgnoreCase("Pass")){
						
						dataTable.writeStyleString(dataTable.result_GetCurrentSheet(), 5, row, Result);
					}
					if (Result.equalsIgnoreCase("Fail")){
						dataTable.writeStyleString3(dataTable.result_GetCurrentSheet(), 5, row, Result);
					}
					}
					catch(Exception e){
						
						if(Result.equalsIgnoreCase("Pass")){
							
							dataTable.writeStyleString(dataTable.result_GetCurrentSheet(), 5, row, Result);
						}
							
						if (Result.equalsIgnoreCase("Fail")){
							dataTable.writeStyleString3(dataTable.result_GetCurrentSheet(), 5, row, Result);
							
						}
					}
			}
			else {
				dataTable.writeStyleString3(dataTable.result_GetCurrentSheet(), 5, row, "Skipped");
			}
		dataTable.result_ExportToFile(".\\src\\main\\java\\TestResult\\Training_Result.xls");
		}
		dataTable.result_CloseFile();
		System.out.println("Driver Sheet Closed Successfully.");
		}
		catch (Exception e) {
	    	e.printStackTrace();
	    	dataTable.result_ExportToFile(".\\src\\main\\java\\TestResult\\Training_Result.xls");
	    	dataTable.result_CloseFile();
	    	System.out.println("Driver Sheet Closed Successfully");
		}
	
		long endTime=System.currentTimeMillis();
		String eTime=HTMLResults.DateTime();
		long execTime=(endTime-startTime);
		
		HTMLResults.HTMLTestCases(".\\src\\main\\java\\TestResult\\Training_Result.xls",execTime,sTime,eTime,app_version,browser,browser_version,application_URL);
		HTMLResults.HTMLPassTestCases(".\\src\\main\\java\\TestResult\\Training_Result.xls");
		HTMLResults.HTMLFailTestCases(".\\src\\main\\java\\TestResult\\Training_Result.xls");
		HTMLResults.HTMLSkipTestCases(".\\src\\main\\java\\TestResult\\Training_Result.xls");
		HTMLResults.CreateHTMLResult(".\\src\\main\\java\\TestResult\\Training_Result.xls",execTime,sTime,eTime,app_version,browser,browser_version,application_URL);
		
		
	
		
	}
	
}
