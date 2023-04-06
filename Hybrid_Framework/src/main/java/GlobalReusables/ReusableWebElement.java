package GlobalReusables;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.google.common.io.Files;


public class ReusableWebElement {
	public static WebDriver driver = null;
	public static WebElement Element = null;
	public static List<WebElement> Elements = null;
	String file;
	 DocumentBuilderFactory dbf;
	 DocumentBuilder db;
	 Document document ;
	 public String ElementDataType;
	 
public ReusableWebElement(String filename){
		try {
			dbf = DocumentBuilderFactory.newInstance();
		 	db   = dbf.newDocumentBuilder();
			document = db.parse(new File(filename));
			System.out.println(document.getElementsByTagName("Element").getLength());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("File not found.");
			}
	}        
    public  WebElement getElement(WebDriver driver,String ElementName) {
    	try 
    	{
    	   	NodeList nodeList = this.document.getElementsByTagName("Element");
    	   	for(int x=0;x<nodeList.getLength(); x++) 
	        {
	        	String FieldName=nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue(); //returns locator user defined name
	    		if(FieldName.equalsIgnoreCase(ElementName))
	        	{
	        		ElementName=nodeList.item(x).getTextContent(); //Returns locator value
	        		String LocatorType=nodeList.item(x).getAttributes().getNamedItem("locator").getNodeValue();  //returns locator type
	        		
	        		
	        		if(LocatorType.equalsIgnoreCase("id"))
	        		{
	        			Element=driver.findElement(By.id(ElementName));	
	        		}
	        		else if(LocatorType.equalsIgnoreCase("name"))
	        		{
	        			Element=driver.findElement(By.name(ElementName));
	        		}
	        		else if(LocatorType.equalsIgnoreCase("className"))
	        		{
	        			Element=driver.findElement(By.className(ElementName));
	        		}
	        		else if(LocatorType.equalsIgnoreCase("cssSelector"))
	        		{
	        			Element=driver.findElement(By.cssSelector(ElementName));
	        		}
	        		else if(LocatorType.equalsIgnoreCase("xpath"))
	        		{
		    			Element=driver.findElement(By.xpath(ElementName));
		    		}
	        		else if(LocatorType.equalsIgnoreCase("linkText")){
		    			Element=driver.findElement(By.linkText(ElementName));
		    		}
	        		else if(LocatorType.equalsIgnoreCase("partialLinkText"))
	        		{
		    			Element=driver.findElement(By.partialLinkText(ElementName));
		    		}
	        		else if(LocatorType.equalsIgnoreCase("tagName")){
		    			Element=driver.findElement(By.tagName(ElementName));
		    		}
	        		else 
	        		{
	        			Element = null;
	        		}
	        		return Element;
	        	}
	        }	
    	   	if(Element.equals(null)){
    	   		System.out.println("Element not found.");
    	   	}
    	   	return Element;
    	} 
    	catch (Exception e) 
    	{
    		//e.printStackTrace();
    		//System.out.println("Element not found.");    
    		return null;
    	}
		
	} 
    
    
    public  List<WebElement> getElements(WebDriver driver,String ElementName) {
    	try 
    	{
    	   	NodeList nodeList = this.document.getElementsByTagName("Element");
    	   	for(int x=0;x<nodeList.getLength(); x++) 
	        {
	        	String FieldName=nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue(); //returns locator user defined name
	    		if(FieldName.equalsIgnoreCase(ElementName))
	        	{
	        		ElementName=nodeList.item(x).getTextContent(); //Returns locator value
	        		String LocatorType=nodeList.item(x).getAttributes().getNamedItem("locator").getNodeValue();  //returns locator type
	        		
	        		
	        		if(LocatorType.equalsIgnoreCase("id"))
	        		{
	        			Elements=driver.findElements(By.id(ElementName));	
	        		}
	        		else if(LocatorType.equalsIgnoreCase("name"))
	        		{
	        			Elements=driver.findElements(By.name(ElementName));
	        		}
	        		else if(LocatorType.equalsIgnoreCase("className"))
	        		{
	        			Elements=driver.findElements(By.className(ElementName));
	        		}
	        		else if(LocatorType.equalsIgnoreCase("cssSelector"))
	        		{
	        			Elements=driver.findElements(By.cssSelector(ElementName));
	        		}
	        		else if(LocatorType.equalsIgnoreCase("xpath"))
	        		{
		    			Elements=driver.findElements(By.xpath(ElementName));
		    		}
	        		else if(LocatorType.equalsIgnoreCase("linkText")){
		    			Elements=driver.findElements(By.linkText(ElementName));
		    		}
	        		else if(LocatorType.equalsIgnoreCase("partialLinkText"))
	        		{
		    			Elements=driver.findElements(By.partialLinkText(ElementName));
		    		}
	        		else if(LocatorType.equalsIgnoreCase("tagName")){
		    			Elements=driver.findElements(By.tagName(ElementName));
		    		}
	        		else 
	        		{
	        			Elements = null;
	        		}
	        		return Elements;
	        	}
	        }	
    	   	if(Elements.equals(null)){
    	   		System.out.println("Elements not found.");
    	   	}
    	   	return Elements;
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		System.out.println("Elements not found.");    
    		return null;
    	}
		
	} 
    
    
    public static void selectWindow(WebDriver driver){
       try{
    	for (String handle : driver.getWindowHandles()) {
          driver.switchTo().window(handle);	  
        } 
        }catch(Exception e){
    		e.printStackTrace();
    	}
        }
    
