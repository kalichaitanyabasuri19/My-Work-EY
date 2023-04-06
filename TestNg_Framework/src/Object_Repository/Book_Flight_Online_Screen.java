package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Flight_Online_Screen {
	WebDriver driver;
	public Book_Flight_Online_Screen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
		
		@FindBy(xpath="(//*[@data-date-format='dd/mm/yyyy'])[1]")
		public WebElement fromDateFormat;
		
		
		@FindBy(xpath="(//li[@class='ui-menu-item']//a)[1]")
		public WebElement selectcity;

		@FindBy(name="fromCity")
		public WebElement fromCity;

		
		@FindBy(name="toCity")
		public WebElement toCity;
		
		@FindBy(xpath="(//*[@data-date-format='dd/mm/yyyy'])[2]")
		public WebElement toDateFormat;
		
		
		@FindBy(xpath="(//td[@class='day  active'])[3]")
		public WebElement activedate;
		
		@FindBy(xpath="(//td[@class='day  active'])[4]")
		public WebElement toactivedate;
	
		@FindBy(name="adults")
		public WebElement adults;
		
		@FindBy(name="childs")
		public WebElement childs;
		
		@FindBy(name="infants")
		public WebElement infants;

		@FindBy(name="cabinClass")
		public WebElement cabinClass;
		
		
		@FindBy(id="searchFlightsBtn")
		public WebElement searchFlightsBtn;
		
		@FindBy(name="returnDate")
		public WebElement returnDate;
		
		
		public WebElement nextdate(String activedatevalue) throws InterruptedException {
			toDateFormat.click();
			Thread.sleep(2000);
//			int activedatevalue=Integer.parseInt(a);
//			if(activedatevalue<30 && activedatevalue>1) {
//				activedatevalue++;
//			}
			WebElement e=driver.findElement(By.xpath("//td[@class='day ' and text()='"+activedatevalue+"']"));
			return e;
		}
		public WebElement selectdate(String activedatevalue) throws InterruptedException {
			
			fromDateFormat.click();
			Thread.sleep(2000);
			WebElement e=driver.findElement(By.xpath("//td[@class='day ' and text()='"+activedatevalue+"']"));
			return e;
		}
		
		public WebElement selectto(String value) throws InterruptedException {
			WebElement e=driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//a[contains(text(),'"+value+"')]"));
			Thread.sleep(2000);
			return e;
		}
		
		

}
