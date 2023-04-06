package Object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Screen {

	WebDriver driver;
	public Login_Screen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//ul[contains(@class,'nav navbar-nav navbar-right margin-right-logo')]//li[@class='dropdown loggedout']")
	public WebElement customerloginbtn;
	
	
	@FindBy(css="div.navbar-collapse.paddingleft0 > ul > li.dropdown.loggedout > ul > li:nth-child(1) > a")
//	@FindBy(xpath="(//ul[@class='dropdown-menu user-login']//a[text()='User Login'])[2]")
	public WebElement userloginoption;
	
	@FindBy(id="sign_user_email")
	public WebElement inputenteremail;
	
	@FindBy(id="sign_user_password")
	public WebElement inputenterpwd;
	
	@FindBy(css="#modalLogin > div > div > div.modal-body > form > button")
//	@FindBy(xpath="(//button[text()='Log in'])[1]")
	public WebElement loginbtn;
	
//	@FindBy(css="#menu-mobile-offcanvas-menu > li.dropdown.loggedin > a")
	@FindBy(xpath="//div[@class='navbar-collapse paddingleft0']//a[contains(normalize-space(),'Welcome')]")
	public WebElement welcometext;
	
	@FindBy(xpath="//li[contains(text(),'This value should be a valid email.')]")
	public WebElement emailvalidationtext;
	
	@FindBy(xpath="//*[text()='Incorrect email address and password combination. Please try again.']")
	public WebElement passwordinvalidmsg;
	
	@FindBy(xpath="(//li[contains(text(),'This value is required.')])[1]")
	public WebElement errorValidationusrname;
	
	@FindBy(xpath="(//li[contains(text(),'This value is required.')])[2]")
	public WebElement errorValidationpwd;
	
	@FindBy(css="#modalMsg > div > div > div.modal-header > button")
//	@FindBy(xpath="(//button[@data-dismiss=\"modal\"])[2]")
	public WebElement closeerror;
	
	
	

	
}