    public void selectFrame(WebDriver driver,String Name){
       try{
        driver.switchTo().frame(Name);
       }catch(Exception e)
       {
    	   e.printStackTrace();
       }

    }
    public  String GetLocatorValue(String ElementName) {
    	 
        NodeList nodeList = this.document.getElementsByTagName("Element");
        
        for(int x=0,size= nodeList.getLength(); x<size; x++) {
        String FieldName=nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue();
    	if(FieldName.equals(ElementName)){
    		ElementName=nodeList.item(x).getTextContent();
			
		}
    }
		return ElementName;
    }
   public  void selectDropDownList(WebDriver driver,String Name, String value) {
    	try{
    		WebElement Element=getElement(driver,Name);
        	new Select(Element).selectByVisibleText(value);
//        	.selectByValue(value);
        	//.selectByVisibleText(value);
    	}
    	catch(Exception e){
    	e.printStackTrace();
    	System.out.println("Can not select the element.");   
    	}
    	}
   
   public void selectDropDownListSpaces(WebDriver driver,String Name, String value) {
	   try{
	   WebElement Element=getElement(driver,Name);
	   Element.click();
	   Element.sendKeys(value);
	   driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	  
	   }
	   catch(Exception e){
	   e.printStackTrace();
	   System.out.println("Can not select the element."); 
	  }
	   }
   public void orderlink(WebDriver driver,String Name,String value){
	   try
	   {
		   WebElement Element=getElement(driver,Name);
		   Element.click();
		   Element.sendKeys(value);
		   driver.switchTo().activeElement().sendKeys(Keys.TAB);
		   driver.switchTo().activeElement().sendKeys(Keys.TAB);
		   driver.switchTo().activeElement().sendKeys(Keys.TAB);
		   driver.switchTo().activeElement().sendKeys(Keys.TAB);
		   
		  
		   }
		   catch(Exception e){
		   e.printStackTrace();
		   System.out.println("Can not select the element."); 
		  }
		   } 
	   
   
  
