package Reusables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v105.browser.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class common_methods extends Browser  {

	public common_methods() {
		// TODO Auto-generated constructor stub
	
	}
	
	public void EnterValuesIntoTextBox(WebDriver driver, WebElement ele,String value) {
		try {
		Wait(driver,"visibility",ele);
		ele.clear();
		ele.sendKeys(value);
		Reporter.log(value + "  is Entered in to the " +  ele.getAccessibleName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void click(WebDriver driver, WebElement ele) {
		try {
			Wait(driver,"click",ele);
			ele.click();
			Reporter.log( ele.toString() + " is clicked sucessfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Wait(WebDriver driver,String ActionType,WebElement ele) {
		
		try {
			WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(60));
			switch(ActionType) {
			case "click":
				w.until(ExpectedConditions.elementToBeClickable(ele));
			   break;
			   
			case "visibility":
				w.until(ExpectedConditions.visibilityOf(ele));
			   break;
			   
			case "selected":
				w.until(ExpectedConditions.elementToBeSelected(ele));
			   break;
			   
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyText(WebDriver driver, WebElement ele,String message) {
		try {
			Wait(driver,"visibility",ele);
			Assert.assertEquals(gettextofWebElement(driver,ele), message);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String gettextofWebElement(WebDriver driver, WebElement ele) {
		Wait(driver,"visibility", ele);
		return ele.getText();
	}
	public void verifyDropdown(WebDriver driver, WebElement ele) {
		
	}
	public void cleartext(WebDriver driver, WebElement ele) {
		Wait(driver,"visibility", ele);
		ele.click();
		ele.clear();
	}
	
	public void selectBytext(WebElement ele,String value) {
	
		new Select(ele).selectByVisibleText(value);
		Reporter.log("Selected the " + value + " in to the Select options of  " +  ele.getAccessibleName());
	}
	
	public void selectByvalue(WebElement ele,String value) {
		
		new Select(ele).selectByValue(value);
		Reporter.log("Selected the " + value + " in to the Select options of  " +  ele.getAccessibleName());
	}
	
	public void selectByIndex(WebElement ele,int value) {
		
		new Select(ele).selectByIndex(value);
		Reporter.log("Selected the " + value + " in to the Select options of  " +  ele.getAriaRole());
	}

	 public  Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	 
	 public void Takescreenshot(WebDriver driver, String filename) {
		 
		try {
		
			
		}
		catch(Exception e) {
			
		}
	 }
	 public void scrollandclick(WebDriver driver , WebElement e) {
		 
		 try {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("window.scrollBy(0,100)", "");
			Thread.sleep(2000);
			e.click();
			
		 }
		 catch(Exception e1) {
			 e1.printStackTrace();
		 }
	 }
	 public boolean checkElement( WebElement e) {
		 
		 try {
			boolean b=false;
			e.isDisplayed();
			b=true;
			 return b;
		 }
		 catch(NoSuchElementException e1) {
			
			 return false;
		 }
		
	 }
	 public boolean checkElementclickable(WebDriver driver, WebElement e) {
		 
		 try {
			 Wait(driver,"click",e);
			 return true;
		 }
		 catch(NoSuchElementException e1) {
			 
			 return false;
		 }
		 
	 }
	 
	 public void selectDate(WebDriver driver,String year,String month, String select_day) throws InterruptedException
	 { 
		    driver.findElement(By.name("departDate")).click();
		    driver.findElement(By.xpath("(//div[@class='datepicker dropdown-menu' and contains(@style,'display')]//th)[2]")).click();
			 driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display')]//th[@class='switch' and text()='2022']")).click();
			driver.findElement(By.xpath("(//span[contains(@class,'year') and text()="+year+"])[3]")).click();
//			if(checkElement(driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")))==true) {
//				driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();
//			}
			driver.findElement(By.name("departDate")).click();
			driver.findElement(By.xpath("((//div[@class='datepicker-days'])[3]//th)[2]")).click();
//			driver.findElement(By.xpath("((//div[@class='datepicker-months'])[3]//th)[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[contains(@class,'month') and text()='"+month+"'])[3]")).click();
			driver.findElement(By.name("departDate")).click();
			Thread.sleep(3000);
			 driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display')]//td[@class='day 'and text()='"+select_day+"']")).click(); 
			
	 
	 }
	 public void selectDateto(WebDriver driver,String year,String month, String select_day) throws InterruptedException
	 { 
		 driver.findElement(By.name("returnDate")).click();
		 driver.findElement(By.xpath("(//div[@class='datepicker dropdown-menu' and contains(@style,'display')]//th)[2]")).click();
		 driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display')]//th[@class='switch' and text()='2022']")).click();
		 driver.findElement(By.xpath("(//span[contains(@class,'year') and text()="+year+"])[4]")).click();
		 if(checkElement(driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")))==true) {
				driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();
			}
		 driver.findElement(By.name("returnDate")).click();
		 driver.findElement(By.xpath("((//div[@class='datepicker-days'])[4]//th)[2]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//span[contains(@class,'month') and text()='"+month+"'])[4]")).click();
		 driver.findElement(By.name("returnDate")).click();
		 Thread.sleep(3000);
			 driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display')]//td[@class='day 'and text()='"+select_day+"']")).click(); 
	 }
}
