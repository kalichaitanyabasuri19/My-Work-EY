package Object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flight_Data {
	
	WebDriver driver;
	public Flight_Data(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//div[@class='welcomePageModalSheetContent']//div[@aria-label='close']")
	public WebElement close;
	
	@FindBy(id="modify-search-btn")
	public WebElement search;
	
	@FindBy(xpath="//iframe[@data-testid='dialog_iframe']")
	public WebElement closeframe;
	
	@FindBy(xpath="//li[@class='ui-menu-item']//a")
	public List<WebElement> dest;
	
	@FindBy(css=" div > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(5)")
//	@FindBy(xpath="(//div[@class='col-xs-6 col-md-6']//span[4])[1]")
	public WebElement date;
	
	@FindBy(css="div.fligh-results-row.searchflight_box.searchflight_box_oneward.silver_border2.silver_border > div.flight-detail-bar > div.row.col-md-4 >a")
//	@FindBy(xpath="(//div[@class='flight-detail-bar']//a)[1]")
	public WebElement flightbookdetails;
	
	@FindBy(css="div.fligh-results-row.searchflight_box.searchflight_box_return.silver_border2.silver_border > div.flight-detail-bar > div.row.col-md-4 >a")
//	@FindBy(xpath="(//div[@id='result1']//div//a)[1]")
	public WebElement flightbookdetails2;
	
	@FindBy(xpath="//button[text()='Book Now']")
	public WebElement booknowbtn;
	
	@FindBy(css="#modalBaggageAllowance > div > div > div.modal-header > button")
	public  WebElement close2;
	@FindBy(css="#fare_rules_modal > div.modal-header > button")
	public  WebElement close3;
	
	@FindBy(xpath="//div[@class='row22']//div[@class='col-md-12']//div")
	public  List<WebElement> flightinfo;
	
	
	@FindBy(xpath="//div[@class='row']//div[@class='row FlightInfoBox']/div/div/label//div[@class='col-xs-2 col-md-2 leftlogo air-logo']//span")
	public List <WebElement> flights;
	
}