    public  void switchToWindow(WebDriver driver,String WindowName) {
    	WindowName=GetLocatorValue(WindowName);
    	driver.switchTo().window(WindowName);
    }
    public  void switchToFrame(WebDriver driver,String FrameName) 
    {
    	FrameName=GetLocatorValue(FrameName);
    	driver.switchTo().frame(FrameName);
    }
   public void takeSceenShot(WebDriver driver,String fileName){
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	   try {
		Files.copy(scrFile, new File("./src/Screen shots/"+fileName+".png"));
		  //FileUtils.copyFile(scrFile, new File("D://"+fileName+".jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
   }
    public  void EnterValueIntoTextBox(WebDriver driver,String ElementName,String Value) 
    {
    	try 
    	{
    	   	NodeList nodeList = this.document.getElementsByTagName("Element");
    	   	for(int x=0,size= nodeList.getLength(); x<size; x++) 
	        {
	        	String FieldName=nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue();
	    		if(FieldName.equalsIgnoreCase(ElementName))
	        	{
	        		ElementName=nodeList.item(x).getTextContent();
	        		String LocatorType=nodeList.item(x).getAttributes().getNamedItem("locator").getNodeValue();
	        		if(LocatorType.equalsIgnoreCase("id"))
	        		{
	        		driver.findElement(By.id(ElementName)).clear();
	        		driver.findElement(By.id(ElementName)).sendKeys(Value);
	        		}
	        		else if(LocatorType.equalsIgnoreCase("name"))
	        		{
	        			driver.findElement(By.name(ElementName)).clear();
		        		driver.findElement(By.name(ElementName)).sendKeys(Value);
	        		}
	        		else if(LocatorType.equalsIgnoreCase("className"))
	        		{
	        			driver.findElement(By.className(ElementName)).clear();
		        		driver.findElement(By.className(ElementName)).sendKeys(Value);
	        		}
	        		else if(LocatorType.equalsIgnoreCase("cssSelector"))
	        		{
	        			driver.findElement(By.cssSelector(ElementName)).clear();
		        		driver.findElement(By.cssSelector(ElementName)).sendKeys(Value);
	        		}
	        		else if(LocatorType.equalsIgnoreCase("xpath")){
	        			driver.findElement(By.xpath(ElementName)).clear();
		        		driver.findElement(By.xpath(ElementName)).sendKeys(Value);
		    		}
	        		else if(LocatorType.equalsIgnoreCase("linkText")){
	        			driver.findElement(By.linkText(ElementName)).clear();
		        		driver.findElement(By.linkText(ElementName)).sendKeys(Value);
		    		}
	        		else if(LocatorType.equalsIgnoreCase("partialLinkText")){
	        			driver.findElement(By.partialLinkText(ElementName)).clear();
		        		driver.findElement(By.partialLinkText(ElementName)).sendKeys(Value);
		    		}
	        		else if(LocatorType.equalsIgnoreCase("tagName")){
	        			driver.findElement(By.tagName(ElementName)).clear();
		        		driver.findElement(By.tagName(ElementName)).sendKeys(Value);
		    		}
	        		else 
	        		{
	        			ElementName=null;
	        			System.out.println("Locator type is not available.");
	        		}
	        	}
			
	        }	
    	 	if(ElementName.equals(null)){
    	   		System.out.println("Element not found.");
    	   	}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		System.out.println("Element not found.");    
    		
    	}
    }
   
    public  void ClickWebElement(WebDriver driver,String ElementName) 
    {
    	try 
    	{
    		NodeList nodeList = this.document.getElementsByTagName("Element");
    		for(int x=0,size= nodeList.getLength(); x<size; x++) 
    		{
    			String FieldName=nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue();
    			if(FieldName.equalsIgnoreCase(ElementName))
    			{
    				ElementName=nodeList.item(x).getTextContent();
    				String LocatorType=nodeList.item(x).getAttributes().getNamedItem("locator").getNodeValue();
    				if(LocatorType.equalsIgnoreCase("id"))
    				{
    					driver.findElement(By.id(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("name"))
    				{
    					driver.findElement(By.name(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("className"))
    				{
    					driver.findElement(By.className(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("cssSelector"))
    				{
    					driver.findElement(By.cssSelector(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("xpath")){
    					driver.findElement(By.xpath(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("linkText")){
    					driver.findElement(By.linkText(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("partialLinkText")){
    					driver.findElement(By.partialLinkText(ElementName)).click();
    				}
    				else if(LocatorType.equalsIgnoreCase("tagName")){
    					driver.findElement(By.tagName(ElementName)).click();
    				}
    				else 
    				{
    					ElementName=null;
    					System.out.println("Locator type is not available.");
    				}
    			}
    			
    		}	
    		if(ElementName.equals(null)){
    			System.out.println("Element not found.");
    		}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		System.out.println("Element not found.");    
    		
    	}
    }
    
  public static void pauseExecution(int secs){
  try {
		int Millisecond=secs*1000;
	  Thread.sleep(Millisecond);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
  }
   public void CatchErrorLog(Exception e,String path) throws IOException{
 		e.printStackTrace(new PrintStream(new File("C:\\Users\\testuser\\Desktop\\workspace\\Projects\\Screenshots\\src\\error log\\"+path+".html")));
 		}
   
   
   public  void autoList(WebDriver driver,String Name, String value) {
	   	try{
	   		WebElement Element=getElement(driver,Name);
	   		Element.click();
	   		Thread.sleep(500);
	   		Element.clear();
	   		Element.sendKeys(value);
	   		Thread.sleep(500);
	   		driver.switchTo().activeElement().sendKeys(Keys.TAB);
	    	}
	   	catch(Exception e){
	   	e.printStackTrace();
	   	System.out.println("Selected Element not exist.");   
	   	}
	   	}
   
public void SelectfromAutoList(WebDriver driver,String searchitem){
	   
	   try{
		   
	driver.findElement(By.xpath("//div[@class='ac_results']//li/strong[contains(text(),'"+searchitem+"')]")).click();
		   
		   
	   }catch (Exception e) 
   	{
   		//e.printStackTrace();
   		System.out.println("Unable to select from autolist");    
   		
   	}
}


public static String getFirstElement(WebDriver driver,String firstElement, String OR_File){
	   
	   String FirstElement = null;
	   try {
		 // System.out.println(firstElement);
		  
        Select select = new Select(new ReusableWebElement(OR_File).getElement(driver, firstElement));
		   
		   WebElement tmp = select.getFirstSelectedOption();
		  
		    FirstElement=tmp.getText();
		   
	   }   
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		FirstElement=e.getMessage();
	}
	return FirstElement;
	
}    


   public void uploadfile(WebDriver driver,String uploadbtn,String browsebtn,String filepath,String submitfile,String cancel){
	 
	 
 	  	   
	   try{
		   
		
		
		  driver.findElement(By.id(uploadbtn)).click();
			Thread.sleep(1000);
			try {
				if (driver.switchTo().alert() != null) {
					Alert alert = driver.switchTo().alert();
//					String alert1 = alert.getText();
//					System.out.println(alert1);
					alert.accept();
					}
			} catch (Exception e1) {}
			
			driver.findElement(By.id(browsebtn)).sendKeys(filepath);
			
			try {
				if (driver.switchTo().alert() != null) {
					Alert alert = driver.switchTo().alert();
					String alert1 = alert.getText();
					System.out.println(alert1);
					alert.accept();
					driver.findElement(
							By.xpath(cancel))
							.click();
				}
			} catch (Exception e) {

				
				
				driver.findElement(By.id(submitfile)).click();
				
				try {
					if (driver.switchTo().alert() != null) {
						Alert alert = driver.switchTo().alert();
						String alert1 = alert.getText();
						System.out.println(alert1);
						alert.accept();
						}
				} catch (Exception e1) {}
				
				Thread.sleep(1000);

				}
		   
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
	   }
 
 public int[] selectdate(WebDriver driver,String date){
	 int month1=0,year1=0;
 try{
	 
	 String[] date1=new String[5];
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
	Date date2 = sdf.parse(date);
	 String mnth=date.toString();
	 date1=mnth.split("-");
	
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(date2);
	year1 = cal.get(Calendar.YEAR);
	 month1=cal.get(Calendar.MONTH);
	int day=cal.get(Calendar.DAY_OF_MONTH);
	
	String monthString = new DateFormatSymbols().getMonths()[month1].substring(0, 3);
String year=Integer.toString(year1);

//	 System.out.println(year+"/"+monthString+"/"+day );
//	System.out.println(monthString);
//	// System.out.println(month+1);
//	 System.out.println(year);
//	 System.out.println(day);
	 
	 Thread.sleep(2000);
	  new
		Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"))).selectByVisibleText(year);
	 
	 new
		 Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]"))).selectByVisibleText(monthString);
	 
	 for(int tr=1;tr<=6;tr++)
	 {
	 for(int td=1;td<=7;td++){
	
	 String
	 row=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr["+tr+"]/td["+td+"]")).getText();
	
	 String
	 xxx=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr["+tr+"]/td["+td+"]")).getCssValue(row);
	
	
	 if(!xxx.isEmpty()){
	 int row1=Integer.parseInt(row);
	 if(row1==day)
	 {
	
	 driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr["+tr+"]/td["+td+"]")).click();
	tr=10;td=10;
	 }
	
	 }
	
	 }
	
	 }
	
	       
}catch(Exception e)
 {
e.printStackTrace();
 }
 return new int[] {month1, year1};
 
	}
 
 
 public ResultSet SQLserverConnection(String query) throws ClassNotFoundException, SQLException {
	 
//	 String query = 
//
//	 "Select PANNo FROM tblRegisteredClients where Gender='M'"; 

	 Class.forName(

	 "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  
	 Connection connection = DriverManager.getConnection(

	 "jdbc:sqlserver://192.168.1.121;database=evcadmin1.68c;integratedSecurity=true;");
	  
	 Statement stmt = connection.createStatement();
	  
	 ResultSet rs = stmt.executeQuery(query);
	 
   return rs;
	  
	 }
 
 
}